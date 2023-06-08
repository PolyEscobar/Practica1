Feature: Test sauceDemo login
  Background: navigate to SauceDemo
    Given The user visit the sauce page

  Scenario: login successful
    When The user type username: 'standard_user' and password: 'secret_sauce'
    And The user click on login button
    Then user is logged


  Scenario Outline: login successful
    When The user type username: '<user>' and password: '<password>'
    And The user click on login button
    Then user is logged
    Examples:
      | user | password |
      | standard_user | secret_sauce |
      | standard_user | secret_sauce |


  @sauceDemo
  Scenario Outline: the user try to login with locked credentials
    When The user type username: '<user>' and password: '<pass>'
    And The user click on login button
    Then a message is displayed with the text '<errorMessage>'

    Examples:
      | user            | pass         | errorMessage                                |
      | locked_out_user | secret_sauce | @PROPERTY_LOGIN_WITH_LOCKED_USER_MESSAGE    |
      |                 |              | @PROPERTY_LOGIN_WITH_EMPTY_USERNAME_MESSAGE |
      | standard_user   |              | @PROPERTY_LOGIN_WITH_EMPTY_PASSWORD_MESSAGE |