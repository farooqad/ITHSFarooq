package se.iths.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import se.iths.selenium.pages.TopMenu;

import java.util.List;

public class SeleniumHqTest {

    WebDriver chrome;

    @Before
    public void startBrowser() {
        chrome = new ChromeDriver();
    }

    @After
    public void closeBrowser() {
        chrome.quit();
    }

    @Test
    public void searchForChromeInSereachBoxAndCheckThatFirstHitIsGithub() {

        chrome.get("https://www.seleniumhq.org");
        WebElement searchBox = chrome.findElement(By.id("q"));
        searchBox.sendKeys("chrome");
        searchBox.submit();

        WebElement firstSearchHit = chrome.findElement(By.xpath("//*[@id=\"___gcse_0\"]/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[2]/div[2]"));

        Assert.assertEquals(
                "https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver",
                firstSearchHit.getText()
        );
    }

    @Test
    public void validateVersion() {

        chrome.get("https://www.seleniumhq.org");


        WebElement versionText = chrome.findElement(By.xpath("//*[@id=\"mainContent\"]/p[3]/a"));

        Assert.assertEquals(
                "3.141.59",
                versionText.getText()
        );
    }

    @Test
    public void validateVersion1() {
        chrome.get("https://www.seleniumhq.org");


        WebElement versionText = chrome.findElement(By.xpath("//*[@id=\"container\"]"));

        TopMenu topMenu = new TopMenu(chrome);
        topMenu.clickDownloadTab();

        Assert.assertEquals(
                "3.141.59",
                versionText.getText()
        );
    }

    @Test
    public void validateVersion2() {
        chrome.get("https://www.seleniumhq.org");

        TopMenu topMenu = new TopMenu(chrome);
        topMenu.clickSupportTab();
        List<WebElement> optionCount = chrome.findElements(By.cssSelector("h2"));
        System.out.println(optionCount.size());
    }


    @Test
    public List<String> allcontributers() {
        chrome.get("https://www.seleniumhq.org");

        TopMenu topMenu = new TopMenu(chrome);
        topMenu.clickAboutTab();
        List<WebElement> optionCount = chrome.findElements(By.cssSelector(".Contributor>h3>a"));

    }
}