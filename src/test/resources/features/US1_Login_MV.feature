@login
Feature: Users(posmanager and eventscrmmanager) should be able to login


  Background: User is already in the log in page
    Given the user is on the login page


  Scenario: Verify that the user can log in with valid credentials as a POS manager by clicking on the "Login" button
    When the user logged in as "posmanager" by clicking login button
    #Given the user logged in with username as "posmanager5@info.com" and password as "posmanager"
    Then the user should see the Discuss page


  Scenario Outline: Verify that the user can log in with different  valid credentials as a POS manager and as an eventCRM manager
    When  the user logged in with different valid credentials like the  email "<email>" and password "<password>"
    Then the user should see the Discuss page

    Examples:
      | email                        | password         |
      | posmanager5@info.com         | posmanager       |
      | posmanager15@info.com        | posmanager       |
      | posmanager40@info.com        | posmanager       |
      | posmanager50@info.com        | posmanager       |
      | posmanager75@info.com        | posmanager       |
      | posmanager100@info.COM       | posmanager       |
      | posmanager125@info.com       | posmanager       |
      | posmanager155@info.com       | posmanager       |
      | eventscrmmanager9@info.com   | eventscrmmanager |
      | eventscrmmanager10@info.com  | eventscrmmanager |
      | eventscrmmanager20@info.com  | eventscrmmanager |
      | eventscrmmanager50@info.com  | eventscrmmanager |
      | eventscrmmanager100@info.com | eventscrmmanager |
      | eventscrmmanager110@info.com | eventscrmmanager |
      | eventscrmmanager111@info.com | eventscrmmanager |





  Scenario: Verify that the user can log in with valid credentials as a  eventCRM manager by clicking on the "Login" button
    When the user logged in as "crmmanager" by clicking login button
    Then the user should see the Discuss page


  Scenario: Verify that the user can log in with valid credentials as a POS manager  by hitting the "Enter" key
    When the user logged in as "posmanager" by hitting enter key
    Then the user should see the Discuss page

  Scenario: Verify that the user can log in with valid credentials as a POS manager  by hitting the "Enter" key
    When the user logged in as "crmmanager" by hitting enter key
    Then the user should see the Discuss page


  Scenario Outline: Verify the "Wrong login/password" error message should be displayed after entering the invalid credentials
    When the user enters invalid credentials as the  email "<email>" and password "<password>"
    Then an error message "Wrong login/password" should be displayed

    Examples:
      | email                        | password         |
      | POSMANAGER50@info.com        | posmanager       |
      | posmanager50@info.com        | POSMANAGER       |
      | posmanager1@info.com         | posmanager       |
      | posmanager175@info.com       | posmanager       |
      | posmanager500@info.com       | posmanager       |
      | posmanager50@INFO.COM        | posmanager       |
      | eventscrmmanager9@info.com   | eventscrmmanager |
      | EVENTSCRMMANAGER10@info.com  | eventscrmmanager |
      | eventscrmmanager20@info.com  | EVENTSCRMMANAGER |
      | eventscrmmanager50@INFO.com  | eventscrmmanager |
      | eventscrmmanager100          | eventscrmmanager |
      | eventscrmmanager111@info.com | eventscrmmanager |
      | eventscrmmanager111qinfo.com | eventscrmmanager |




  Scenario Outline: Verify that the user gets the "Please fill out this field." message for at least one blank field.
    When the user leaves "<email>" or "<password>" field blank
   Then a message "Please fill out this field." should be displayed

   Examples:
     | email                        | password        |
     | posmanager50@info.com       |                  |
     |                             | posmanager       |
     |                             |                  |
     | eventscrmmanager10@info.com |                  |
     |                             | eventscrmmanager |



  Scenario: Logged-in user is logged out after browser back and forward navigation
    Given the user is on the login page
    When the user logged in as "posmanager" by clicking login button
    And the user should see the Discuss page
    And the user clicks the browser back button
    And the user clicks the browser forward button
    Then the user should be redirected to the login page
    And the user should be logged out





# you can use one of the given step here