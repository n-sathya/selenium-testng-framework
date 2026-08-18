Feature: Login

  @smoke
  Scenario: User logs in with valid credentials
    Given user is on the login page
    When user enters valid username and password
    Then the account page should be visible

  @regression
  Scenario Outline: Multiple User Login
    Given  user is on the login page
    When user enters "<username>" and "<password>"
    Then the account page should be visible


    Examples:
    |username|password|
    |test_acc@testmail.com|testAccount@108|


  @regression
  Scenario: Failed login with invalid password
    Given user is on the login page
    When user enters "test_acc@testmail.com" and "wrongpassword"
    Then login should fail