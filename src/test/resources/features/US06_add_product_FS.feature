@add
Feature: Add Product Functionality

 # Background:
   # Given the user is  on the login page
   # When the user logs in as "pos"
    #Then the user should see the Discuss page
   # When the POS Manager clicks the Inventory button
   # And the POS Manager clicks the Products button

@product
  Scenario Outline: Create a new product with only Product Name
  Given User logs in using "<username>" and "posmanager"
  When the user should see the Discuss page
  Then the POS Manager clicks the Inventory button
  And the POS Manager clicks the Products button
  And clicks the Create button
    And enters product name
    And clicks the Save button
   # And clicks the Products button
    Then Verify the user sees information of the product name

  Examples:
    |username|
    |posmanager6@info.com|
    #|posmanager16@info.com|
    #|posmanager26@info.com|

  @edit
  Scenario Outline: Edit any existing product
  Given User logs in using "<username>" and "posmanager"
  When the user should see the Discuss page
  Then the POS Manager clicks the Inventory button
  And the POS Manager clicks the Products button

    Then the POS Manager is on the Product List page
    And the user clicks any product
    And the user clicks the Edit button
    And the user changes the Product Name
    And Verify all the boxes  are editable
    And the user clicks the Save button
    #And the user clicks the Products button
    Then the new information of product should be displayed in the product list.

  Examples:
    |username|
    |posmanager6@info.com|
    #|posmanager16@info.com|
    #|posmanager26@info.com|
  @dekked
  Scenario Outline: login

    Given User logs in using "<username>" and "posmanger"
    Then User lands in Discuss page
    |Discuss|
    |Calander|
    |Repairs|


   Examples:
   |username|
    |posmanager6@info.com|
    |posmanager16@info.com|
    |posmanager26@info.com|





