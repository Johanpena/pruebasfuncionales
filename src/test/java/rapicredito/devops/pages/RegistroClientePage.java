package rapicredito.devops.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("http://playrefactor.rapicredit.com/app/signUp?amount=250000&term=30&total=340371")
public class RegistroClientePage extends PageObject{

    public  RegistroClientePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(name ="primerNombre")
    WebElementFacade nombre1Input;

    @FindBy(name="segundoNombre")
    WebElementFacade nombre2Input;

    @FindBy(name = "primerApellido")
    WebElementFacade apellido1Input;

    @FindBy(name = "segundoApellido")
    WebElementFacade apellido2Input;

    @FindBy(name = "identificationType")
    WebElementFacade tipodocumentoInput;

    @FindBy(name = "identificationNumber")
    WebElementFacade documentoInput;

    @FindBy(name = "email")
    WebElementFacade correoInput;


    @FindBy(name = "mobile")
    WebElementFacade celularInput;

    @FindBy(name = "password")
    WebElementFacade contraseInput;

    @FindBy(name = "rePassword")
    WebElementFacade contrase2Input;

    @FindBy(name = "termsAndConditions")
    WebElementFacade terminosInput;


    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div/div[2]/div[2]/div[2]/form/div[7]/div[2]/div/button")
    WebElementFacade botoncontinuarInput;

    @FindBy(className = "mainTitle")
    WebElementFacade tituloPpal;

    public void validateIndex() {
        terminosInput.click();
    }

    public void setCredentials(String nombre1, String nombre2,String apellido1, String apellido2, String tipodocumento, String documento,String correo, String celular, String contrase, String confirmarcontrase) {
        nombre1Input.clear();
        nombre1Input.type(nombre1);
        nombre2Input.clear();
        nombre2Input.type(nombre2);
        apellido1Input.clear();
        apellido1Input.type(apellido1);
        apellido2Input.clear();
        apellido2Input.type(apellido2);
        tipodocumentoInput.selectByIndex(Integer.valueOf(tipodocumento));
       //tipodocumentoInput.type(tipodocumento);
        documentoInput.clear();
        documentoInput.type(documento);
        correoInput.clear();
        correoInput.type(correo);
        celularInput.clear();
        celularInput.type(celular);
        contraseInput.clear();
        contraseInput.type(contrase);
        contrase2Input.clear();
        contrase2Input.type(confirmarcontrase);
        terminosInput.click();
    }

    public void registrar() {
        botoncontinuarInput.click();
    }

    public void validacionpagina() {
        Assert.assertEquals(tituloPpal.getText().toString(),"Ingresa tus datos como aparecen en tu cédula");

    }
}





