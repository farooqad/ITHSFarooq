Feature: momondo.se

  Scenario:Register new user.
   Given New User with a unique email Id should be registered
    When Only username and password
    Then Login Successful

    Scenario: Login
      Given Login with a User account.
      When Login with a valid username / password
      Then Login Successful must be successful

      Scenario: Air Line Ticket
        Given Search airline ticket for logged in user.
        Then Search of airline tickets should return results for a logged in user
