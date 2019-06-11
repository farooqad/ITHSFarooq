package se.iths.CucumberAssignment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import se.iths.CucumberAssignment.CucumberHooks;
import se.iths.CucumberAssignment.User;
import se.iths.CucumberAssignment.UserPetStoreClient;

public class CucumberUser {
    ObjectMapper map = new ObjectMapper();
    @Given("create a user with name {string} and id {int}")
    public void create_a_user_with_id(String name, Integer id) throws JsonProcessingException, UnirestException {
        User Farooq = new User(id, name, "Farooq", "Ahmad", "faroq@gmail.com", "Amd");


        String FarooqAsJson = map.writeValueAsString(Farooq);

        HttpResponse<JsonNode> postPetResponse = Unirest
                .post("https://swagger-petstore.azurewebsites.net/v2/user/")
                .header("Content-Type", "application/json")
                .body(FarooqAsJson)
                .asJson();
        Assert.assertEquals(200, postPetResponse.getStatus());
    }

    @Then("i login the user with correct user name {string} and password {string}")
    public void i_login_the_user_with_correct_user_name_and_password(String username, String pwd) {
       User Farooq = new User(9090, "Farooq", "Farooq", "Ahmad", "faroq@gmail.com", "Amd");

        Boolean userLogin = new UserPetStoreClient().logIn_User("Farooq", "Amd");
        Assert.assertEquals(true, userLogin);
    }

    @Then("i login the user with wrong user name {string} and password {string}")
    public void i_login_the_user_with_wrong_user_name_and_password(String username, String pwd) {
        User Farooq = new User(9090, "Farooq", "Farooq", "Ahmad", "faroq@gmail.com", "Amd");

        Boolean userLogin = new UserPetStoreClient().logIn_User1("anything234242","anythingsldjfsdf");
        Assert.assertEquals( false, userLogin);
    }

          @When("i delete the user with username {string}")
        public void i_delete_the_user_with_username(String username) {
            new UserPetStoreClient().user_Delete(username);
        }

        @Then("i get en error fetching the user with username {string}")
        public void i_get_en_error_fetching_the_user_with_username(String username) {
            User user = new UserPetStoreClient().getUser(username, 404);
        }

        @When("update the email of user with username {string}")
        public void update_the_email_of_user_with_username(String username) {
        User Farooq = new User(9090, "Farooq", "Farooq", "Ahmad", "faroq@gmail.com", "Amd");
        Farooq.setEmail("farooq123@gmail.com");
        new UserPetStoreClient().updateUserEmail("username","Farooq");
        Assert.assertEquals("farooq123@gmail.com", Farooq.getEmail());
    }

    @Then("validate the username {string} if changes has been made")
    public void validate_the_username_if_changes_has_been_made(String username) {
        new UserPetStoreClient().getUser("Farooq", 200);
    }

    @When("i delete the user with username Farooq")
    public void i_Delete_The_User_With_Username_Farooq() {
        new UserPetStoreClient().user_Delete("Farooq");
    }

}