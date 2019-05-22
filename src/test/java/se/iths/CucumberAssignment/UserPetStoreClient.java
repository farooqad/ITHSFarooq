package se.iths.CucumberAssignment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;import com.mashape.unirest.http.JsonNode;

import com.mashape.unirest.http.Unirest;
import org.junit.Assert;

public class UserPetStoreClient {

    ObjectMapper mapper = new ObjectMapper();

    User s = new User ();

    public void createUser(User myUser){

        try {
            String FarooqAsJson = mapper.writeValueAsString(myUser);

            HttpResponse<JsonNode> postUserResponse = Unirest
                    .post("https://swagger-petstore.azurewebsites.net/v2/user")
                    .header("Content-Type", "application/json")
                    .body(FarooqAsJson)
                    .asJson();

            Assert.assertEquals(200, postUserResponse.getStatus());

        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public User getUser(String username){
        return getUser(username, 200);
    }

    public User getUser(String username, int expectedStatuscode){

        try {

            HttpResponse<String> getUserResponse = Unirest
                    .get("https://swagger-petstore.azurewebsites.net/v2/user/"+username)
                    .asString();

            User myUser = mapper.readValue(
                    getUserResponse.getBody(),
                    User.class
            );

            Assert.assertEquals(expectedStatuscode, getUserResponse.getStatus());

            return myUser;

        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public boolean logIn(String username, String password) {
        try {

            HttpResponse<String> postPetResponse = Unirest
                    .get("https://swagger-petstore.azurewebsites.net/v2/user/login")
                    .header("Content-Type", "application/json")
                    .queryString("user", username)
                    .queryString("password", password)
                    .asString();

            if (postPetResponse.getStatus() == 200) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean logIn1(String username, String password) {
        try {

            HttpResponse<String> postPetResponse = Unirest
                    .get("https://swagger-petstore.azurewebsites.net/v2/user/login"+username+password)
                    .header("Content-Type", "application/json")
                    .queryString("user", username)
                    .queryString("password", password)
                    .asString();

            if (postPetResponse.getStatus() == 400) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(String username){

        try {
            HttpResponse<String> deleteResponse = Unirest.delete
                    ("https://swagger-petstore.azurewebsites.net/v2/user/" + username).asString();

            Assert.assertEquals(
                    200,
                    deleteResponse.getStatus()
            );
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public User updateUserEmail(String username, String updatedUser) {

        try {

            String FurkanAsJson = mapper.writeValueAsString(updatedUser);

            HttpResponse<String> updateEmail = Unirest.put
                    ("https://swagger-petstore.azurewebsites.net/v2/user/" + username)
                    .header("Content-Type", "application/json")
                    .body(FurkanAsJson)
                    .asString();
            Assert.assertEquals(500,
                    updateEmail.getStatus());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}


