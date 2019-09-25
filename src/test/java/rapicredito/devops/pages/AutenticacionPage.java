package rapicredito.devops.pages;


import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
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

    @FindBy(name= "circularBtn borderedButton")
    WebElementFacade soyClliente;

    @FindBy(name="circularBtn solidButton")
    WebElementFacade botonLogin;
    
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
}
