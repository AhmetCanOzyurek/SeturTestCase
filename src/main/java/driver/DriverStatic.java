package driver;

import org.openqa.selenium.WebDriver;

import static driver.DriverFactory.*;

public class DriverStatic {
    private static WebDriver driver;

    public static WebDriver getDriver(Browsers browser){
        if(driver == null){
            switch (browser){
                case FIREFOX:
                    driver = createFirefox();
                    break;
                case EDGE:
                    driver = createEdge();
                    break;
                case SAFARI:
                    driver = createSafari();
                    break;
                default:
                    driver = createChrome();
                    break;
            }
        }
        return driver;
    }
    public static void quitDriver(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
