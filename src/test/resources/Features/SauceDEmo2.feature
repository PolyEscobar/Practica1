@SauceDemo
Feature: Test sauceDemo cart
    Background: navigate to SauceDemo
        Given The user visit the sauce page

    Scenario Outline: the user check if the text of the button have changed
        When The user type username: '<user>' and password: '<password>'
        And The user click on login button
        And The user add the product '<product>' to cart
        And The user click on cart button
        And The user click on checkout button
        And The user type his personal data
            | fields      | user1   |
            | first-name  | Pepe    |
            | last-name   | Viyuela |
            | postal-code | 07006   |

        And The user click on continue button
        Then The user click on finish button

        Examples:
            | user          | password     | product             |
            | standard_user | secret_sauce | Sauce Labs Backpack |



    Scenario Outline: the users try the diferents posible errors
        When The user type username: 'standard_user' and password: 'secret_sauce'
        And The user click on login button
        And The user add the product 'Sauce Labs Backpack' to cart
        And The user click on cart button
        And The user click on checkout button
        And The user type his personal data '<firstName>', '<lastName>', '<postal>'
        And The user click on continue button
        Then message is displayed with the text '<errorMessage>'

        Examples:
            | firstName | lastName | postal | errorMessage                          |
            | Pepe      | Viyuela  |        | @PROPERTY_MISSING_POSTAL_CODE_MESSAGE |
            | Pepe      |          | 07006  | @PROPERTY_MISSING_LAST_NAME_MESSAGE   |
            |           | Viyuela  | 07006  | @PROPERTY_MISSING_FIRST_NAME_MESSAGE  |



    Scenario Outline: the users check if the product added to cart is correct
        When The user type username: 'standard_user' and password: 'secret_sauce'
        And The user click on login button
        And The user add the product 'Sauce Labs Backpack' to cart
        And The user click on cart button
        And The user click on checkout button
        And The user type his personal data 'Pepe', 'Viyuela', '07006'
        And The user click on continue button
        Then The user check if the product name is '<product>'

        Examples:
            | product             |
            | Sauce Labs Backpack |


