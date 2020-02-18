package rapicredito.devops.autenticacion.definicion;


import com.mysql.cj.api.mysqla.result.Resultset;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import rapicredito.devops.autenticacion.steps.AuthenticationSteps;
import rapicredito.devops.utilidades.Conexion_BD;

import java.sql.Connection;
import java.sql.ResultSet;


public class AuthenticationDefinition {

	@Steps
    AuthenticationSteps authenticationSteps;
    private int anInt;
    private int row;

    @Given("^me encuentro en la pagina de inicio$")
    public void me_encuentro_en_la_pagina_de_inicio() throws Exception {
        authenticationSteps.openPage();
    }
    
    @Then("^debo encontrar la seccion para iniciar sesion$")
    public void debo_encontrar_la_seccion_para_iniciar_sesion() throws Exception {
        authenticationSteps.validationBackground();
    }

    @When("^ingreso las credenciales (.*) y el (.*)$")
    public void ingreso_las_credenciales(String user, String password) throws Exception {
        authenticationSteps.login(user, password);
    }

    @Then("^puedo ver el perfil del usuario (.*)$")
    public void puedo_ver_el_perfil_del_usuario(String perfil) throws Exception {
        authenticationSteps.validateRegistredIp();
    	authenticationSteps.valiationProfile(perfil);
    	/*authenticationSteps.validarIpsospechosa();*/
    }


    @Then("^retorno a la pagina de inicio$")
    public void retornoALaPaginaDeInicio() {
        authenticationSteps.validarMensaje();
    }

    @Then("^generar mensaje error <mensaje>(.*)$")
    public void generarMensajeErrorMensaje(String error) {
        authenticationSteps.mensajeError(error);
    }

    @Then("^rechazar ingreso a la aplicacion (.*)$")
    public void rechazarIngresoALaAplicacionIp(String ipsospechosa) {
       /* authenticationSteps.validarMensaje(ipsospechosa);*/
    }

    @When("^envio la ip sospechosa$")
    public void envioLaIpSospechosa() {


    }
}
