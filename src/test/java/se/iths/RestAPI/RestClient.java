package se.iths.RestAPI;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RestClient {
    public HttpResponse<String> saveResponse(String newResponse) throws UnirestException {

        HttpResponse<String> saveResponse = Unirest
                .get("http://localhost:8080/LearnNextResponse?text=" + newResponse)
                .asString();

        return saveResponse;
    }


    public HttpResponse<String> saveRequest(String request) throws UnirestException {

        HttpResponse<String> saveRequest = Unirest
                .get("http://localhost:8080/" + request)
                .asString();

        return saveRequest;
    }

    public HttpResponse<String> retrieveResponse() throws UnirestException {

        HttpResponse<String> retrieveResponse = Unirest
                .get("http://localhost:8080")
                .asString();

        return retrieveResponse;
    }

    public HttpResponse<String> retrieveResponseByRequest(String request) throws UnirestException {

        HttpResponse<String> getResponse = Unirest
                .get("http://localhost:8080/" + request)
                .asString();

        return getResponse;
    }

    public HttpResponse<String> unlearnPrevious() throws UnirestException {   // Method not done!

        HttpResponse<String> unlearnResponse = Unirest
                .get("http://localhost:8080/unlearn")
                .asString();

        return unlearnResponse;

    }

    public HttpResponse<String> unlearnAll() throws UnirestException {

        HttpResponse<String> unlearnAll = Unirest
                .get("http://localhost:8080/unlearnall").asString();

        return unlearnAll;
    }
}

