package SeturTatilPlanlamaSenaryoları;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import pageObjects.hotelsPage.HotelsPageMethods;
import pageObjects.mainPage.MainPageMethods;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Antalya {
    MainPageMethods mainPage = new MainPageMethods();
    HotelsPageMethods hotelsPage = new HotelsPageMethods();

    @Test
    @Order(1)
    public void goToUrl() {
        mainPage.goToMainPage();
    }

    @Test
    @Order(2)
    public void checkUrl() {
        mainPage.isUrlCorrect();
    }

    @Test
    @Order(3)
    public void checkHotelTab() {
        mainPage.checkHotelTabIsDefault();
    }

    @Test
    @Order(4)
    public void holidayCity() {
        mainPage.writeHolidayCity();
    }

    @Test
    @Order(5)
    public void selectDate() {
        mainPage.selectHolidayDates();
    }

    @Test
    @Order(6)
    public void numOfAdults() {
        mainPage.increasePeopleNumAndCheck();
    }

    @Test
    @Order(7)
    public void searchButton() {
        mainPage.checkSearchButtonAndClick();
    }
    @Test
    @Order(8)
    public void checkCityInUrl(){
        hotelsPage.checkUrlContainsCityName();
    }
    @Test
    @Order(9)
    public void randomClicksOnShowOtherAreas(){
        hotelsPage.randomClickOnOthers();
    }
    @Test
    @Order(10)
    public void scrollBotAndCheck(){
        hotelsPage.scrollAndCheckBottomTextIfExist();
    }

}
