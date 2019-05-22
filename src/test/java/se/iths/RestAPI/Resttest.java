package se.iths.RestAPI;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Resttest {
    @Before
    public void prepare() throws UnirestException {

        RestClient client = new RestClient();
        client.unlearnAll();
    }

    @Test
    public void saveAndRetrieveResponse() throws UnirestException {

        RestClient client = new RestClient();

        HttpResponse<String> saveResponse = client.saveResponse("xxx");
        Assert.assertEquals(200, saveResponse.getStatus());

        HttpResponse<String> retrieveResponse = client.retrieveResponse();
        Assert.assertEquals("xxx", retrieveResponse.getBody());

    }

    @Test
    public void saveAndRetrieveMultipleRequestsWithResponses() throws UnirestException {

        RestClient client = new RestClient();


        HttpResponse<String> saveResponse = client.saveResponse("yyy");
        Assert.assertEquals(200, saveResponse.getStatus());

        HttpResponse<String> saveRequest = client.saveRequest("y");
        Assert.assertEquals(200, saveRequest.getStatus());


        HttpResponse<String> saveResponse2 = client.saveResponse("zzz");
        Assert.assertEquals(200, saveResponse.getStatus());

        HttpResponse<String> saveRequest2 = client.saveRequest("z");
        Assert.assertEquals(200, saveRequest.getStatus());


        HttpResponse<String> retrieveResponse1ByRequest = client.retrieveResponseByRequest("y");
        Assert.assertEquals("yyy", retrieveResponse1ByRequest.getBody());


        HttpResponse<String> retrieveResponse2ByRequest = client.retrieveResponseByRequest("z");
        Assert.assertEquals("zzz", retrieveResponse2ByRequest.getBody());

    }

    @Test
    public void unlearnPrevious() throws UnirestException {

        RestClient client = new RestClient();

        HttpResponse<String> saveResponse = client.saveResponse("aaa");
        Assert.assertEquals(200, saveResponse.getStatus());
        HttpResponse<String> saveRequest = client.saveRequest("a");
        Assert.assertEquals(200, saveRequest.getStatus());

        HttpResponse<String> saveResponse2 = client.saveResponse("bbb");
        Assert.assertEquals(200, saveResponse.getStatus());
        HttpResponse<String> saveRequest2 = client.saveRequest("b");
        Assert.assertEquals(200, saveRequest.getStatus());

        HttpResponse<String> retrieveA = client.retrieveResponseByRequest("a");
        Assert.assertEquals("aaa", retrieveA.getBody());

        HttpResponse<String> retrieveB = client.retrieveResponseByRequest("b");
        Assert.assertEquals("bbb", retrieveB.getBody());

        HttpResponse<String> unlearnPrevious = client.unlearnPrevious();

        HttpResponse<String> retrieveA2 = client.retrieveResponseByRequest("a");
        Assert.assertEquals("aaa", retrieveA2.getBody());

        HttpResponse<String> retrieveB2 = client.retrieveResponseByRequest("b");
        Assert.assertNotEquals("bbb", retrieveB2.getBody());

    }

    @Test
    public void unlearnAll() throws UnirestException {

        RestClient client = new RestClient();

        HttpResponse<String> saveResponse = client.saveResponse("ccc");
        Assert.assertEquals(200, saveResponse.getStatus());
        HttpResponse<String> saveRequest = client.saveRequest("c");
        Assert.assertEquals(200, saveRequest.getStatus());

        HttpResponse<String> saveResponse2 = client.saveResponse("ddd");
        Assert.assertEquals(200, saveResponse.getStatus());
        HttpResponse<String> saveRequest2 = client.saveRequest("d");
        Assert.assertEquals(200, saveRequest.getStatus());

        HttpResponse<String> retrieveA = client.retrieveResponseByRequest("c");
        Assert.assertEquals("ccc", retrieveA.getBody());

        HttpResponse<String> retrieveB = client.retrieveResponseByRequest("d");
        Assert.assertEquals("ddd", retrieveB.getBody());

        HttpResponse<String> unlearnAll = client.unlearnAll();

        HttpResponse<String> retrieveA2 = client.retrieveResponseByRequest("c");
        Assert.assertNotEquals("ccc", retrieveA2.getBody());

        HttpResponse<String> retrieveB2 = client.retrieveResponseByRequest("d");
        Assert.assertNotEquals("ddd", retrieveB2.getBody());

    }

}
