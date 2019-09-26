package rapicredito.devops.cliente.originacion.definicion;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import rapicredito.devops.cliente.originacion.steps.CrearclienteSteps;


public class OriginacionDefinicion {

    @Steps
    CrearclienteSteps creacionclientesteps;

    @Given("^me encuentro en la pagina de inicio$")
    public void me_encuentro_en_la_pagina_de_inicio() throws Exception {
        creacionclientesteps.openPage();
    }

    @Then("^valido que me encuentro en la paguina de registro$")
    public void valido_que_me_encuentro_en_la_paguina_de_registro () throws Exception {
        creacionclientesteps.validarpagina();
    }

    @When("^ingreso las credenciales (.*), (.*) ,(.*), (.*),(.*), (.*), (.*),(.*). (.*),(.*)$")
    public void ingreso_las_credenciales(String nombre1, String nombre2,String apellido1, String apellido2, String tipodocumento, String documento,String correo, String celular, String contrase, String confirmarcontrase)
            throws Exception {
        creacionclientesteps.registro(nombre1,nombre2,apellido1,apellido2,tipodocumento,documento,correo,celular,contrase,confirmarcontrase);
    }

    @Then("^puedo ver el usuario creado (.*)$")
    public void puedo_ver_el_usuario_creado(String titulo) throws Exception {
        creacionclientesteps.validarusuariocreado(titulo);
    }






}
