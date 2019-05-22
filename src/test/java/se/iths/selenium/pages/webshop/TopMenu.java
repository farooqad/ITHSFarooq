package se.iths.selenium.pages.webshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenu {

    WebDriver myBrowser;

    public TopMenu(WebDriver driver){
        this.myBrowser = driver;
    }

    public void clickDownloadTab(){

        WebElement downloadLink = myBrowser.findElement(By.xpath("//*[@id=\"menu_download\"]/a"));
        downloadLink.click();
    }
    public void clickSupportTab(){

        WebElement downloadLink = myBrowser.findElement(By.xpath("//*[@id=\"menu_support\"]/a"));
        downloadLink.click();
    }
}
