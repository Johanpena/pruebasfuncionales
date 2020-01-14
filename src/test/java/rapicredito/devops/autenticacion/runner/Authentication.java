package rapicredito.devops.autenticacion.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/rapicredito/devops/features/autenticacion/authentication.feature",
        glue={"rapicredito.devops.autenticacion.definicion"}
)
public class Authentication{
}
