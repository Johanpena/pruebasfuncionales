package rapicredito.devops.autenticacion.steps;

import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import rapicredito.devops.pages.AutenticacionPage;
import rapicredito.devops.pages.IndexPage;

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
}
