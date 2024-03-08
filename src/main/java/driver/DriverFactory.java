package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import readers.property.PropertyReader;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
   static PropertyReader prop = PropertyReader.read();
    public static WebDriver createChrome(){
        ChromeOptions options = new ChromeOptions();
        for (String s : prop.get("chrome.options").split(",")){
            options.addArguments(s.trim());
        }
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);// 2, bildirimleri engellemek anlamına gelir
        options.setExperimentalOption("prefs", prefs);
        return new ChromeDriver(options);
    }
    public static WebDriver createFirefox(){
        FirefoxOptions options = new FirefoxOptions();
        for (String s : prop.get("firefox.options").split(",")){
            options.addArguments(s.trim());
        }
        return new FirefoxDriver(options);
    }

    public  static WebDriver createEdge(){
        EdgeOptions options =new EdgeOptions();
        for (String s : prop.get("edge.options").split(",")){
            options.addArguments(s.trim());
        }
        return new EdgeDriver(options);
    }
    public static WebDriver createSafari(){
        if (!System.getProperty("os.name").toLowerCase().contains("mac"))
            throw new WebDriverException("Your OS doesn't support Safari");
        SafariOptions options = new SafariOptions();
        options.setCapability("safari.cleanSession", true);
        options.setAutomaticInspection(true);
        options.getUseTechnologyPreview();
        return new SafariDriver(options);
    }
}
