Feature: Managing users in the petstore

  Scenario: Log in
    Given a user with username "OlleAl" and password "pass1"
    Then I don't get an error attempting logging in with username "OlleAl" and password "pass1"

  Scenario: Log in with wrong password
    Given a user with username "OlleAl" and password "pass1"
    Then I get an error attempting logging in with username "OlleAl" and password "wrongPassword"

  Scenario: Create several users, log them in and then delete them
    Given the following users
      | id | username      | firstName | lastName | email               | password         | phone       | userStatus |
      | 0  | JosafatHansen | Josafat   | Hansen   | josafat@hotmail.com | josafatsPassword | 070 0000008 | 0          |
      | 1  | MonaEvert     | Mona      | Evert    | mona@hotmail.com    | monasPassword    | 070 0000001 | 0          |
      | 2  | SuneSotare    | Sune      | Sotare   | sune@hotmail.com    | sunesPassword    | 070 0000002 | 0          |
    When I log them in
    And delete them
    Then I get errors attempting to fetch them

  Scenario: Create user, change emailAddress and fetch the user to confirm the update
    When I create a user with emailAddress "hanna@hotmail.com"
    And change the emailAddress to "hanna@gmail.com"
    Then the registered emailAddress in the petstore is "hanna@gmail.com"
