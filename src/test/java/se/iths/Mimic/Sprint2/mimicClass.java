package se.iths.Mimic.Sprint2;
import org.openqa.selenium.Keys;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class mimicClass {

    WebDriver myBrowser;

    @Before
    public void setUpBrowser() {
        myBrowser = new ChromeDriver();
    }

    @Test
    public void saveMultipleResponseByForm(){
        unlearn();
        localhost();
        WebElement textField = myBrowser.findElement(By.xpath("/html/body/form/textarea"));
        textField.click();
        textField.sendKeys("sweden" + Keys.ENTER + "denmark" + Keys.ENTER + "norway");
        WebElement learnResponse = myBrowser.findElement(By.xpath("//*[@id=\"learn\"]"));
        learnResponse.click();
        localhost();
        Assert.assertEquals("sweden\ndenmark\nnorway", myBrowser.findElement(By.xpath("/html/body")).getText());
    }

    @Test
    public void saveResponseWithXML() {
        unlearn();
        xmlResponse();
        localhost();
        Assert.assertEquals("<value>1</value>", myBrowser.findElement(By.cssSelector("body > div.pretty-print > div")).getText());
    }

    @Test
    public void saveResponseWithURL() {
        unlearn();
        stringResponse();
        localhost();
        Assert.assertEquals("Hello", myBrowser.findElement(By.xpath("/html/body")).getText());
    }

    private void unlearn(){ myBrowser.get("http://localhost:8080/unlearn"); }
    private void localhost() { myBrowser.get("http://localhost:8080"); }
    private void xmlResponse() { myBrowser.get("http://localhost:8080/LearnNextResponse?text=<value>1</value>&mime=application/xml"); }
    private void stringResponse() { myBrowser.get("http://localhost:8080/LearnNextResponse?text=Hello"); }
}
