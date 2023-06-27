package Hooks;

import Utils.BrowserUtils;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;

import static pages.BasePage.driver;

public class Hooks {
    public static String windowSize = System.getProperty("windowSize");

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
    public void addScreenshot(Scenario scenario){
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
            System.out.println("The screenshot is done");
        }
    }

    @After
    public void afterScenario(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @AfterAll
    public static void tearDown(){
        BasePage.closeBrowser();
    }
}
