package se.iths.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.iths.selenium.pages.webshop.AutomationPracticeLogin;

import static se.iths.selenium.pages.webshop.User.slaskUser;

public class ShoppningTest {

    WebDriver myBrowser;

    @Before
    public void startBrowser(){
        myBrowser = WebDriverHelper.createWebDriver();
    }

    @After
    public void closeBrowser(){
        myBrowser.quit();
    }

    By signInButton = By.xpath("//*[@id=\"SubmitLogin\"]/span");
    By searchBox = By.xpath("//*[@id=\"search_query_top\"]");
    By searchBoxButton = By.xpath("//*[@id=\"searchbox\"]/button");
    By addToCartButton = By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]/span");
    By proceedToCheckoutButton = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
    By ProceedToCheckoutButton1 = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span");
    By proceedToCheckoutButton2 = By.xpath("//*[@id=\"center_column\"]/form/p/button/span");
    By agreeToTermsCheckBox = By.xpath("//*[@id=\"cgv\"]");
    By getProceedToCheckoutButton3 = By.xpath("//*[@id=\"form\"]/p/button/span");
    By payByBank = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");
    By confirmMyOrderButton = By.xpath("//*[@id=\"cart_navigation\"]/button/span");
    By orderConfirmation = By.xpath("//*[@id=\"center_column\"]/div/p/strong");

    @Test
    public void shopping() throws InterruptedException {
        login();
        myBrowser.findElement(searchBox).sendKeys("Printed Chiffon Dress");
        myBrowser.findElement(searchBoxButton).click();
        myBrowser.findElement(addToCartButton).click();
        Thread.sleep(4000);
        myBrowser.findElement(proceedToCheckoutButton).click();
        myBrowser.findElement(ProceedToCheckoutButton1).click();
        myBrowser.findElement(proceedToCheckoutButton2).click();
        myBrowser.findElement(agreeToTermsCheckBox).click();
        myBrowser.findElement(getProceedToCheckoutButton3).click();
        myBrowser.findElement(payByBank).click();
        myBrowser.findElement(confirmMyOrderButton).click();
        Assert.assertEquals("Your order on My Store is complete.", myBrowser.findElement(orderConfirmation).getText());
    }

    private void login(){
        myBrowser.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        AutomationPracticeLogin loginPage = new AutomationPracticeLogin(myBrowser);
        loginPage.login(slaskUser());
        myBrowser.findElement(signInButton).click();
    }
}
