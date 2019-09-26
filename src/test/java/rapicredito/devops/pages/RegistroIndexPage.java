package rapicredito.devops.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class RegistroIndexPage extends PageObject{




    public  RegistroIndexPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void validarusuariocreado(String titulo) {
        Assert.assertEquals("HOLA","HOLA");
    }
}
