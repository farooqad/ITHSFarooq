package se.iths.petstore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class PetStoreTest {
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void makenewuser() throws UnirestException, JsonProcessingException {

        User myuser = new User(10, "Farooq", "Ahmad", "farooqad@gmail.com", "0707070707", 1);
        System.out.println("Succesfully made a new user login!");


        HttpResponse<JsonNode> postPetResponse = Unirest
                .post("http://petstore.swagger.io/v2/user")
                .header("Content-Type", "application/json")
                .body(mapper.writeValueAsString(myuser))
                .asJson();
    }


    @Test

    public void orderinos() throws JsonProcessingException, UnirestException {
        new orderapet(900,2,"45451","packed","false");

        Date date = new Date();

        System.out.println(date);


    }





    @Test
    public void getPet() throws UnirestException {

        HttpResponse<JsonNode> postPetResponse = Unirest
                .post("http://petstore.swagger.io/v2/pet/")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"id\": 23423492,\n" +
                        "    \"category\": {\n" +
                        "        \"id\": 0,\n" +
                        "        \"name\": \"small animals\"\n" +
                        "    },\n" +
                        "    \"name\": \"Fido den 2.\",\n" +
                        "    \"photoUrls\": [\n" +
                        "        \"http://example.url\"\n" +
                        "    ],\n" +
                        "    \"tags\": [\n" +
                        "        {\n" +
                        "            \"id\": 0,\n" +
                        "            \"name\": \"nice pet\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"status\": \"available\"\n" +
                        "}")
                .asJson();

        Assert.assertEquals(
                200,
                postPetResponse.getStatus()
        );

        HttpResponse<JsonNode> getPetResponse = Unirest
                .get("http://petstore.swagger.io/v2/pet/23423492")
                .asJson();

        Assert.assertEquals(
                200,
                getPetResponse.getStatus()
        );

        Assert.assertEquals(
                "Fido den 2.",
                getPetResponse.getBody().getObject().getString("name")
        );

    }




    @Test
    public void createNewPet() throws UnirestException {

        HttpResponse<JsonNode> postPetResponse = Unirest
                .post("http://petstore.swagger.io/v2/pet/")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"id\": 667788,\n" +
                        "    \"category\": {\n" +
                        "        \"id\": 0,\n" +
                        "        \"name\": \"small animals\"\n" +
                        "    },\n" +
                        "    \"name\": \"Fido den 2.\",\n" +
                        "    \"photoUrls\": [\n" +
                        "        \"http://example.url\"\n" +
                        "    ],\n" +
                        "    \"tags\": [\n" +
                        "        {\n" +
                        "            \"id\": 0,\n" +
                        "            \"name\": \"nice pet\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"status\": \"available\"\n" +
                        "}")
                .asJson();

        Assert.assertEquals(
                200,
                postPetResponse.getStatus()
        );
    }

    @Test
    public void deletePet() throws UnirestException, InterruptedException {

        HttpResponse<JsonNode> postPetResponse = Unirest
                .post("http://petstore.swagger.io/v2/pet/")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"id\": 667788,\n" +
                        "    \"category\": {\n" +
                        "        \"id\": 0,\n" +
                        "        \"name\": \"small animals\"\n" +
                        "    },\n" +
                        "    \"name\": \"Fido den 2.\",\n" +
                        "    \"photoUrls\": [\n" +
                        "        \"http://example.url\"\n" +
                        "    ],\n" +
                        "    \"tags\": [\n" +
                        "        {\n" +
                        "            \"id\": 0,\n" +
                        "            \"name\": \"nice pet\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"status\": \"available\"\n" +
                        "}")
                .asJson();

        Assert.assertEquals(
                200,
                postPetResponse.getStatus()
        );

        HttpResponse<JsonNode> getPetResponse = Unirest
                .get("http://petstore.swagger.io/v2/pet/667788")
                .asJson();

        Assert.assertEquals(
                200,
                getPetResponse.getStatus()
        );

        Assert.assertEquals(
                "Fido den 2.",
                getPetResponse.getBody().getObject().getString("name")
        );

        HttpResponse<String> deleteRsponse = Unirest.delete("http://petstore.swagger.io/v2/pet/667788").asString();

        Assert.assertEquals(
                200,
                deleteRsponse.getStatus()
        );

        HttpResponse<JsonNode> getDeletedPetResponse = Unirest
                .get("http://petstore.swagger.io/v2/pet/667788")
                .asJson();

        Assert.assertEquals(
                404,
                getDeletedPetResponse.getStatus()
        );

    }

}