package rapicredito.devops.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class IndexPage extends PageObject{

	public  IndexPage(WebDriver webDriver) {
		super(webDriver);
	}
	

	@FindBy(xpath = "/html/body/app-root/app-header/mat-toolbar/mat-toolbar-row/div/div/div/button")
	WebElementFacade usernameLabel;
	
	
	public void validateProfile(String profile) {
		Assert.assertEquals(profile, usernameLabel.getText().toString());
	}
}
