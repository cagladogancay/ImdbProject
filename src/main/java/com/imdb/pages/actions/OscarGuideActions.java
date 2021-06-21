package com.imdb.pages.actions;

import com.imdb.pages.locators.OscarGuideLocators;
import com.imdb.utils.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;



import java.util.List;

import static org.junit.Assert.assertEquals;

public class OscarGuideActions {
    WebDriver driver;
    OscarGuideLocators oscarGuideLocators;

    public OscarGuideActions(WebDriver driver) {
        this.driver = driver;
        this.oscarGuideLocators = new OscarGuideLocators();
        PageFactory.initElements(driver, oscarGuideLocators);
    }

    public void goToMenu() {
        oscarGuideLocators.menuBtn.click();
    }

    public void goToOscars() {
        oscarGuideLocators.oscarsLink.click();
    }

    public void goToEventHistory() {
        oscarGuideLocators.eventHistoryLink.click();
    }

    public void findandgoToHonaryAward() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", oscarGuideLocators.honaryAwardDiv);
        SeleniumDriver.waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='event-widgets__award']:last-of-type>h3>div>div>div>div:first-of-type")));
        oscarGuideLocators.honaryAwardLink.click();
    }

    public void checkDirector(String director) {
        assertEquals(oscarGuideLocators.director.getText(), director);

    }

    public void checkWriters(List<String> writers) {
        for (int i = 0; i < oscarGuideLocators.writerList.size(); i++) {
           assertEquals(i, writers);
        }

    }

    public void checkStars(List<String> stars) {
        for (int i = 0; i < oscarGuideLocators.starList.size(); i++) {
            assertEquals(i, stars);

        }
    }
}


