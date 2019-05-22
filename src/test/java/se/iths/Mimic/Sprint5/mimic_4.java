package se.iths.Mimic.Sprint5;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class mimic_4 {
    WebDriver chrome;
    @Before
    public void setUpBrowser() {
        chrome = new ChromeDriver();
    }
    @After
    public void closeBrowser(){
        chrome.quit();
    }

    By textAreaRelearnResponse = By.xpath("/html/body/form/textarea");
    By learnButtonInRelearnResponse = By.xpath("//*[@id=\"learn\"]");
    By bodyText = By.xpath("/html/body");

    @Test
    public void Fix_problem_when_trying_to_unlearn_a_repeated_request() {
        unLearnAll_Responses();
        addResponse();
            for (int i = 1; i<= 10; i++) {
                addResponse();
                Add_Single_Response_Using_String("Hello");
            }
        localHost();
        Assert.assertEquals("Hello", chrome.findElement(bodyText).getText());

            for (int j = 1; j<= 2; j++) {
                localHost();
                unLearn_Response();
                localHost();
            }
        Assert.assertNotEquals("Hello", chrome.findElement(bodyText).getText());
    }

    @Test
    public void Change_relearn_into_RelearnResponse_and_add_AddResponse() {
        unLearnAll_Responses();
        unLearnAll_Responses();
        reLearn_Response();
        Add_Single_Response_Using_String("Response1");
        localHost();
        Assert.assertEquals("Response1", chrome.findElement(bodyText).getText());
    }

    @Test
    public void Change_unlearn_to_UnlearnResponse_and_unlearnAll_to_UnlearnAllResponses() {
        unLearnAll_Responses();
        reLearn_Response();
        Add_Single_Response_Using_String("New Response");
        unLearn_Response();
        Assert.assertEquals("OK", chrome.findElement(bodyText).getText());
    }

    @Test
    public void Correct_problem_when_not_specifying_a_value_for_example_test_param() {
        unLearnAll_Responses();
        testParam();
        Assert.assertEquals("Paste or type json, xml, html or text response to learn and press Learn", chrome.findElement(bodyText).getText());
    }

    @Test
    public void Handle_responses_that_begins_or_ends_with_the_same_characters(){
        String name = null;
        unLearnAll_Responses();
        reLearn_Response();
            for (int i = 1; i <= 3; i++) {
                    if (i == 0)
                    name = "illei";
                    if(i == 1)
                    name = "qasimq";
                    if(i == 2)
                    name = "poojap";
                    if (i == 3)
                    name = "farooqf";
            }
        Add_Single_Response_Using_String(name);
        localHost();
        Assert.assertEquals(name, chrome.findElement(bodyText).getText());
    }

    @Test
    public void Learns_complex_responses_faster(){
                Complex complex1 = new Complex(5.0, 6.0);
                Complex complex2 = new Complex(-3.0, 4.0);

                unLearnAll_Responses();
                reLearn_Response();
                learn_Complex_Numbers(complex1.tan());
                localHost();
                Assert.assertEquals("complex:"+complex1.tan(), chrome.findElement(bodyText).getText());

                unLearnAll_Responses();
                reLearn_Response();
                learn_Complex_Numbers(complex1.plus(complex1));
                localHost();
                Assert.assertEquals("complex:"+complex1.plus(complex1), chrome.findElement(bodyText).getText());

                unLearnAll_Responses();
                reLearn_Response();
                learn_Complex_Numbers(complex1.times(complex2));
                localHost();
                Assert.assertEquals("complex:"+complex1.times(complex2), chrome.findElement(bodyText).getText());

                unLearnAll_Responses();
                reLearn_Response();
                learn_Complex_Numbers(complex1.divides(complex2));
                localHost();
                Assert.assertEquals("complex:"+complex1.divides(complex2), chrome.findElement(bodyText).getText());

                unLearnAll_Responses();
                reLearn_Response();
                learn_Complex_Numbers(complex1.divides(complex2).times(complex2));
                localHost();
                Assert.assertEquals("complex:"+complex1.divides(complex2).times(complex2), chrome.findElement(bodyText).getText());

                unLearnAll_Responses();
                reLearn_Response();
                learn_Complex_Numbers(complex1.conjugate());
                localHost();
                Assert.assertEquals("complex:"+complex1.conjugate(), chrome.findElement(bodyText).getText());
    }

    @Test
    public void View_all_responses_that_Mimic_have_learned(){
            String st = null;
            String st1 =null;
            unLearnAll_Responses();
            addResponse();
            //Learning Responses
            for (int i = 1; i <= 3; i++) {
            if (i == 0)
                st = "Sweden";
            if(i == 1)
                st = "Norway";
            if(i == 2)
                st = "Denmark";
            }
            Add_Single_Response_Using_String(st);
            localHost();
            Assert.assertEquals(st, chrome.findElement(bodyText).getText());
            //View Learned Responses
            for (int j= 1; j<=3; j++) {
                localHost();
                if (j == 0)
                    st1 = "Sweden";
                if(j == 1)
                    st1 = "Norway";
                if(j == 2)
                    st1 = "Denmark";
            }
        Assert.assertEquals(st1, chrome.findElement(bodyText).getText());
        }

    private void localHost(){ chrome.get("http://localhost:8080"); }
    private  void askForResponse() {chrome.get("http://localhost:8080/add?value1=10&value2=20");}
    private void addResponse() {chrome.get("http://localhost:8080/AddResponse");}
    private void reLearn_Response(){ chrome.get("http://localhost:8080/relearnResponse"); }
    private void unLearn_Response(){ chrome.get("http://localhost:8080/unlearnResponse"); }
    private void resetState(){ chrome.get("http://localhost:8080/resetState"); }
    private void stringUrl(){ chrome.get("http://localhost:8080/LearnNextResponse?text=Hello"); }
    private void xmlValue() { chrome.get("http://localhost:8080/LearnNextResponse?text=<value>1</value>&mime=application/xml"); }
    private void viewRequest() { chrome.get("http://localhost:8080/ViewRequests");}
    private void unLearnAll_Responses() { chrome.get("http://localhost:8080/UnlearnAllResponses"); }
    private void killMimic(){ chrome.get("http://localhost:8080/killMimic"); }
    private void testParam() {chrome.get("http://localhost:8080/test?param=1");}

    private void Add_Single_Response_Using_String(String response) {
        chrome.findElement(textAreaRelearnResponse).sendKeys(response);
        chrome.findElement(learnButtonInRelearnResponse).click();
    }

    private void learn_Complex_Numbers(Complex complex){

        chrome.findElement(textAreaRelearnResponse).sendKeys("complex:"+complex);
        chrome.findElement(learnButtonInRelearnResponse).click();
    }


}