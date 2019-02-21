package se.iths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankCustomer {
    WebDriver myBrowser;

    @Before
    public void setUpBrowser() {
        myBrowser = new ChromeDriver();
    }

    @After
    public void closeBrowser() {
        //myBrowser.quit();
    }

    @Test
    public void bankManagerLogin()
    {

       // myBrowser.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
        //ExpectedCondition ex = ExpectedCondition.
        //WebDriverWait wait = new WebDriverWait(myBrowser, 15);
        //WebElement findbtn = myBrowser.findElement(By.xpath("#btn btn-primary btn-lg"));


    }


}
