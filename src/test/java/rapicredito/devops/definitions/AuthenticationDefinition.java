package rapicredito.devops.definitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import rapicredito.devops.steps.AuthenticationSteps;

public class AuthenticationDefinition {

	@Steps
    AuthenticationSteps authenticationSteps;

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
    	authenticationSteps.valiationProfile(perfil);
    }


}
