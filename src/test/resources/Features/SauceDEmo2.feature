Feature: Test sauceDemo cart
    Background: navigate to SauceDemo
        Given The user visit the sauce page
    @sauceDemo1
    Scenario Outline: the user check if the text of the button have changed
        When The user type username: '<user>' and password: '<password>'
        And The user click on login button
        And The user add the product '<product>' to cart
        And The user click on cart button
        And The user click on checkout button
        And The user type his personal data
            | firstName | lastName | postal |
            | Pepe      | Viyuela  | 07006  |
        And The user click on continue button
        Then The user click on finish button

        Examples:
            | user          | password     | product             |
            | standard_user | secret_sauce | Sauce Labs Backpack |