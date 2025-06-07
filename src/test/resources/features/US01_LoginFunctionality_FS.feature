@login
Feature: Login functionality

  Background:
    Given the user is  on the login page
@wip
  Scenario Outline: User can log in with valid credentials by clicking "Login" button
    When the user logs in as "<role>"
    Then the user should see the Dashboard page

  Examples:
    | role      |
    | pos       |
    | crm       |
    | sales     |
    | inventory |
    | expenses  |

@smoke
  Scenario Outline: User can log in with valid credentials by pressing the "Enter" key
    When the user enters valid "<role>" and presses the Enter key
    Then the user should see the Dashboard page

  Examples:
    | role      |
    | pos       |
    | crm       |
    | sales     |
    | inventory |
    | expenses  |

@negative
  Scenario: User sees error message for invalid credentials
    When the user enters invalid credentials
    Then an error message "Wrong login/password" should be displayed
@validation
  Scenario: User sees message when one or more fields are empty
    When the user leaves username or password field blank
    Then a message "Please fill out this field." should be displayed


