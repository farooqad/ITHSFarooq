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

    @Test
    public void login() {
        try {
            user_Creation();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        Boolean userLogin = new UserPetStoreClient().logIn_User("Farooq", "Ahmad");
        Assert.assertEquals(true, userLogin);
    }

    @Test
    public void login_With_Wrong_Password() throws JsonProcessingException, UnirestException {
        User Farooq = new User(9191, "Farooq", "Ahmad", "amd", "farooq@gmail.com", "Ahmad");

        String FarooqAsJson = map.writeValueAsString(Farooq);
        HttpResponse<JsonNode> users = Unirest
                .post("https://swagger-petstore.azurewebsites.net/v2/user/")
                .header("Content-Type", "application/json")
                .body(FarooqAsJson)
                .asJson();
        Assert.assertEquals(200, users.getStatus());

        Boolean login_with_Wrong_Password = new UserPetStoreClient().logIn_User1("Farq", "Ahad");
        Assert.assertEquals(false, login_with_Wrong_Password);
    }

    @Test
    public void email_Change() throws JsonProcessingException, UnirestException {
        user_Creation();
        User Farooq = new User(9090, "Farooq", "Far", "amd", "amd@gmail.com", "Ahmad");

        String FarooqAsJson = map.writeValueAsString(Farooq);

        HttpResponse<String> email_Update = Unirest.put
                ("https://swagger-petstore.azurewebsites.net/v2/user/Farooq")
                .header("Content-Type", "application/json")
                .body(FarooqAsJson)
                .asString();

        Assert.assertEquals(200, email_Update.getStatus());
        Assert.assertEquals("amd@gmail.com", Farooq.getEmail());
    }

    @Test
    public void create_Multiple_Users() throws JsonProcessingException, UnirestException {
        User Farooq = new User(9191, "Farooq", "Farooq", "amad", "farooq123@gmail.com", "Ahmad444");
        User Farooq1 = new User(9292, "Farooq1", "Farooq", "amad", "farooq1234@gmail.com", "Ahmad123");

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

        Boolean login_User = new UserPetStoreClient().logIn_User("Farooq", "Ahmad444");
        Assert.assertEquals(true, login_User);
        Boolean Login_User1 = new UserPetStoreClient().logIn_User("Farooq1", "Ahmad123");
        Assert.assertEquals(true, Login_User1);
    }

    @Test
    public void delete_A_User() throws JsonProcessingException, UnirestException {
        //Creating Multiple Users
        create_Multiple_Users();

        //Deleting User Farooq
        HttpResponse<String> delete_User = Unirest.delete
                ("https://swagger-petstore.azurewebsites.net/v2/user/Farooq").asString();
        Assert.assertEquals(200, delete_User.getStatus());

        //Deleting User Farooq1
        HttpResponse<String> delete_User1 = Unirest.delete
                ("https://swagger-petstore.azurewebsites.net/v2/user/Farooq1").asString();
        Assert.assertEquals(200, delete_User1.getStatus());

        //Checking User Farooq after Deletion
        HttpResponse<String> Check_Deleted_User = Unirest.delete
                ("https://swagger-petstore.azurewebsites.net/v2/user/Farooq").asString();
        Assert.assertEquals(404, Check_Deleted_User.getStatus());
        //Checking User Farooq1 after Deletion
        HttpResponse<String> check_Deleted_User1 = Unirest.delete
                ("https://swagger-petstore.azurewebsites.net/v2/user/Farooq1").asString();
        Assert.assertEquals(404, check_Deleted_User1.getStatus());
    }

    private void user_Creation() throws JsonProcessingException, UnirestException {
        User Farooq = new User(9090, "Farooq", "Far", "Amd",
                "farooq@gmail.com", "Ahmad");
        String FarooqAsJson = map.writeValueAsString(Farooq);
        HttpResponse<JsonNode> post_Pet_Response = Unirest
                .post("https://swagger-petstore.azurewebsites.net/v2/user/")
                .header("Content-Type", "application/json")
                .body(FarooqAsJson)
                .asJson();
        Assert.assertEquals(200, post_Pet_Response.getStatus());
    }
}