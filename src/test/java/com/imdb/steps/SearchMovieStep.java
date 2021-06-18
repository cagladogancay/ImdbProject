package com.imdb.steps;

import com.imdb.utils.SeleniumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class SearchMovieStep {
    @When("Arama çubuğuna {string} yazılır.")
    public void aramaÇubuğunaJazzSingerYazılır(String movieName) {
        SeleniumDriver.getDriver().findElement(By.cssSelector("input[id='suggestion-search']")).sendKeys(movieName);
    }

    @And("Sonuçlar arasında gelen The Jazz Singer tıklanır.")
    public void sonuçlarArasındaGelenTheJazzSingerTıklanır() {
        SeleniumDriver.getDriver().findElement(By.cssSelector("div>ul>li:nth-of-type(3)>a[data-testid='search-result--const']")).click();
    }


}
