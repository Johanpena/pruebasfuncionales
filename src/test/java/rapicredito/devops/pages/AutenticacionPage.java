package rapicredito.devops.pages;


import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.mockito.internal.matchers.Equals;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("http://playrefactor.rapicredit.com/app/signUp")
public class AutenticacionPage extends PageObject{
	
	public  AutenticacionPage(WebDriver webDriver) {
		super(webDriver);
	}

	@FindBy(id="password")
    WebElementFacade passwordField;

	@FindBy(id="username")
    WebElementFacade usernameField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div/div[1]/div/div[1]/div[2]/div/button")
    WebElementFacade soyClliente;

    @FindBy(xpath = "//*[@id=\"loginForm\"]/div/div[2]/div[2]/div[3]/div[1]/div[5]/div/button")
    WebElementFacade botonLogin;

    @FindBy(id="error-msg")
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

			Assert.assertEquals(claseobejtomensje.getValue(), error);


	}
}
