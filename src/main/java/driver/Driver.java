package driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.WatchEvent;
import java.time.Duration;

import static driver.DriverFactory.*;

public class Driver {
   private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
   private static ThreadLocal<WebDriverWait> waits = new ThreadLocal<>();
   private static ThreadLocal<Browsers> browsers = new ThreadLocal<>();
   static Logger logger = LogManager.getLogger();

   public static WebDriver getDriver(){
       if(browsers.get() == null)
           browsers.set(Browsers.CHROME);
       return getDriver(browsers.get());
   }
    public static WebDriver getDriver (Browsers browser){
        browsers.set(browser);
        if(drivers.get() == null){
            switch (browser){
                case FIREFOX:
                    drivers.set(createFirefox());
                    break;
                case EDGE:
                    drivers.set(createEdge());
                    break;
                case SAFARI:
                    drivers.set(createSafari());
                    break;
                default:
                    drivers.set(createChrome());
                    break;
            }
        }
        waits.set(new WebDriverWait(drivers.get(), Duration.ofSeconds(15)));
        return drivers.get();
    }
    public static WebDriverWait getWait(){
        return waits.get();
    }
    public static void quitDriver(){
        if(drivers.get() != null){
            drivers.get().quit();
            drivers.set(null);
        }
    }
}
