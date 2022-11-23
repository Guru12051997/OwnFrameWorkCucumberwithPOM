package TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
		"C:\\Users\\Guru Prasad Das\\Desktop\\Struggle\\eclipse storage\\OwnCucumberBDDFrameworkWithPOM\\src\\test\\resources\\AppFeatureFiles\\LoginPage.feature" }, glue = {
				"StepDefinitions", "AppHooks" }, monochrome = true, plugin = { "pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"timeline:test-output-thread/"

}

)

public class MyTestRunnerTestng extends AbstractTestNGCucumberTests {

}
