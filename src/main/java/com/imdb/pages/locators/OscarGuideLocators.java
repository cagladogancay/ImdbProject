package com.imdb.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.util.List;

public class OscarGuideLocators {

    @FindBy(how = How.CSS, using = "#imdbHeader-navDrawerOpen--desktop path:nth-child(2)")
    public WebElement menuBtn;
    @FindBy(how = How.LINK_TEXT, using = "Oscars")
    public WebElement oscarsLink;
    @FindBy(how = How.LINK_TEXT, using = "1929")
    public WebElement eventHistoryLink;
    @FindBy(how = How.CSS, css = "div[class='event-widgets__award']:last-of-type>h3>div>div>div>div:first-of-type")
    public WebElement honaryAwardDiv;
    @FindBy(how = How.LINK_TEXT, using = "The Jazz Singer")
    public WebElement honaryAwardLink;
    @FindBy(how = How.LINK_TEXT, using = "Alan Crosland")
    public WebElement director;
    @FindBys({
            @FindBy(how = How.LINK_TEXT, using = "Samson Raphaelson"),
            @FindBy(how = How.LINK_TEXT, using = "Alfred A. Cohn")
    })
    public List<WebElement> writerList;

    @FindBys({
            @FindBy(how = How.LINK_TEXT, using = "Al Jolson"),
            @FindBy(how = How.LINK_TEXT, using = "May McAvoy")
    })
    public List<WebElement> starList;
}
