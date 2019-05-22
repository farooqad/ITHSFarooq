package se.iths.selenium;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Contains;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.iths.selenium.pages.webshop.AutomationPracticeLogin;
import se.iths.selenium.pages.webshop.User;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static se.iths.selenium.pages.webshop.User.slaskUser;

public class momondo {
    WebDriver chrome;
    @Before
    public void startBrowser(){
        chrome = new ChromeDriver();
    }

    @Test
    public void create_a_unique_user() throws InterruptedException {
        chrome.get("https://www.momondo.se/");
        chrome.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        /*Cookie cookie = new Cookie.Builder("name", "value")
                .domain(".momondo.se")
                .expiresOn(new Date(2015, 10, 28))
                .isHttpOnly(true)
                .isSecure(false)
                .path("/mypath")
                .build();
        //chrome.manage().addCookie(cookie);
        chrome.manage().deleteAllCookies();*/
        //chrome.refresh();

        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-popup-blocking");
        //chrome = new ChromeDriver(options);

        //String JS_DISABLE_UNLOAD_DIALOG = "Object.defineProperty(BeforeUnloadEvent.prototype, 'returnValue', { get:function(){}, set:function(){} })";
        //((JavascriptExecutor)chrome).executeScript(JS_DISABLE_UNLOAD_DIALOG);

        //chrome.switchTo().alert().getText();

        //Wait<WebDriver> wait = new FluentWait<>(chrome).withTimeout(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
               // Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        //alert.accept();
       // chrome.findElement(By.xpath("//*[@id=\"DXP3-dialog-close\"]/svg")).click();
       //chrome.findElement(By.xpath("//*[@id=\"common-icon-brands-momondo-x-icon\"]/path")).click();

        //chrome.manage().window().maximize();
      //  WebDriverWait wait = new WebDriverWait(chrome, 5);

        //element.sendKeys(Keys.ESCAPE);
     //   chrome.getWindowHandle();
      //  String myWindowHandle = chrome.getWindowHandle();
        //System.out.println("before the window1");
        //Thread.sleep(5000);
        //System.out.println("before the window2");
        //for (String winhandle: chrome.getWindowHandles()) {

            //chrome.manage().window().maximize();
            //chrome.switchTo().window(winhandle);
            //chrome.getWindowHandles();
            //chrome.manage().deleteAllCookies();
           // chrome.switchTo().alert().accept();
          //  chrome.switchTo().alert().dismiss();


//            System.out.println("Window Switch");

  //          WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tgci-login\"]/div/svg")));
    //        element.click();
            //chrome.findElement(By.xpath("//*[@id=\"tgci-login\"]/div/svg")).click();



         //   chrome.findElement(By.xpath("(//button[span[contains(text(),'Close')]])[1]")).click();


        //Alert printDialog = chrome.switchTo().alert();
       // printDialog.dismiss();
        //chrome.findElement(By.xpath("//*[@id=\"U23N-dialog-close\"]/svg")).click();
        //chrome.findElement(By.xpath("//*[@id=\"bXGV-dialog-close\"]/svg")).click();
        //chrome.findElement(By.xpath("//*[@id=\"V9OK-login\"]/span/font/font")).click();
       //chrome.findElement(By.xpath("//*[@id=\"venZ-linkToRegister\"]/button/font/font")).click();
    }

    private void Login(){
    }
    public void login(User user){
        chrome.findElement(By.xpath("//*[@id=\"c9bgk-username\"]")).sendKeys(user.getUsername());
        chrome.findElement(By.xpath("//*[@id=\"c9bgk-password\"]")).sendKeys(user.getPassword());
    }
    private void login(){
        chrome.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

        login(slaskUser());
        chrome.findElement(By.xpath("//*[@id=\"c9bgk-submit\"]/span/font/font")).click();
    }
}

