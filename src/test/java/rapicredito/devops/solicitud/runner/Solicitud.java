package rapicredito.devops.solicitud.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/rapicredito/devops/features/solicitud/solicitud.feature",
        glue={"rapicredito.devops.solicitud.definicion"},tags="@escenario1"
)
public class Solicitud {
}
