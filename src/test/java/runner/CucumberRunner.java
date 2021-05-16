package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
							//	"src/test/java/features/login.feature", 
								"src/test/java/features/CreateLead.feature"
							},
				 glue = "steps",
				 monochrome = true)
public class CucumberRunner extends AbstractTestNGCucumberTests{
	
}
