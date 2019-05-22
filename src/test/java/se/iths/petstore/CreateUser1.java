package se.iths.petstore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.junit.Test;

public class CreateUser1 {
        @Test
        public void create_a_user_with_id(Integer id) throws JsonProcessingException, UnirestException {

            User Farooq = new User(9090, "Farooq", "Ahmad", "farooq@gmail.com",
                    "0707070707", 1);

            ObjectMapper mapper = new ObjectMapper();

            String FarooqAsJson = mapper.writeValueAsString(Farooq);

            HttpResponse<JsonNode> postPetResponse = Unirest
                    .post("https://swagger-petstore.azurewebsites.net/v2/user/%22")
                            .header("Content-Type", "application/json")
                            .body(FarooqAsJson)
                            .asJson();

            Assert.assertEquals(200, postPetResponse.getStatus());

        }

}