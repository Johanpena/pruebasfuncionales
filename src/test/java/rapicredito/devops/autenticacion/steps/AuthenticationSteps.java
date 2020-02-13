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

    public  void ipsospechosa (String ip){

    }


    public void validateRegistredIp() throws SQLException, IOException {
        Conexion_BD con = new Conexion_BD();
        Connection bd = con.main();
        ResultSet resultIp =  bd.createStatement().executeQuery("select * from ip_data_response where document=74852024 order by id desc");
        if (resultIp.next()){
            Assert.assertEquals(resultIp.getString("ip"),obtenerIp());
        }else{
            Assert.assertEquals(obtenerIp(),"No se econtraron registros en la BD.");
        }


    }
}
