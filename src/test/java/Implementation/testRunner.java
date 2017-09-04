package Implementation;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Feature/task.feature"
		,glue={"stepDefinition"}
		)

public class testRunner {

}
