

package se.iths.petstore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;

import java.util.List;

public class PetStoreClient {

    ObjectMapper mapper = new ObjectMapper();

    public void deletePet(int id){

        try {
            HttpResponse<String> deleteResponse = Unirest.delete("http://petstore.swagger.io/v2/pet/" + id).asString();

            Assert.assertEquals(
                    200,
                    deleteResponse.getStatus()
            );
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void createPet(Pet myPet){

        try {
            String fidoAsJson = mapper.writeValueAsString(myPet);

            HttpResponse<JsonNode> postPetResponse = Unirest
                    .post("http://petstore.swagger.io/v2/pet/")
                    .header("Content-Type", "application/json")
                    .body(fidoAsJson)
                    .asJson();

            Assert.assertEquals(200, postPetResponse.getStatus());

        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public Pet getPet(int id){

        return getPet (id, 200);

    }

    public Pet getPet(int id, int expectedStatuscode){

        try {

            HttpResponse<String> getPetResponse = Unirest
                    .get("http://petstore.swagger.io/v2/pet/" + id)
                    .asString();

            Pet myPet = mapper.readValue(
                    getPetResponse.getBody(),
                    Pet.class
            );

            Assert.assertEquals(expectedStatuscode, getPetResponse.getStatus());

            return myPet;

        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void orderapet(orderapet order) throws JsonProcessingException, UnirestException {

        ObjectMapper  mapper = null;

        HttpResponse<JsonNode> orderapet = Unirest
                .post("https://petstore.swagger.io/v2/store/order")
                .header("Content-Type", "application/json")
                .body(mapper.writeValueAsString(order))
                .asJson();
    }
    
}