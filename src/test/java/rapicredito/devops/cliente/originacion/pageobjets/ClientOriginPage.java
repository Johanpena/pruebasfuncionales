package rapicredito.devops.cliente.originacion.pageobjets;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://playrefactor.rapicredit.com/app/signUp")
public class ClientOriginPage extends PageObject {

    @FindBy(name ="primerNombre")
    public WebElementFacade nombre1Input;

    @FindBy(name="segundoNombre")
    public WebElementFacade nombre2Input;

    @FindBy(name = "primerApellido")
    public WebElementFacade apellido1Input;

    @FindBy(name = "segundoApellido")
    public WebElementFacade apellido2Input;

    @FindBy(name = "identificationType")
    public WebElementFacade tipodocumentoInput;

    @FindBy(name = "identificationNumber")
    public  WebElementFacade documentoInput;

    @FindBy(name = "email")
    public WebElementFacade correoInput;

    @FindBy(name = "mobile")
    public WebElementFacade celularInput;

    @FindBy(name = "password")
    public WebElementFacade contraseInput;

    @FindBy(name = "rePassword")
    public WebElementFacade contrase2Input;

    @FindBy(name = "termsAndConditions")
    public WebElementFacade terminosInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div/div[2]/div[2]/div[2]/form/div[7]/div[2]/div/button")
    public  WebElementFacade botoncontinuarInput;

    @FindBy(id="react-select-2-input")
    public WebElementFacade ciudadInput;

    @FindBy(name="residenceAddress")
    public WebElementFacade direccionInput;


    @FindBy(name="housingType")
    public WebElementFacade tipoviviendaInput;

    @FindBy(name="timeResidance")
    public WebElementFacade tiempoviviInput;


    @FindBy(name="gender")
    public WebElementFacade generoInput;

    @FindBy(className="residenceAddress")
    public WebElementFacade fnacimientoInput;





    @FindBy(className = "mainTitle")
    public WebElementFacade tituloPpal;
}
