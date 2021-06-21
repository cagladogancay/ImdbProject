package com.imdb.steps;

import com.imdb.pages.actions.SearchMovieActions;
import com.imdb.utils.SeleniumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class SearchMovieStep {
    SearchMovieActions searchMovieActions;

    @When("Arama çubuğuna {string} yazılır.")
    public void aramaCubugunaJazzSingerYazilir(String movieName) {
        //  SeleniumDriver.getDriver().findElement(By.cssSelector("input[id='suggestion-search']")).sendKeys(movieName);
        searchMovieActions = new SearchMovieActions(SeleniumDriver.driver);
        searchMovieActions.searchInput(movieName);
    }

    @And("Sonuçlar arasında gelen The Jazz Singer tıklanır.")
    public void sonuclarArasindaGelenTheJazzSingerTiklanir() {
        // SeleniumDriver.getDriver().findElement(By.cssSelector("div>ul>li:nth-of-type(3)>a[data-testid='search-result--const']")).click();
        searchMovieActions = new SearchMovieActions(SeleniumDriver.driver);
        searchMovieActions.selectMovie();
    }


}
