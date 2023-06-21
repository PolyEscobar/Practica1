package Hooks;

import Utils.BrowserUtils;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;

import static pages.BasePage.driver;

public class Hooks {
    public static String windowSize = System.getProperty("windowSize");

    @Before
    public void setUp (){
        if(windowSize != null){
            System.out.println("window size:" + windowSize);
            BrowserUtils.setWindowsSize(driver, windowSize);
        } else {
            BrowserUtils.maxWindowSize(driver);
        }
    }

    @AfterStep
    public void addScreenshot(Scenario scenario){
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
            System.out.println("The screenshot is done");
        }
    }

    @AfterAll
    public static void tearDown(){
        BasePage.closeBrowser();
    }
}
