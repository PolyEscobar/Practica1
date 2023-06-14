package Hooks;

import Utils.BrowserUtils;
import org.junit.Before;
import static pages.BasePage.driver;

public class Hooks {
    public static String windowSize = System.getProperty("windowSize");
    @Before
    public void setUp (){
        if(windowSize != null){
            System.out.println("window size:" +windowSize);
            BrowserUtils.setWindowsSize(driver, windowSize);
        } else {
            BrowserUtils.maxWindowSize(driver);
        }
    }
}
