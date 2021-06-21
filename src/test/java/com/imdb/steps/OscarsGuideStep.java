package com.imdb.steps;

import com.imdb.pages.actions.OscarGuideActions;
import com.imdb.utils.SeleniumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;

import java.util.List;

public class OscarsGuideStep {
    OscarGuideActions oscarGuideActions;

    @Before
    public void setUp() {
        SeleniumDriver.setUpDriver();
    }

    @Given("{string} adresine gidilir")
    public void adresineGidilir(String websiteUrl) {
        SeleniumDriver.openPage(websiteUrl);
    }

    @When("Arama çubuğunun sol tarafında bulunan menü butonuna basılır")
    public void aramaCubugununSolTarafindaBulunanMenuButonunaBasilir() {
        oscarGuideActions = new OscarGuideActions(SeleniumDriver.driver);

        oscarGuideActions.goToMenu();
    }

    @And("Award & Events başlığı altında bulunan Oscars butonuna basılır")
    public void awardEventsBasligiAltindaBulunanOscarsButonunaBasilir() {
        oscarGuideActions = new OscarGuideActions(SeleniumDriver.driver);
        oscarGuideActions.goToOscars();
    }

    @And("“Event History” başlığı altında 1929 değeri seçilir")
    public void eventHistoryBasligiAltindaDegeriSecilir() {
        oscarGuideActions = new OscarGuideActions(SeleniumDriver.driver);
        oscarGuideActions.goToEventHistory();
    }

    @And("“Honorary Award” başlığı altında “Caz Mugannisi” seçilir")
    public void honoraryAwardBasligiAltindaCazMugannisiSecilir() {
        oscarGuideActions = new OscarGuideActions(SeleniumDriver.driver);
        oscarGuideActions.findandgoToHonaryAward();
    }

    @Then("Director ismi {string}")
    public void directorIsmi(String isim) {
        oscarGuideActions = new OscarGuideActions(SeleniumDriver.driver);
        oscarGuideActions.checkDirector(isim);
    }

    @And("Writer isimleri")
    public void writerIsimleri(List<String> writers) {
        oscarGuideActions = new OscarGuideActions(SeleniumDriver.driver);
        oscarGuideActions.checkWriters(writers);
    }

    @And("Stars  isimleri")
    public void starsIsimleri(List<String> stars) {
        oscarGuideActions = new OscarGuideActions((SeleniumDriver.driver));
        oscarGuideActions.checkStars(stars);
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
