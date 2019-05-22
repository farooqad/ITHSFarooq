package se.iths.Mimic.Sprint3;

        import com.mashape.unirest.http.HttpResponse;
        import com.mashape.unirest.http.Unirest;
        import com.mashape.unirest.http.exceptions.UnirestException;
        import org.junit.Assert;
        import org.junit.Test;

public class RestTest {
    @Test
    public void save_Multiple_Responses_Using_String() throws UnirestException {
        HttpResponse<String> unlearnAll = Unirest.get("http://localhost:8080/unlearnAll").asString();
        Assert.assertEquals("OK", unlearnAll.getBody());

        HttpResponse<String> saveResponse1 = Unirest.get("http://localhost:8080/learnNextResponse?text=Hello").asString();
        Assert.assertEquals("OK", saveResponse1.getBody());
        HttpResponse<String> testSavedResponse1 = Unirest.get("http://localhost:8080/").asString();
        Assert.assertEquals("Hello", testSavedResponse1.getBody());

        HttpResponse<String> saveResponse2 = Unirest.get("http://localhost:8080/learnNextResponse?text=Hi").asString();
        Assert.assertEquals("OK", saveResponse2.getBody());
        HttpResponse<String> testSavedResponse2 = Unirest.get("http://localhost:8080/").asString();
        Assert.assertEquals("Hi", testSavedResponse2.getBody());

        HttpResponse<String> savedResponse3 = Unirest.get("http://localhost:8080/learnNextResponse?text=Bye").asString();
        Assert.assertEquals("OK", savedResponse3.getBody());
        HttpResponse<String> testSavedResponse3 = Unirest.get("http://localhost:8080/").asString();
        Assert.assertEquals("Bye", testSavedResponse3.getBody());

        for (int i = 0; i <= 2; i++) {
            HttpResponse<String> checkresponses = Unirest.get("http://localhost:8080/").asString();
            if (i == 0)
                Assert.assertEquals("Hello", checkresponses.getBody());
            if (i == 1)
                Assert.assertEquals("Hi", checkresponses.getBody());
            if (i == 2)
                Assert.assertEquals("Bye", checkresponses.getBody());
        }

        HttpResponse<String> unlearnprevious = Unirest.get("http://localhost:8080/unlearn").asString();
        Assert.assertEquals("OK", unlearnprevious.getBody());
        HttpResponse<String> checkResponse = Unirest.get("http://localhost:8080/").asString();
        Assert.assertEquals("Hi", checkResponse.getBody());

        HttpResponse<String> unlearnprevious1 = Unirest.get("http://localhost:8080/unlearn").asString();
        Assert.assertEquals("OK", unlearnprevious1.getBody());
        HttpResponse<String> checkResponse1 = Unirest.get("http://localhost:8080/").asString();
        Assert.assertEquals("Hello", checkResponse1.getBody());

        HttpResponse<String> unlearnprevious3 = Unirest.get("http://localhost:8080/unlearn").asString();
        Assert.assertEquals("OK", unlearnprevious3.getBody());
    }
}
