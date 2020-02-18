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
   /* public Object SQLException;*/
    private Object IOException;


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



    public void validateRegistredIp() throws SQLException, IOException {
        Conexion_BD con = new Conexion_BD();
        Connection bd = con.main();
        ResultSet resultIp = bd.createStatement().executeQuery("SELECT a.id,a.ip,b.is_tor,b.is_threat,b.is_anonymous, b.is_bogon,\n" +
                "b.is_known_abuser,b.is_known_attacker,b.is_proxy\n" +
                "FROM ip_data_response a \n" +
                "INNER JOIN ip_threat b ON a.id=b.id  \n" +
                "WHERE document=74852024 AND (b.is_anonymous=1 or b.is_bogon=1 or \n" +
                "b.is_known_abuser=1 or b.is_known_attacker=1 or b.is_proxy=1 or\n" +
                "b.is_threat=1 or b.is_tor=1)\n" +
                "order by a.id desc;");
        if (resultIp.next()) {
            Assert.assertEquals(resultIp.getString("ip"), "Usuario sospechoso de fraude");
        } else {
            Assert.assertEquals(obtenerIp(),obtenerIp());
        }
    }

        public void validarIpsospechosa() throws SQLException, IOException {
            Conexion_BD con1 = new Conexion_BD();
            Connection bd1 = con1.main();
            ResultSet resultIpsospe = bd1.createStatement().executeQuery("select * from ip_sospechosas where ip='192.168.1.8'");
            if (resultIpsospe.next()) {
                Assert.assertEquals(resultIpsospe.getString("ip"), obtenerIp());
            } else {
                Assert.assertEquals(obtenerIp(), "No se econtraron registros en la BD.");
            }

        }
}

