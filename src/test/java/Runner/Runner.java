package Runner;

import Utils.HtmlReportGenerator;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {
                "StepDefinitions",
                "Hooks"
        },
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:report/cucumber-report/cucumber.html",
                "json:report/cucumber-report/cucumber.json",
                "rerun:rerun/failed_scenarios.txt",
                "usage:report/cucumber-report/usage.txt"
        },
        stepNotifications = true
)
public class Runner {
        @AfterClass
        public static void report() throws Exception {
                HtmlReportGenerator.convertJsonToHtml();
        }
}