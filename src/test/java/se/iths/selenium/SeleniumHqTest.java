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
import se.iths.selenium.pages.webshop.DownloadPage;

import java.util.List;
import java.util.stream.Collectors;

public class SeleniumHqTest {

    WebDriver myBrowser;
    TopMenu topMenu = new TopMenu(myBrowser);
    @Before
    public void startBrowser(){
        myBrowser = new ChromeDriver();
    }

    @After
    public void closeBrowser(){
        myBrowser.quit();
    }

    @Test
    public void chromDriverSearch(){

        myBrowser.get("https://www.seleniumhq.org");
        WebElement searchBox = myBrowser.findElement(By.id("q"));
        searchBox.sendKeys("chrome");
        searchBox.submit();

        WebElement firstSearchHit = myBrowser.findElement(By.xpath("//*[@id=\"___gcse_0\"]/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[2]/div[2]"));

        Assert.assertEquals(
                "https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver",
                firstSearchHit.getText()
        );
    }

    @Test
    public void validateVersion(){

        myBrowser.get("https://www.seleniumhq.org");

        topMenu.clickDownloadTab();

        DownloadPage dp = new DownloadPage(myBrowser);
        Version version = dp.getVersion();
        Assert.assertEquals(
                "3.141.59",
                version.toString()
        );
    }

    @Test
    public void countNumberOfHeadings() throws InterruptedException {
        topMenu.clickSupportTab();
        Thread.sleep(30000);
        List<WebElement> h2= myBrowser.findElements(By.tagName("<h2>"));
        h2.size();
        Assert.assertEquals(
                "2",
                h2.size()
        );
    }

    @Test
    public void testAllLinksOnDownloadPage(){

        myBrowser.get("https://www.seleniumhq.org");
        TopMenu topMenu = new TopMenu(myBrowser);
        topMenu.clickDownloadTab();

        myBrowser.findElements(By.cssSelector("#mainContent > table:nth-child(29) > tbody > tr > td:nth-child(1) > a"))
                .stream()
                .map(webElement -> webElement.getAttribute("href"))
                .collect(Collectors.toList())
                .forEach(url -> {
                    myBrowser.get(url);
                    Assert.assertFalse(myBrowser.getTitle().contains("404"));
                });
    }
    @Test
    public void validateAllLinksOnThirdPartDownloads() {

        myBrowser.get("https://www.seleniumhq.org");
        TopMenu topMenu = new TopMenu(myBrowser);
        topMenu.clickDownloadTab();

        myBrowser.findElements(By.cssSelector("#mainContent > table:nth-child(29) > tbody > tr > td:nth-child(1) > a"))
                .stream()
                .map(webElement -> webElement.getAttribute("href"))
                .collect(Collectors.toSet())
                .stream()
                .forEach(s -> {
                    myBrowser.get(s);
                    Assert.assertFalse(myBrowser.getTitle().contains("404"));
                });
    }

    @Test
    public void liljeholmenToTcentral(){
        myBrowser.get("https://sl.se/sv/");
        myBrowser.findElement(By.xpath("//*[@id=\"travelplanner_from\"]")).sendKeys("liljeholmen");
        myBrowser.findElement(By.xpath("//*[@id=\"travelplanner_to\"]")).sendKeys("Tcentralen (Stockholm)");
        myBrowser.findElement(By.xpath("//*[@id=\"Travelplanner\"]/div[5]/span")).click();
        Assert.assertFalse(myBrowser.getTitle().contains("! Time passed"));
    }
}
