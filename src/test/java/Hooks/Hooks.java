package Hooks;

import Utils.BrowserUtils;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

import static pages.BasePage.driver;

public class Hooks {
    public static String windowSize = System.getProperty("windowSize");
    String featureTag;
    long start = System.currentTimeMillis();

    @Before
    public void setUp (){
        BasePage.setUp();
        if(windowSize != null){
            System.out.println("window size:" + windowSize);
            BrowserUtils.setWindowsSize(driver, windowSize);
        } else {
            BrowserUtils.maxWindowSize(driver);
        }
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        boolean fullSteps = Boolean.parseBoolean(System.getProperty("fullSteps"));
        if (scenario.isFailed() | fullSteps) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
            System.out.println("-- Added screenshot");
        }
    }

    @Before
    public void beforeFeature(Scenario scenario) {
        featureTag = scenario.getSourceTagNames().toString();
        System.out.println("\n---------- Start of Scenario: " + featureTag + " -----------------------");
    }

    @After
    public void afterScenario() {
        long stop = System.currentTimeMillis();
        long actualTimeMinutes = (TimeUnit.MILLISECONDS.toSeconds(stop - start)) / 60;
        long actualTimeSeconds = (TimeUnit.MILLISECONDS.toSeconds(stop - start)) % 60;
        System.out.println("---------- End of Scenario: " + featureTag + " - Execution time: " + actualTimeMinutes + "min " + actualTimeSeconds + "s -----------------------");
        driver.manage().deleteAllCookies();
        BasePage.closeBrowser();
    }

    @AfterAll
    public static void tearDown(){
        BasePage.closeBrowser();
    }
}
