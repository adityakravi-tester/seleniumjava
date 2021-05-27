package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@CucumberOptions(
          features = "src/test/java/features",
          monochrome = true,
          plugin = {"pretty"},
       //   dryRun = true,
          tags = "@regression",
          snippets = SnippetType.CAMELCASE,
          glue = "steps"
    )
@RunWith(Cucumber.class)
public class CucumberRunnerJunit {

}
