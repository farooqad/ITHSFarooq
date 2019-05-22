package se.iths.Mimic.Sprint3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class mimicSprint3 {

        WebDriver myBrowser;

        @Before
        public void setUpBrowser() {
            myBrowser = new ChromeDriver();
        }

     @Test // Learn a response and ReLearn a response with one or more values
    public void learnAndRelearnResponses(){
        unLearnAll();
        localHost();
        WebElement textArea = myBrowser.findElement(By.xpath("/html/body/form/textarea"));
        textArea.click();
        textArea.sendKeys("sweden" + Keys.ENTER + "denmark" + Keys.ENTER + "norway");
        WebElement learnResponse = myBrowser.findElement(By.xpath("//*[@id=\"learn\"]"));
        learnResponse.click();
        reLearnLoop();

        Assert.assertEquals("sweden\ndenmark\nnorway", myBrowser.findElement(By.xpath("/html/body")).getText());
        for(int i = 0; i<4; i++){
            localHost();
            Assert.assertEquals("loop values \n" + i, myBrowser.findElement(By.xpath("/html/body")).getText());
        }
    }

        @Test // UnLearn one last response each time
        public void unLearnEachResponse()
        {
            unLearnAll();
            localHost();
            WebElement textArea = myBrowser.findElement(By.xpath("/html/body/form/textarea"));
            textArea.click();
            textArea.sendKeys("sweden" + Keys.ENTER + "denmark" + Keys.ENTER + "norway");
            WebElement learnResponse = myBrowser.findElement(By.xpath("//*[@id=\"learn\"]"));
            learnResponse.click();
            reLearnLoop();
            for (int j = 0; j<= 4; j ++) {
                unLearn();
            }
        }

        @Test // Learn Next Response Using XML Value on URL
        public void learnNextResponseUsingXML() {
            unLearnAll();
            localHost();
            WebElement textArea = myBrowser.findElement(By.xpath("/html/body/form/textarea"));
            textArea.click();
            textArea.sendKeys("A" + Keys.ENTER + "B" + Keys.ENTER + "C");
            WebElement learnResponse = myBrowser.findElement(By.xpath("//*[@id=\"learn\"]"));
            learnResponse.click();
            xmlValue();
            localHost();
        }

        @Test //learn Next Response Using String on URL
        public void learnNextResponseUsingString() {
            unLearnAll();
            localHost();
            WebElement textArea = myBrowser.findElement(By.xpath("/html/body/form/textarea"));
            textArea.click();
            textArea.sendKeys("8" + Keys.ENTER + "9" + Keys.ENTER + "10");
            WebElement learnResponse = myBrowser.findElement(By.xpath("//*[@id=\"learn\"]"));
            learnResponse.click();
            stringUrl();
            localHost();
        }

        @Test //resetState repeat the sequence of responses stored in mimic
        public void resetStateRepeatingSequenceOfResponses()
        {
            unLearnAll();
            reLearnLoop();
            for (int k =0; k <= 2; k++) {
                for (int j = 0; j <= 4; j++) {
                    localHost();
                }
                resetState();
            }
        }

        @Test // save learn responses from brain file if killmimic is used
         public void saveResponsesAndLoadResponsesIfKillMimicisUsed(){
            unLearnAll();
            reLearnLoop();
            checkSaveSequenceOfSaveResponses();
            killMimic();
        }

        @Test // Before Execute this test Double click on the mimic file and the test will load the save responses
    public void loadSavedResponsesAfterKillMimic(){
        checkSaveSequenceOfSaveResponses();
    }

    private void checkSaveSequenceOfSaveResponses(){
        for (int z = 0; z <= 3; z++) {
            myBrowser.get("http://localhost:8080");
        }
    }
    private void reLearnLoop(){
            for (int i = 0; i <= 3; i ++) {
                reLearn();
                WebElement textArea1 = myBrowser.findElement(By.xpath("/html/body/form/textarea"));
                textArea1.click();
                textArea1.sendKeys("loop values " + Keys.ENTER + i );
                WebElement reLearnResponse1 = myBrowser.findElement(By.xpath("//*[@id=\"learn\"]"));
                reLearnResponse1.click();
            }
    }

    private void unLearnAll() { myBrowser.get("http://localhost:8080/unlearnAll"); }
    private void localHost(){ myBrowser.get("http://localhost:8080"); }
    private void reLearn(){ myBrowser.get("http://localhost:8080/relearn"); }
    private void unLearn(){ myBrowser.get("http://localhost:8080/unlearn"); }
    private void resetState(){ myBrowser.get("http://localhost:8080/resetState"); }
    private void stringUrl(){ myBrowser.get("http://localhost:8080/learnNextResponse?text=Hello"); }
    private void xmlValue() { myBrowser.get("http://localhost:8080/learnNextResponse?text=<value>1</value>&mime=application/xml"); }
    private void killMimic(){ myBrowser.get("http://localhost:8080/killMimic"); }
}