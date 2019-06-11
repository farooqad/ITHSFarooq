package se.iths.CucumberAssignment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;import com.mashape.unirest.http.JsonNode;

import com.mashape.unirest.http.Unirest;
import org.junit.Assert;

public class UserPetStoreClient {

    ObjectMapper map = new ObjectMapper();

    User s = new User ();

    public void user_Create(User myUser){

        try {
            String FarooqAsJson = map.writeValueAsString(myUser);

            HttpResponse<JsonNode> user_Response = Unirest
                    .post("https://swagger-petstore.azurewebsites.net/v2/user")
                    .header("Content-Type", "application/json")
                    .body(FarooqAsJson)
                    .asJson();

            Assert.assertEquals(200, user_Response.getStatus());

        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public User getUser(String username){
        return getUser(username, 200);
    }

    public User getUser(String username, int expectedStatuscode){
        try {

            HttpResponse<String> user_Response = Unirest
                    .get("https://swagger-petstore.azurewebsites.net/v2/user/"+username)
                    .asString();

            User myUser = map.readValue(
                    user_Response.getBody(),
                    User.class
            );
            Assert.assertEquals(expectedStatuscode, user_Response.getStatus());
            return myUser;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public boolean logIn_User(String username, String password) {
        try {
            HttpResponse<String> post_Pet_Response = Unirest
                    .get("https://swagger-petstore.azurewebsites.net/v2/user/login/?username"+username+"&password="+password)
                    .header("Content-Type", "application/json")
                    .asString();
            if (post_Pet_Response.getStatus() == 200) {
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean logIn_User1(String username, String password) {
        try {
            HttpResponse<String> post_Pet_Response = Unirest
                    .get("https://swagger-petstore.azurewebsites.net/v2/user/login/?username"+username+"&password="+password)
                    .header("Content-Type", "application/json")
                    .asString();
            if (post_Pet_Response.getStatus() == 400) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void user_Delete(String username){
        try {
            HttpResponse<String> delete_Response = Unirest.delete
                    ("https://swagger-petstore.azurewebsites.net/v2/user/" + username).asString();
            Assert.assertEquals(200, delete_Response.getStatus());
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public User updateUserEmail(String username, String updatedUser) {
        try {
            String FarooqAsJson = map.writeValueAsString(updatedUser);

            HttpResponse<String> email_Update = Unirest.put
                    ("https://swagger-petstore.azurewebsites.net/v2/user/" + username)
                    .header("Content-Type", "application/json")
                    .queryString("email", username)
                    .body(FarooqAsJson)
                    .asString();
            Assert.assertEquals(500, email_Update.getStatus());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}


