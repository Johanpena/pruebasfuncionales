package rapicredito.devops.pages;


import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.mockito.internal.matchers.Equals;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("http://client.test.rapicredit.com/login")
public class AutenticacionPage extends PageObject{
	
	public  AutenticacionPage(WebDriver webDriver) {

		super(webDriver);
	}

	@FindBy(id="password")
    WebElementFacade passwordField;

	@FindBy(id="username")
    WebElementFacade usernameField;

    @FindBy(id= "btn-login")
    WebElementFacade botonLogin;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div/div[1]/div/div[1]/div[2]/div/button")
	WebElementFacade soyClliente;

    @FindBy(id="swal2-content")
	WebElementFacade claseobejtomensje;
    
    public void validateIndex() {
		soyClliente.click();
	}

    public void setCredentials(String user, String password) {
		usernameField.clear();
		usernameField.type(user);
		passwordField.clear();
		passwordField.type(password);
	}
    
    public void login() {
       botonLogin.click();
    }

	public void validarHomePage() {
    	Assert.assertTrue(usernameField.isPresent());
		Assert.assertTrue(passwordField.isPresent());
	}

	public void validarError(String error) {
		claseobejtomensje.waitUntilPresent();
		Assert.assertEquals(error,claseobejtomensje.getText());
	}

}
