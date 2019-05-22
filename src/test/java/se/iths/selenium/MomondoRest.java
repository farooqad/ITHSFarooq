package se.iths.selenium;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

public class MomondoRest {

@Test
    public void login() throws UnirestException {
    HttpResponse<String> momondoURL = Unirest.get("www.momondo.se").asString();
    Assert.assertEquals("404", momondoURL.getStatus());

}
}
