package rapicredito.devops.cliente.originacion.steps;

import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import rapicredito.devops.cliente.originacion.pageobjets.ClientOriginPage;
import rapicredito.devops.pages.AutenticacionPage;
import rapicredito.devops.pages.IndexPage;
import rapicredito.devops.pages.RegistroClientePage;
import rapicredito.devops.pages.RegistroIndexPage;

import java.util.List;

public class CrearclienteSteps {

    @Page
        ClientOriginPage clientobjets;


    public void creacion(List<String> data) {
        clientobjets.nombre1Input.sendKeys(data.get(0).toString());
        clientobjets.nombre2Input.sendKeys(data.get(1).toString());
        clientobjets.apellido1Input.sendKeys(data.get(2).toString());
        clientobjets.apellido2Input.sendKeys(data.get(3).toString());
        clientobjets.tipodocumentoInput.selectByValue(data.get(4).toString());
        clientobjets.documentoInput.sendKeys(data.get(5).toString());
        clientobjets.correoInput.sendKeys(data.get(6).toString());
        clientobjets.celularInput.sendKeys(data.get(7).toString());
        clientobjets.contraseInput.sendKeys(data.get(8).toString());
        clientobjets.contrase2Input.sendKeys(data.get(9).toString());
        clientobjets.terminosInput.click();
        clientobjets.botoncontinuarInput.click();

    }

    public void creacion2(List<String> data) {
        clientobjets.ciudadInput.selectByValue(data.get(0).toString());
        clientobjets.direccionInput.sendKeys(data.get(1).toString());
        clientobjets.tipoviviendaInput.selectByValue(data.get(2).toString());
        clientobjets.tiempoviviInput.selectByValue(data.get(3).toString());
        clientobjets.generoInput.selectByValue(data.get(4).toString());
        clientobjets.fnacimientoInput.sendKeys(data.get(5).toString());
//        clientobjets.estadocivilInput.selectByValue(data.get(6).toString());
//        clientobjets.personascargoInput.selectByValue(data.get(7).toString());
//        clientobjets.hijosInput.selectByValue(data.get(8).toString());
//        clientobjets.fexpedicionInput.sendKeys(data.get(9).toString());
//        clientobjets.nivelestudioInput.sendKeys(data.get(10).toString());
//        clientobjets.estadoestudioInput.sendKeys(data.get(11).toString());

    }



    @Step
    public void registro(String nombre1, String nombre2,String apellido1, String apellido2, String tipodocumento, String documento,String correo, String celular, String contrase, String confirmarcontrase){
  //      registroClientePage.setCredentials(nombre1,nombre2,apellido1,apellido2,tipodocumento,documento,correo,celular,contrase,confirmarcontrase);
    }
//TODO

    public void validarpagina() {
//        registroClientePage.validacionpagina();

    }

    public void validarusuariocreado(String titulo) {
        //registroIndexPage.validarusuariocreado(titulo);

    }



}
