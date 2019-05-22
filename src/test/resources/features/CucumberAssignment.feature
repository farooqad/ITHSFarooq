  Feature: UserCucumberProject

    Background: User Cucumber Project

    Scenario: I need to create an user and login with right login information


      Given create a user with name "Farooq" and id 9090
      Then i login the user with correct user name "Farooq" and password "Ahmad"

    Scenario: Create a user and login with wrong user name and password
      Given create a user with name "Farooq" and id 9090
      Then i login the user with wrong user name "Farooq" and password "Ahmad"

    Scenario: Create many users login them and delete them
      Given create a user with name "Farooq" and id 9090
      Given create a user with name "Farooqse" and id 1010
      Then i login the user with correct user name "Farooq" and password "Ahmad"
      Then i login the user with correct user name "Farooqse" and password "Ahmadse"
      When i delete the user with username Farooq
      Then i get en error fetching the user with username "Farooq"

    Scenario: create a user update email and get the user
      Given create a user with name "Farooq" and id 9090
      When update the email of user with username "Farooq"
      Then validate the username "Farooq" if changes has been made