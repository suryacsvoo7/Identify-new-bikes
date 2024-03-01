package testcase;
 
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
	@CucumberOptions(
			//features= {".//FeatureFiles/Feature.feature"},
		features= {".//Features"},
			glue={"stepdefinationfile"},
			plugin= {"html:Reports/CucumberReport.html",
					  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

	public class testrunner {

	}
