package rapicredito.devops.solicitud.definicion;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import rapicredito.devops.autenticacion.steps.AuthenticationSteps;



public class SolicitudDefinicion {

    @Steps
    AuthenticationSteps authenticationSteps;

    @Given("^me encuentro en la pagina de miscreditos$")
    public void meEncuentroEnLaPaginaDeMiscreditos() throws Exception {
        authenticationSteps.openPage();
       /* authenticationSteps.login();
*/
    }





}











