package myTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src\\main\\java\\features\\main.feature", //the path of the feature files
		glue={"stepDefinitions"}, //the path of the step definition files
		plugin= {"html:target/cucumber.html", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun = false,
		monochrome = true
//		strict = true
		//tags = {"@Timesheet"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {
}
