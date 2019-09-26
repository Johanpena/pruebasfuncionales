package rapicredito.devops.cliente.originacion.steps;

import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import rapicredito.devops.pages.AutenticacionPage;
import rapicredito.devops.pages.IndexPage;
import rapicredito.devops.pages.RegistroClientePage;
import rapicredito.devops.pages.RegistroIndexPage;

public class CrearclienteSteps {

    @Page
    RegistroClientePage registroClientePage;

    @Page
    RegistroIndexPage registroIndexPage;


    @Step
    public void openPage() {
        registroClientePage.open();
    }



    @Step
    public void registro(String nombre1, String nombre2,String apellido1, String apellido2, String tipodocumento, String documento,String correo, String celular, String contrase, String confirmarcontrase){
        registroClientePage.setCredentials(nombre1,nombre2,apellido1,apellido2,tipodocumento,documento,correo,celular,contrase,confirmarcontrase);
    }


    public void validarpagina() {
        registroClientePage.validacionpagina();

    }

    public void validarusuariocreado(String titulo) {
        registroIndexPage.validarusuariocreado(titulo);

    }
}
