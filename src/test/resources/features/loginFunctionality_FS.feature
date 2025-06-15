@log
Feature: Login functionality

  Background:
    Given the user is  on the login page



  @multipleLoginTest
  Scenario Outline: Users can log in with valid emails and passwords
    When the user enters "<email>" and "<password>"
    Then the user should see the Discuss page

    Examples:
      | email                        | password         |
      | posmanager5@info.com         | posmanager       |
      | posmanager15@info.com        | posmanager       |
      | posmanager40@info.com        | posmanager       |
      | posmanager50@info.com        | posmanager       |
      | posmanager75@info.com        | posmanager       |
      | posmanager100@info.com       | posmanager       |
      | posmanager125@info.com       | posmanager       |
      | posmanager155@info.com       | posmanager       |





  @multipleEnterLoginTest
  Scenario Outline: Users can log in with valid emails and passwords using Enter key
    When the user enters "<email>" and "<password>" and presses Enter
    Then the user should see the Discuss page

    Examples:
      | email                        | password         |
      | posmanager5@info.com         | posmanager       |
      | posmanager15@info.com        | posmanager       |
      | posmanager40@info.com        | posmanager       |
      | posmanager50@info.com        | posmanager       |
      | posmanager75@info.com       | posmanager       |
      | posmanager100@info.com       | posmanager       |
      | posmanager125@info.com       | posmanager       |
      | posmanager155@info.com       | posmanager       |




  @negative
  Scenario Outline: User sees error message for invalid credentials
    When the user enters invalid "<email>" and "<password>"
    Then an error message "Wrong login/password" should be displayed

    Examples:
      | email                        | password         |
      | POSMANAGER50@info.com        | posmanager       |
      | posmanager50@info.com        | POSMANAGER       |
      | posmanager1@info.com         | posmanager       |
      | posmanager175@info.com       | posmanager       |
      | posmanager500@info.com       | posmanager       |
      | posmanager50@INFO.COM        | posmanager       |



  @validation
  Scenario Outline: User sees message when one or more fields are empty
    When the user tries to login with email "<email>" and password "<password>"
    Then a message "Please fill out this field." should be displayed

    Examples:
      | email                        | password         |
      |                              | posmanager       |
      | posmanager50@info.com        |                  |
      |                              |                  |


