package pageObjects.mainPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import readers.csv.CsvReader;
import utils.TestBase;

public class MainPageMethods extends TestBase {

    MainPageObjects pageObjects ;
    Logger logger = LogManager.getLogger();
    public MainPageMethods(){
        pageObjects = new MainPageObjects();
    }
    public void goToMainPage(){
        logger.info("Driver config.property dosyasından okunan url'e gitti.Acilan dialogu kapattı ve çerezleri kabul etti.");
        driver.get(url);
        click(pageObjects.dialogCloseButton);
        click(pageObjects.acceptCookies);
    }
    public void isUrlCorrect(){
        logger.info("Driver anasayfanın url'sini çekti ve beklenen url ile asıl url assertion ile karsilastirildi.");
        String actualUrl = driver.getCurrentUrl();
        isEqual(actualUrl,url);
    }
    public void checkHotelTabIsDefault(){
        logger.info("Anasayfa acildiginde hotel tabinin default olarak secili geldigi, secili olan elementin class attribute farkliligi uzerinden test edildi.");
        WebElement element = pageObjects.hotelTabi;
        isTrue(isAttributeContains(element,"class","jmbIRo"));
    }
    public void writeHolidayCity(){
        logger.info("'Nereye Gideceksiniz?' yazan tatil sehri input kutusuna csv dosyasından 'Antalya' yazildi ve en üstteki Antalya secenegine tiklandi.");
        String city = CsvReader.getCityName();
        sendKeys(pageObjects.cityInputBox,city);
        click(pageObjects.cityInputBox);
        click(pageObjects.firstCity);
    }
    public void selectHolidayDates(){
        logger.info("'Kac Oda Kac Kisi' yazan tarih girme yerine Nisan'ın ilk haftasi icin bir haftalik aralik secildi.");
        click(pageObjects.dateInputBox);
        click(pageObjects.holidayStartDate);
        click(pageObjects.holidayEndDate);
    }
    public void increasePeopleNumAndCheck(){
        logger.info("Yetiskin sayisi 1 artirildi ve yetiskin sayisinin degistigi kontrol edildi.");
        WebElement element = pageObjects.hmRoomhmPeopleInputBox;
        String beforeIncrement = element.getText();
        click(element);
        multiClick(1,pageObjects.increaseAdultNum);
        String afterIncrement = element.getText();
        isNotEqual(beforeIncrement,afterIncrement);
        click(element);
    }
    public void checkSearchButtonAndClick(){
        logger.info("Ara butonunun gorunurlugu kontrol edildi ve tiklandi.");
        isDisplayed(pageObjects.searchButton);
        click(pageObjects.searchButton);
    }
}
