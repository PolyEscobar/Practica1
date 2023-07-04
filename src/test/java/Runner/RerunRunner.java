package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@rerun/failed_scenarios.txt",
        glue = {
                "StepDefinitions",
                "Hooks"
        },
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:report/cucumber-report/cucumber.html",
                "json:report/cucumber-report/cucumber.json",
                "usage:report/cucumber-report/usage.txt"
        },
        dryRun = false,
        monochrome = true,
        stepNotifications = true
)
public class RerunRunner {
}
