package com.imdb.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchMovieLocators {
    @FindBy(how = How.ID,using = "suggestion-search")
    public WebElement searchInput;

    @FindBy(how = How.CSS,using = "div>ul>li:nth-of-type(3)>a[data-testid='search-result--const']")
    public WebElement selectMovie;
}
