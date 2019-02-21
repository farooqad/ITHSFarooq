package se.iths.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenu {

    WebDriver driver;

    public TopMenu(WebDriver driver){
        this.driver = driver;
    }

    public void clickDownloadTab(){

        WebElement downloadLink = driver.findElement(By.xpath("//*[@id=\"menu_download\"]/a"));
        downloadLink.click();
    }
    public void clickSupportTab(){

        WebElement SupportLink = driver.findElement(By.xpath("//*[@id=\"menu_support\"]/a"));
        SupportLink.click();
    }

    public void clickAboutTab(){

        WebElement AboutLink = driver.findElement(By.xpath("//*[@id=\"menu_about\"]/a"));
        AboutLink.click();
    }
    public void clickSearchBox()
    {
        WebElement SearchBox = driver.findElement(By.xpath("//*[@id=\"q\"]"));
        SearchBox.sendKeys("Chrome");
    }
    public void clickGoButton()
    {
        WebElement SearchBox = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        SearchBox.click();
    }
    public String confirmLink()
    {
        WebElement SearchBox = driver.findElement(By.xpath("//*[@id=\"___gcse_0\"]/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[1]/div/a"));
        return SearchBox.getText();
    }


}
