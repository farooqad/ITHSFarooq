package se.iths.Mimic.Sprint3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import sun.security.mscapi.KeyStore;

public class mimicSprintThree {
    WebDriver myBrowser;

    @Before
    public void setUpBrowser() {
        myBrowser = new ChromeDriver();
    }
    @After
    public void closeBrowser(){
        myBrowser.quit();
    }

    By bodyText = By.xpath("/html/body");
    By textAreaField = By.xpath("/html/body/form/textarea");
    By learnBtn = By.xpath("//*[@id=\"learn\"]");

    @Test
    public void Learns_To_Respond_To_A_Request_Pattern(){
        unLearnAll();
        localHost();
        myBrowser.findElement(textAreaField).sendKeys("First");
        myBrowser.findElement(learnBtn).click();
        localHost();
        Assert.assertEquals("First", myBrowser.findElement(bodyText).getText());
        stringUrl();
        Assert.assertEquals("OK", myBrowser.findElement(bodyText).getText());
        stringUrl1();
        Assert.assertEquals("OK", myBrowser.findElement(bodyText).getText());
        localHost();
        Assert.assertEquals("Hi", myBrowser.findElement(bodyText).getText());
    }

    @Test
    public void Learns_To_Respond_To_A_Request_Pattern1(){
        unLearnAll();
        localHost();
        stringUrl();
        Assert.assertEquals("OK", myBrowser.findElement(bodyText).getText());
        stringUrl1();
        Assert.assertEquals("OK", myBrowser.findElement(bodyText).getText());
        localHost();
        Assert.assertEquals("Hi", myBrowser.findElement(bodyText).getText());
        resetState();
        Assert.assertEquals("OK", myBrowser.findElement(bodyText).getText());
        for (int i = 1; i<= 10; i ++) {
            localHost();
            Assert.assertEquals("Hi", myBrowser.findElement(bodyText).getText());
            resetState();
        }
    }

    @Test
    public void Learns_To_Respond_To_A_Request_Pattern2(){
        unLearnAll();
        localHost();
        stringUrl();
        localHost();
        Assert.assertEquals("Hello", myBrowser.findElement(bodyText).getText());
        xmlValue();
        Assert.assertEquals("OK", myBrowser.findElement(bodyText).getText());
        localHost();
        localHost();
        Assert.assertEquals("Hello", myBrowser.findElement(bodyText).getText());
        resetState();
        localHost();
        Assert.assertEquals("Hello", myBrowser.findElement(bodyText).getText());
    }


    @Test
    public void  Unlearn_Works_Like_Relearn_But_Without_Learning_A_New_Response(){
        unLearnAll();
        localHost();
        stringUrl();
        unLearn();
        localHost();
        Assert.assertEquals("Hello", myBrowser.findElement(bodyText).getText());
        stringUrl1();
    }

    private void unLearnAll() { myBrowser.get("http://localhost:8080/unlearnAll"); }
    private void localHost(){ myBrowser.get("http://localhost:8080"); }
    private void reLearn(){ myBrowser.get("http://localhost:8080/relearn"); }
    private void unLearn(){ myBrowser.get("http://localhost:8080/unlearn"); }
    private void resetState(){ myBrowser.get("http://localhost:8080/resetState"); }

    private void stringUrl(){ myBrowser.get("http://localhost:8080/learnNextResponse?text=Hello"); }
    private void stringUrl1(){ myBrowser.get("http://localhost:8080/learnNextResponse?text=Hi"); }

    private void xmlValue() { myBrowser.get("http://localhost:8080/learnNextResponse?text=<value>1</value>&mime=application/xml"); }
    private void killMimic(){ myBrowser.get("http://localhost:8080/killMimic"); }
    private void learnResponse(){myBrowser.findElement(By.xpath("/html/body/form/textarea")).sendKeys("Bye");
    myBrowser.findElement(By.xpath("//*[@id=\"learn\"]")).click();
    }
}