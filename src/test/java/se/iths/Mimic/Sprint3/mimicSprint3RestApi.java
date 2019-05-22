package se.iths.Mimic.Sprint3;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class mimicSprint3RestApi {

    public static HttpResponse<String> saveOneResponse(String newResponse) throws UnirestException {

        Unirest .get("http://localhost:8080/LearnNextResponse?text=" + newResponse)
                .asString();

        HttpResponse<String> getResponseResponse = Unirest
                .get("http://localhost:8080")
                .asString();

        return getResponseResponse;
    }


}
