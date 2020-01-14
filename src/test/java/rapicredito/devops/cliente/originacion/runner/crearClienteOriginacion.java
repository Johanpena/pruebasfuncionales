package rapicredito.devops.cliente.originacion.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/rapicredito/devops/features/cliente/originacion/crearClienteOriginacion.feature",
        glue={"rapicredito.devops"}
)
public class crearClienteOriginacion
  {

}




