Feature:Repairs Page Functionality for POS and Sales Managers

  Background:


  @halime
  Scenario Outline: Verify login pos and sales manager

    When the user logged in with different valid credentials as the "<mail>" and "<password>"
    Then User should be on the Discuss page
    When  user clicks on the  Repairs Page
    Then  user should be on the Repairs page
    Then User should see 6 columns in the repair orders table and The column headers should be:

      | Repair Reference    |
      | Product to Repair   |
      | Customer            |
      | Delivery Address    |
      | Warranty Expiration |
      | Status              |


    Examples:
      | mail                    | password     |
      | posmanager100@info.com  | posmanager   |
      | posmanager15@info.com   | posmanager   |
      | posmanager100@info.com  | posmanager   |
      | salesmanager52@info.com | salesmanager |
      | salesmanager78@info.com | salesmanager |
      | salesmanager90@info.com | salesmanager |
      | salesmanager90@info.com | salesmanager |

  @halime
  Scenario Outline: Search and verify repair record as POS or Sales Manager

    When the user logged in with different valid credentials as the "<mail>" and "<password>"
    Then User should be on the Discuss page
    When  user clicks on the  Repairs Page
    Then  user should be on the Repairs page
    When  User clicks the Search button
    And  User enters "RMA/00240" into the Repair Reference search field
    Then  The repair record with Repair Reference "RMA/00240" should be visible in the list

    Examples:
      | mail                    | password     |
      | posmanager100@info.com  | posmanager   |
      | posmanager15@info.com   | posmanager   |
      | posmanager100@info.com  | posmanager   |
      | salesmanager52@info.com | salesmanager |
      | salesmanager78@info.com | salesmanager |
      | salesmanager90@info.com | salesmanager |




