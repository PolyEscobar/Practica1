@SauceDemo
Feature: Test sauceDemo login
  Background: navigate to SauceDemo
    Given The user visit the sauce page

  @Login
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


  Scenario Outline: the user try to login with locked credentials
    When The user type username: '<user>' and password: '<pass>'
    And The user click on login button
    Then a message is displayed with the text '<errorMessage>'

    Examples:
      | user            | pass         | errorMessage                                |
      | locked_out_user | secret_sauce | @PROPERTY_LOGIN_WITH_LOCKED_USER_MESSAGE    |
      |                 |              | @PROPERTY_LOGIN_WITH_EMPTY_USERNAME_MESSAGE |
      | standard_user   |              | @PROPERTY_LOGIN_WITH_EMPTY_PASSWORD_MESSAGE |


  Scenario: the user add and remove objects to the cart
    When The user type username: 'standard_user' and password: 'secret_sauce'
    And The user click on login button
    Then The user click on add to cart button
    And The user click on cart button
    And The user click on remove button


  Scenario Outline: the user verify that products are add to the cart
    When The user type username: '<user>' and password: '<password>'
    And The user click on login button
    And The user add the product 'Sauce Labs Backpack' to cart
    And The user add the product 'Test.allTheThings() T-Shirt (Red)' to cart
    And the user verifies that there are '2' pop up products in the cart


    Examples:
      | user          | password     |
      | standard_user | secret_sauce |


  Scenario Outline: the user check if the text of the button have changed
    When The user type username: '<user>' and password: '<password>'
    And The user click on login button
    And The user add the product 'Sauce Labs Backpack' to cart
    Then the user verifies if the button of 'Sauce Labs Backpack' have been changed to remove button

    Examples:

      | user | password |
      | standard_user | secret_sauce |


  Scenario Outline: the user check if the color of the button have changed
    When The user type username: '<user>' and password: '<password>'
    And The user click on login button
    And The user add the product '<product>' to cart
    Then the user verifies if the button of '<product>' have been changed to remove color

    Examples:

      | user          | password     | product             |
      | standard_user | secret_sauce | Sauce Labs Backpack |



  Scenario: the user fill de fields
    When The user type username: 'standard_user' and password: 'secret_sauce'
    And The user click on login button
    And The user add the product 'Sauce Labs Backpack' to cart
    And The user add the product 'Sauce Labs Bike Light' to cart
    And The user add the product 'Sauce Labs Bolt T-Shirt' to cart
    And The user click on cart button
    And The user click on checkout button
    And The user type his personal data

      | fields      | user1 |
      | first-name  | ruben |
      | last-name   | diaz  |
      | postal-code | 07006 |

    And The user click on continue button
    Then the user check if the names of the products are

      | names                   |
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |