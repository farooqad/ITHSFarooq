package se.iths.Mimic.Sprint6;

import cucumber.api.java.bs.A;
import cucumber.api.java.eo.Do;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class mimic_5 {

    WebDriver chrome;
    @Before
    public void setUpBrowser() {
        chrome = new ChromeDriver();
    }
    @After
    public void closeBrowser(){
        chrome.quit();
    }

    By bodyText = By.xpath("/html/body");
    By textArea = By.xpath("/html/body/form/textarea");
    By learnButton = By.xpath("//*[@id=\"learn\"]");
    By viewRequestLink = By.xpath("/html/body/s/a");

    @Test
    public void fixed_Problem_With_Blank_Responses(){
        //Learn Blank Response with Auto
        unLearnAll_Responses_URL();
        add_Response_URL();
        selectOptions("Auto");
        add_One_Response_As_A_String("");
        localHost_URL();
        Assert.assertEquals("", chrome.findElement(bodyText).getText());

        //Learn Blank Response with Json
        unLearnAll_Responses_URL();
        add_Response_URL();
        selectOptions("Json");
        add_One_Response_As_A_String("");
        localHost_URL();
        Assert.assertEquals("", chrome.findElement(bodyText).getText());

        //Learn Response with selection option XML
        unLearnAll_Responses_URL();
        add_Response_URL();
        selectOptions("XML");
        add_One_Response_As_A_String("");
        localHost_URL();
        Assert.assertEquals("", chrome.findElement(bodyText).getText());

        //Learn Response with selection option HTML
        unLearnAll_Responses_URL();
        add_Response_URL();
        selectOptions("HTML");
        add_One_Response_As_A_String("");
        localHost_URL();
        Assert.assertEquals("", chrome.findElement(bodyText).getText());

        //Learn Response with selection option Text
        unLearnAll_Responses_URL();
        add_Response_URL();
        selectOptions("Text");
        add_One_Response_As_A_String("");
        localHost_URL();
        Assert.assertEquals("", chrome.findElement(bodyText).getText());
    }

    @Test
    public void corrected_Problem_When_Not_Specifying_A_Value(){
    unLearnAll_Responses_URL();
    learn_XML_Value_URL_By_Not_Specifying_Value();
    Assert.assertEquals("Response learned", chrome.findElement(bodyText).getText());
    }

    @Test
    public void fixed_Problem_Learning_A_Longer_Path(){
     unLearnAll_Responses_URL();
     //Longer path using String
     learn_String_URL();
     localHost_URL();
     Assert.assertEquals("Hello", chrome.findElement(bodyText).getText());
     //Longer path Using XM
     learn_XML_Value_URL();
     Assert.assertEquals("Response learned", chrome.findElement(bodyText).getText());
    }

    @Test
    public void more_Informative_Responses_Than_Just_OK(){
        // unlearn All Responses
        unLearnAll_Responses_URL();
        Assert.assertEquals("All responses unlearned", chrome.findElement(bodyText).getText());

        //Learn One Response
        add_Response_URL();
        selectOptions("Auto");
        add_One_Response_As_A_String("tjo");
        Assert.assertEquals("OK", chrome.findElement(bodyText).getText());

        //UnLearn Single Response
        unLearn_Response_URL();
        Assert.assertEquals("1 responses unlearned", chrome.findElement(bodyText).getText());
    }

    @Test
    public void click_On_Link_In_ViewRequests_List_To_View_Response(){
        unLearnAll_Responses_URL();

        //Learn a String Form
        add_Response_URL();
        selectOptions("Auto");
        add_One_Response_As_A_String("String1");
        localHost_URL();
        Assert.assertEquals("String1", chrome.findElement(bodyText).getText());

        //click on the Link in View Requests
        view_Requests_URL();
        chrome.findElement(viewRequestLink).click();
        Assert.assertEquals("String1", chrome.findElement(bodyText).getText());
    }

    @Test
    public void specify_The_Mime_Type_In_A__DropDown_Instead_Of_Auto_Detecting(){
    unLearnAll_Responses_URL();
    //Learn Response with selection option Json
        add_Response_URL();
        selectOptions("Json");
        add_One_Response_As_A_String("Hello, World");
        localHost_URL();
        Assert.assertEquals("Hello, World", chrome.findElement(bodyText).getText());

        //Learn Response with selection option XML
        add_Response_URL();
        selectOptions("XML");
        add_One_Response_As_A_String("Hi, Sweden");
        localHost_URL();
        Assert.assertEquals("Hi, Sweden", chrome.findElement(bodyText).getText());

        //Learn Response with selection option HTML
        add_Response_URL();
        selectOptions("HTML");
        add_One_Response_As_A_String("HTML Text");
        localHost_URL();
        Assert.assertEquals("HTML Text", chrome.findElement(bodyText).getText());

        //Learn Response with selection option Text
        add_Response_URL();
        selectOptions("Text");
        add_One_Response_As_A_String("text1");
        localHost_URL();
        Assert.assertEquals("text1", chrome.findElement(bodyText).getText());
    }

    private void localHost_URL(){ chrome.get("http://localhost:8080"); }
    private  void learn_A_Response_URL() {chrome.get("http://localhost:8080/add?value1=10&value2=20");}
    private void add_Response_URL() {chrome.get("http://localhost:8080/AddResponse");}
    private void reLearn_Response_URL(){ chrome.get("http://localhost:8080/relearnResponse"); }
    private void unLearn_Response_URL(){ chrome.get("http://localhost:8080/unlearnResponse"); }
    private void resetState_URL(){ chrome.get("http://localhost:8080/resetState"); }
    private void learn_String_URL(){ chrome.get("http://localhost:8080/LearnNextResponse?text=Hello"); }
    private void learn_XML_Value_URL() { chrome.get("http://localhost:8080/LearnNextResponse?text=<value>1</value>&mime=application/xml"); }
    private void learn_XML_Value_URL_By_Not_Specifying_Value() { chrome.get("http://localhost:8080/LearnNextResponse?text=<value></value>&mime=application/xml"); }
    private void view_Requests_URL() { chrome.get("http://localhost:8080/ViewRequests");}
    private void unLearnAll_Responses_URL() { chrome.get("http://localhost:8080/UnlearnAllResponses"); }
    private void killMimic_URL(){ chrome.get("http://localhost:8080/killMimic"); }

    private void selectOptions(String select){
        if(select=="Auto") {
            By selectAuto = By.xpath("/html/body/form/select/option[1]");
        }
        if(select=="Json") {
            By selectJson = By.xpath("/html/body/form/select/option[2]");
        }
        if(select=="XML") {
            By selectXML = By.xpath("/html/body/form/select/option[3]");
        }
        if(select=="HTML") {
            By selectHTML = By.xpath("/html/body/form/select/option[4]");
        }
        if(select=="Text") {
            By selectText = By.xpath("/html/body/form/select/option[5]");
        }
    }

    private void add_One_Response_As_A_String(String str){
        chrome.findElement(textArea).sendKeys(str);
        chrome.findElement(learnButton).click();
    }
}
