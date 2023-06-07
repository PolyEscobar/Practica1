@sauceDemo
Feature: Test sauceDemo login

  Scenario: login successful
    Given The user visit the sauce page
    When The user type username: 'standard_user' and password: 'secret_sauce'
    And The user click on login button
    Then user is logged

  Scenario Outline: login successful
    Given The user visit the sauce page
    When The user type username: '<user>' and password: '<password>'
    And The user click on login button
    Then user is logged
    Examples:
      | user          | password     |
      | standard_user | secret_sauce |
      | locked_out_user | secret_sauce |