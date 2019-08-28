package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = "tests",
        plugin = {"pretty", "html:reports"},
        snippets = SnippetType.CAMELCASE
)
public class Runner {
}
