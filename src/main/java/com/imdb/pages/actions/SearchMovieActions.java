package com.imdb.pages.actions;

import com.imdb.pages.locators.SearchMovieLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchMovieActions {
    WebDriver driver;
    SearchMovieLocators searchMovieLocators;

    public SearchMovieActions(WebDriver driver) {
        this.driver = driver;
        this.searchMovieLocators = new SearchMovieLocators();
        PageFactory.initElements(this.driver, searchMovieLocators);
    }
    public void searchInput(String movieName){
        searchMovieLocators.searchInput.sendKeys(movieName);
    }
    public void selectMovie(){
        searchMovieLocators.selectMovie.click();
    }
}
