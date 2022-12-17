package software;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
    features = "features",
    glue = "software",
    snippets = SnippetType.CAMELCASE
)


public class AcceptanceTest {

}


