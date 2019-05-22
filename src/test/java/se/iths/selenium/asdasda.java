package se.iths.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * class description
 */

public class asdasda {
    WebDriver driver;




    public asdasda() {
    }

    /**
     * Set up browser settings and open the application
     */

    @Before
    public void setUp() {
        driver.get("https://www.momondo.se/");
        // Opened the application
        driver.manage().window().maximize();
    }

    /**
     * Test to check Select functionality
     * @throws InterruptedException
     */

    @Test
    public void testWebAlert() throws InterruptedException {
        // clicking on try it button
        driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
        Thread.sleep(5000);

        // accepting javascript alert
        Alert alert = driver.switchTo().alert();
        alert.accept();


        // clicking on try it button
        driver.findElement(By.name("låter bra"));
        Thread.sleep(5000);

        // accepting javascript alert
        driver.switchTo().alert().dismiss();

        // clicking on try it button
        driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
        Thread.sleep(5000);

        // accepting javascript alert
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    /**
     * Tear down the setup after test completes
     */

    @After
    public void tearDown() {
        driver.quit();
    }
} 