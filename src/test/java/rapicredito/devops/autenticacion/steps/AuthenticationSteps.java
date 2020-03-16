package rapicredito.devops.autenticacion.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EqualsUtils;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import rapicredito.devops.pages.AutenticacionPage;
import rapicredito.devops.pages.IndexPage;
import rapicredito.devops.utilidades.Conexion_BD;
import rapicredito.devops.utilidades.IpPublica;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static rapicredito.devops.utilidades.IpPublica.obtenerIp;

public class AuthenticationSteps {

    @Page
    AutenticacionPage autenticacionPage;

    @Page
    IndexPage indexPage;

    @Step
    public void openPage() {
        autenticacionPage.open();
    }

    @Step
    public void login(String user, String password) {
        autenticacionPage.setCredentials(user, password);
        autenticacionPage.login();
    }

    @Step
    public void validationBackground() {
        autenticacionPage.validateIndex();
    }

    public void valiationProfile(String profile) {
        indexPage.validateProfile(profile);
    }

    public void validarMensaje() {
        autenticacionPage.validarHomePage();
    }

    public void mensajeError(String error) {
        autenticacionPage.validarError(error);
    }



    public void validateRegistredIp(String documento) throws Exception {
        Conexion_BD con = new Conexion_BD();
        Connection bd = con.main();
        String query = "SELECT a.id,a.ip,b.is_tor,b.is_threat,b.is_anonymous, b.is_bogon,\n" +
                "b.is_known_abuser,b.is_known_attacker,b.is_proxy\n" +
                "FROM rapicreditdbnewmodel.ip_data_response a \n" +
                "INNER JOIN rapicreditdbnewmodel.ip_threat b ON a.id=b.id  \n" +
                "WHERE a.id in(select max(id) from ip_data_response) and document="+documento;
        ResultSet resultIp = bd.createStatement().executeQuery(query);
        if (resultIp.next()) {
            Assert.assertEquals(obtenerIp(),resultIp.getString("ip"));
        } else {
            throw new Exception("No se registro la IP enla tabla ip_data_response");
        }
    }

    public void validarSinIpsospechosa() throws SQLException, IOException {
        Conexion_BD con1 = new Conexion_BD();
        Connection bd1 = con1.main();
        String ipActual = IpPublica.obtenerIp();
        ResultSet resultIpsospe = bd1.createStatement().executeQuery("SELECT * FROM rapicreditdbnewmodel.ip_sospechosas where ip='"+ipActual+"'");
        if (resultIpsospe.next()) {
            bd1.createStatement().executeUpdate("UPDATE rapicreditdbnewmodel.ip_sospechosas set activa=0");
        }
    }

    public void ingresarIpsospechosa() throws IOException, SQLException {
        Conexion_BD con1 = new Conexion_BD();
        Connection bd1 = con1.main();
        String ipActual = IpPublica.obtenerIp();
        ResultSet resultIpsospe = bd1.createStatement().executeQuery("SELECT * FROM rapicreditdbnewmodel.ip_sospechosas where ip='"+ipActual+"'");
        if (resultIpsospe.next()) {
            if (!resultIpsospe.getString("activa").equals(1)){
                bd1.createStatement().executeUpdate("UPDATE rapicreditdbnewmodel.ip_sospechosas set activa=1");
            }
        }else{
            bd1.createStatement().executeUpdate("INSERT INTO rapicreditdbnewmodel.ip_sospechosas (ip,activa,fecha) VALUES ( '"+ipActual+"' ,1,now())");
        }
    }

}

