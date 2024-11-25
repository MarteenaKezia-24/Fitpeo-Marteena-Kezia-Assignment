package fitpeo;
import org.junit.runner.RunWith;   
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;  

@RunWith(Cucumber.class) 
@CucumberOptions(features="\\src\\test\\resources\\Features\\Fitpeo.feature",
					glue={"fitpeo"},
					monochrome = true,
					plugin = { "pretty", "junit:target/cucumber-reports/Cucumber.xml" }
//						tags="@Test"
		)
public class TestRunner {

}
