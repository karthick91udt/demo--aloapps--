Feature: Demo Cart Search

  @Smoke
  Scenario1: Register
    Given get '/'
    When select the 'my account' 
    Then click on 'register' link
    Then fill the Mandatory  details
    Then user should register Successfully
    
    Scenario1: Login
    Given get '/'
    When select the 'my account' 
    Then click on 'Login' link
    Then fill the Mandatory  details
    Then user should Login Successfully
    