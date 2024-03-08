package pageObjects.mainPage;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageObjects  {
    public MainPageObjects(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@id='wrap-close-button-1454703513202']//span[@class='ins-close-button']")
    public WebElement dialogCloseButton;
    @FindBy(xpath = "//div[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowallSelectionWrapper']//a[contains(text(),'Tümüne izin ver')]")
    public WebElement acceptCookies;
    @FindBy(xpath = "//button[@class='sc-25740042-1 jmbIRo']")
    public WebElement hotelTabi;
    @FindBy(xpath = "//input[@aria-label='search-input']")
    public WebElement cityInputBox;
    @FindBy(xpath = "(//div[@class='sc-f548111d-3 eMIiFe'])[1]")
    public WebElement firstCity;
    @FindBy(xpath = "//div[@class='sc-bf3a6118-0 VntNS']")
    public  WebElement dateInputBox;
    @FindBy(xpath = "(//div[@class='CalendarMonth CalendarMonth_1'])[3]//table//td//span[text()='1']")
    public WebElement holidayStartDate;
    @FindBy(xpath = "(//div[@class='CalendarMonth CalendarMonth_1'])[3]//table//td//span[text()='7']")
    public WebElement holidayEndDate;
    @FindBy(xpath = "//div[@class='sc-b2c3f6ee-18 bRTqaJ']")
    public WebElement hmRoomhmPeopleInputBox;
    @FindBy(xpath = "(//button[@data-testid='increment-button'])[1]")
    public WebElement increaseAdultNum;
    @FindBy(xpath = "//button[@type='button']")
    public WebElement searchButton;
}
