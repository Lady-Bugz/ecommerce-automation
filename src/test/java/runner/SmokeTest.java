package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "steps",
        dryRun = true,
        tags ="@smoke",
        monochrome = true,
        plugin ={"pretty"}

)



public class SmokeTest {

}
