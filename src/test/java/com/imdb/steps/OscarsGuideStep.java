package com.imdb.steps;

import com.imdb.utils.SeleniumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class OscarsGuideStep {


    @Before
    public void setUp() {
        SeleniumDriver.setUpDriver();
    }

    @Given("{string} adresine gidilir")
    public void adresineGidilir(String websiteUrl) {
        SeleniumDriver.openPage(websiteUrl);
    }

    @When("Arama çubuğunun sol tarafında bulunan Menü butonuna basılır")
    public void aramaCubugununSolTarafindaBulunanMenuButonunaBasilir() throws InterruptedException {
        SeleniumDriver.getDriver().findElement(By.cssSelector("#imdbHeader-navDrawerOpen--desktop")).click();

    }

    @And("Award & Events başlığı altında bulunan Oscars butonuna basılır")
    public void awardEventsBasligiAltindaBulunanOscarsButonunaBasilir() {
        SeleniumDriver.getDriver().findElement(By.xpath("//a[@href='/oscars/?ref_=nv_ev_acd']")).click();
    }

    @And("“Event History” başlığı altında 1929 değeri seçilir")
    public void eventHistoryBasligiAltindaDegeriSecilir() {
        SeleniumDriver.getDriver().findElement(By.xpath("//a[normalize-space()='1929']")).click();
    }

    @And("“Honorary Award” başlığı altında “Caz Mugannisi” seçilir")
    public void honoraryAwardBasligiAltindaCazMugannisiSecilir() {
        JavascriptExecutor js = (JavascriptExecutor) SeleniumDriver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", SeleniumDriver.getDriver().findElement(By.cssSelector("div[class='event-widgets__award'] div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(2) div:nth-child(2) div:nth-child(1) span:nth-child(1) span:nth-child(1) a:nth-child(1)")));
        SeleniumDriver.waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='event-widgets__award'] div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(2) div:nth-child(2) div:nth-child(1) span:nth-child(1) span:nth-child(1) a:nth-child(1)"))).click();
    }

    @Then("Director ismi {string}")
    public void directorIsmi(String isim) {
        String director = SeleniumDriver.getDriver().findElement(By.linkText("Alan Crosland")).getText();
        Assert.assertEquals(director, isim);
    }

    @And("Writer ismi {string}")
    public void writerIsmi(String isim) {
        String writer = SeleniumDriver.getDriver().findElement(By.linkText("Samson Raphaelson")).getText();
        Assert.assertEquals(writer, isim);

    }

    @And("Stars  ismileri {string}")
    public void starsIsmileri(String isim) {
        String stars = SeleniumDriver.getDriver().findElement(By.linkText("Al Jolson")).getText();
        Assert.assertEquals(stars, isim);

    }

    @After
    public static void tearDown(Scenario scenario) {

        WebDriver driver = SeleniumDriver.getDriver();
        System.out.println(scenario.isFailed());
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
        SeleniumDriver.tearDown();
    }




}
