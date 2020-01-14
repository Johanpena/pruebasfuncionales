package rapicredito.devops.cliente.originacion.definicion;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import rapicredito.devops.cliente.originacion.steps.CrearclienteSteps;

import java.util.List;


public class OriginacionDefinicion {

    @Steps
    CrearclienteSteps creacionclientesteps;

    @Then("^valido que me encuentro en la pagina de registro$")
    public void valido_que_me_encuentro_en_la_pagina_de_registro () throws Exception {
        creacionclientesteps.validarpagina();
    }

    @When("^ingreso las credenciales para la prueba$")
    public void ingreso_las_credenciales_para_la_prueba(List<String> data) {
        creacionclientesteps.creacion(data);
    }


    @When("^registro credenciales2$")
    public void ingreso_las_credenciales_para_la_prueba2(List<String> data) {
        creacionclientesteps.creacion2(data);
    }

    @Then("^puedo ver el usuario creado (.*)$")
    public void puedo_ver_el_usuario_creado(String titulo) throws Exception {
        creacionclientesteps.validarusuariocreado(titulo);
    }






}
