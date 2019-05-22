package se.iths.Selenid;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class momondo {

    @Test
    public void login() {
        open("https://www.momondo.se/trips");
        $(By.id("c9qVj-dialog-body")).shouldBe(Condition.visible);
        //$(By.xpath("//*[@id=\\\"mNb4-soundsGood\\\"]")).shouldBe(Condition.visible);
        $(By.xpath("//*[@id=\"mMoq-login\"]/span/font/font")).click();
        //$(By.xpath("//*[@id=\"gLQJ-dialog-close\"]/svg")).shouldBe(Condition. visible);
        //Assert.assertEquals("Låter bra", );
        //Selenide.switchTo().alert().accept();
        //$(By.id("LEPo-soundsGood")).pressEnter();
        //$(By.xpath("//*[@id=\"o9q7-login\"]/span/font/font"));
        //$(By.xpath("//*[@id=\"mNb4-soundsGood\"]")).click();
        //sleep(3000);
        //$(By.xpath("//*[@id=\"fHdC-linkToRegister\"]/button/font/font"));
        //sleep(4000);
        //$(By.xpath("//*[@id=\"pK5Y-username\"]")).sendKeys("abc@yahoo.com");
        //$(By.xpath("//*[@id=\"pK5Y-password\"]")).sendKeys("AbcD1234@");
        //$(By.xpath("//*[@id=\"RZk2-submit\"]/span/font/font")).click();
        //Assert.assertEquals("We take the security of your password seriously. ", By.xpath("//*[@id=\"fHdC-error\"]/font[1]/font[1]"));
    }
}
