package utils;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import readers.property.PropertyReader;
import readers.textFiles.TextFileReader;

import java.util.List;
import java.util.Random;

public class TestBase {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static JavascriptExecutor jse;
    protected static String url;

    public TestBase(){
        driver = Driver.getDriver();
        wait = Driver.getWait();
        jse = (JavascriptExecutor) driver;
        url = PropertyReader.read().get("url");
    }
    protected String randomClickGetText(List<WebElement> elements){
        Random random = new Random();
        int randomIndex = random.nextInt(elements.size());
        WebElement randomLink = elements.get(randomIndex);
        click(randomLink);
        String selectedRegHotelNum = randomLink.getText();
        return selectedRegHotelNum.replaceAll("\\D","");
    }
    protected void multiClick(int num,WebElement element){
        for (int i = 0; i < num; i++) {
            click(element);
        }
    }
    protected void scrollIntoWiev(WebElement element) {
        jse.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    //
    protected void click(WebElement element) {
        wait.until(driver1 -> {
            try {
                jse.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px solid black;')", element);
                element.click();
                return true;
            } catch (Exception e1) {
                try {
                    jse.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px solid black;')", element);jse.executeScript("arguments[0].setAttribute('style','background:yellow;')", element);
                    new Actions(driver1).moveToElement(element).click().perform();
                    return true;
                } catch (Exception e2) {
                    try {
                        jse.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px solid black;')", element);                        ((JavascriptExecutor) driver1).executeScript("arguments[0].click", element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }
                }
            }
        });
    }


    protected void sendKeys(WebElement element, String text){
        wait.until(driver1 ->{
            try {
                jse.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px solid black;')", element);jse.executeScript("arguments[0].setAttribute('style','background:yellow;')", element);
                element.sendKeys(text);
                return true;
            }catch (Exception e1){
                try {
                    jse.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px solid black;')", element);jse.executeScript("arguments[0].setAttribute('style','background:yellow;')", element);
                    new Actions(driver1).moveToElement(element).sendKeys(text).perform();
                    return true;
                }catch (Exception e2){
                    try {
                        jse.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px solid black;')", element);jse.executeScript("arguments[0].setAttribute('style','background:yellow;')", element);
                        ((JavascriptExecutor) driver1).executeScript("argumenst[0].value='"+text+"'", element);
                        return true;
                    }catch (Exception e3){
                        return false;
                    }
                }
            }
        });
    }


    protected boolean isAttributeContains(WebElement element,String attribute,String text){
        if(element.getAttribute(attribute).contains(text)){
            return true;
        }else
            return false;
    }
    protected void isEqual(String actual, String expected){
        Assert.assertEquals(expected,actual);
    }
    protected void isNotEqual(String actual, String unexpected){
        Assert.assertNotEquals(unexpected,actual);
    }
    protected void isTrue(Boolean bool){
        Assert.assertTrue(bool);
    }
    protected void isDisplayed(WebElement element){
        Assert.assertTrue(element.isDisplayed());
    }


    @AfterAll
     protected static void after(){
        Driver.quitDriver();
    }

}
