package se.iths;

import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class addAcountSelenid {

    @Test
        public void addCustomer()
    {
        open("http://www.way2automation.com/angularjs-protractor/banking/#/login");
        $(By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/div[2]/button")).click();
        $(By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/button[1]")).click();
        $(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div[1]/input")).sendKeys("farff");
        $(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div[2]/input")).sendKeys("ahmff");
        $(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div[3]/input")).sendKeys("434343");
        $(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/button")).click();
        Selenide.switchTo().alert().accept();
    }





}
