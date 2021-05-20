package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
							//	"src/test/java/features/login.feature", 
							//	"src/test/java/features/CreateLead.feature",
							//	"src/test/java/features/EditLead.feature",
							//	"src/test/java/features/DuplicateLead.feature",
								"src/test/java/features/DeleteLead.feature"
							},
				 glue = "steps",
				 monochrome = true,
				 plugin = "pretty",
				 publish = true,
				 tags = "@regression")
public class CucumberRunner extends AbstractTestNGCucumberTests{
	
}
