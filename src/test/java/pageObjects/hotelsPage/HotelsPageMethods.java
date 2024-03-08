package pageObjects.hotelsPage;

import com.google.j2objc.annotations.Weak;
import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import readers.csv.CsvReader;
import readers.property.PropertyReader;
import readers.textFiles.TextFileReader;
import utils.TestBase;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class HotelsPageMethods extends TestBase {
    HotelsPageObjects pageObjects = new HotelsPageObjects();
    Logger logger = LogManager.getLogger();
    public void checkUrlContainsCityName(){
        logger.info("Acilan url'nin 'antalya' kelimesini icerdigi, config.property dosyasından okunarak kontrol edildi.");
        String urlCityName = PropertyReader.read().get("city");
        wait.until(ExpectedConditions.titleContains("Antalya"));
        String actualUrl = driver.getCurrentUrl();
        isTrue(actualUrl.contains(urlCityName));
    }
    public void randomClickOnOthers(){
        logger.info("'Diğer Bölgeleri Göster' alaninda rastgele tiklama metodu ile secim yapildi ve parantez icinde bulunan sayi fileWriter ile text dosyasına kaydedildi.");
        click(pageObjects.showOtherRegions);
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='sc-e4b3cd20-0 ihtOYP']"));
        TextFileReader.writeTextFile("RegionHotelsNum",randomClickGetText(elements));

    }
    public void scrollAndCheckBottomTextIfExist() {
        logger.info("Bolgedeki otel sayisi kontrol edildi. Eger otel sayisi iki veya daha fazla sayfaya bolunecek kadar cok ise sayfanın asagisinda cikan 'Antalya Otelleri ve En Uygun Antalya Otel Fiyatları' alanına kadar inildi ve kaydedilen degerin 9.adimda kaydedilen degerle esit oldugu kontrol edildi. En sonunda icerisine otel sayısı yazılan dosyanın icerigi diger testler icin temizlendi.");
        int hotelNum = Integer.parseInt(TextFileReader.readTextFile("RegionHotelsNum"));
        if(hotelNum >= 25){
            scrollIntoWiev(pageObjects.botLinkedinLink);
            WebElement element = driver.findElement(By.xpath("//div[@class='sc-21021e1e-1 gPQAyQ']"));
            String bottomHotelsTxt = element.getText();
            isTrue(bottomHotelsTxt.contains(Integer.toString(hotelNum)));
        }
        TextFileReader.clearTextFile("RegionHotelsNum");
        Driver.quitDriver();
    }
}
