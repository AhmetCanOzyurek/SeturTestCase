package pageObjects.hotelsPage;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;

public class HotelsPageObjects {
    public HotelsPageObjects(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@data-testid='show-more-regions-button']")
    public WebElement showOtherRegions;
    @FindBy(xpath = "//a[@title='Setur Linkedin']")
    public WebElement botLinkedinLink;

}
