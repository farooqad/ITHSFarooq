package se.iths.petstore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;
import se.iths.CucumberAssignment.User;
import se.iths.CucumberAssignment.UserPetStoreClient;

public class RestAPIAssignment {

    ObjectMapper map = new ObjectMapper();
    UserPetStoreClient obj = new UserPetStoreClient();

    @Test
    public void login() {
        try {
            user_Creation();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        Boolean userLogin = new UserPetStoreClient().logIn("Farooq", "Ahmad");
        Assert.assertEquals(true, userLogin);
    }

    @Test
    public void login_With_Wrong_Password() throws JsonProcessingException, UnirestException {
        UserPetStoreClient user_Pet = new UserPetStoreClient();
            user_Creation1();
        user_Pet.logIn1("Farooq","Ahmad");
        Assert.assertEquals(false,false);
    }

    @Test
    public void email_Change() throws JsonProcessingException, UnirestException {
        User Farooq1 = new User(656565, "Farooq", "Ahmad", "farooq@gmail.com",
                "07070707", "Ahmad");

        String FarooqAsJson = map.writeValueAsString(Farooq1);
        HttpResponse<String> email_Update = Unirest.put
                ("https://swagger-petstore.azurewebsites.net/v2/user/Farooq")
                .header("Content-Type", "application/json")
                .body(FarooqAsJson)
                .asString();
        Assert.assertEquals(200, email_Update.getStatus());

        Farooq1.setEmail("farooq@gmail.com");
        HttpResponse<String> email_Update1 = Unirest.put
                ("https://swagger-petstore.azurewebsites.net/v2/user/Farooq")
                .header("Content-Type", "application/json")
                .body(FarooqAsJson)
                .asString();
        Assert.assertEquals(200, email_Update1.getStatus());
    }

    @Test
    public void create_A_User() throws JsonProcessingException, UnirestException {

        User Farooq = new User(9191, "Farooq", "Ahmad", "farooq@gmail.com", "0909090909", "Ahmad");
        User Farooq1 = new User(9292, "faro", "Ahmad", "farooq@gmail.com", "02020202", "Ahmad");

        String FarooqAsJson = map.writeValueAsString(Farooq);
        String FarooqAsJson2 = map.writeValueAsString(Farooq1);

        HttpResponse<JsonNode> users = Unirest
                .post("https://swagger-petstore.azurewebsites.net/v2/user/")
                .header("Content-Type", "application/json")
                .body(FarooqAsJson)
                .asJson();

        Assert.assertEquals(200, users.getStatus());

        HttpResponse<JsonNode> users1 = Unirest
                .post("https://swagger-petstore.azurewebsites.net/v2/user/")
                .header("Content-Type", "application/json")
                .body(FarooqAsJson2)
                .asJson();

        Assert.assertEquals(200, users1.getStatus());
        Boolean login_User = new UserPetStoreClient().logIn("Farooq", "Ahmad");
        Assert.assertEquals(true, login_User);
        Boolean Login_User1 = new UserPetStoreClient().logIn("Farooq1", "Ahmad");
        Assert.assertEquals(true, Login_User1);
    }

    @Test
    public void delete_A_User() throws JsonProcessingException, UnirestException {
        create_A_User();
        HttpResponse<String> delete_User = Unirest.delete
                ("https://swagger-petstore.azurewebsites.net/v2/user/Farooq1")
                .asString();
        Assert.assertEquals(404, delete_User.getStatus());

        HttpResponse<String> delete_User1 = Unirest.delete
                ("https://swagger-petstore.azurewebsites.net/v2/user/Farooq1")
                .asString();
        Assert.assertEquals(404, delete_User1.getStatus());
    }

    private void user_Creation() throws JsonProcessingException, UnirestException {
        User Farooq = new User(9090, "Farooq", "Ahmad", "farooq@gmail.com",
                "60606060", "Ahmad");
        String FarooqAsJson = map.writeValueAsString(Farooq);
        HttpResponse<JsonNode> post_Pet_Response = Unirest
                .post("https://swagger-petstore.azurewebsites.net/v2/user/")
                .header("Content-Type", "application/json")
                .body(FarooqAsJson)
                .asJson();
        Assert.assertEquals(200, post_Pet_Response.getStatus());
    }

    private void user_Creation1() throws JsonProcessingException, UnirestException {
        User Farooq = new User(9090, "Farooq", "Ahmad", "Farooq@gmail.com",
                "92929292", "amd");
        String FarooqAsJson = map.writeValueAsString(Farooq);
        HttpResponse<JsonNode> postPetResponse = Unirest
                .post("https://swagger-petstore.azurewebsites.net/v2/user/")
                .header("Content-Type", "application/json")
                .body(FarooqAsJson)
                .asJson();
        Assert.assertEquals(200, postPetResponse.getStatus());
    }
}

