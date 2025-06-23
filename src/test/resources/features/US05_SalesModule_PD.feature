Feature: Creation customer
      @pinar
      Scenario Outline: Sales Manager creates a new customer
            Given the user is logged in as Sales Manager using "<username>" and "salesmanager"
            When the user clicks on the Sales module
            Then the user clicks Customers button
            And the user clicks on Create button
            And the user fills in customer name field
            Then the user clicks on Save button
            Then the name of the new customer should created in the name field

            Examples:
                  | username                 |
                  | salesmanager101@info.com |
                  | salesmanager102@info.com |
                  | salesmanager105@info.com |

      @deniz
      Scenario Outline: Sales Manager creates a new customer
            Given the user is logged in as Sales Manager using "<username>" and "salesmanager"
            When the user clicks on the Sales module
            Then the user clicks Customers button
            And the user clicks on Create button
            And the user fills in customer name field
            Then the user clicks on Save button
            Then the name of the new customer should created in the name field
            When the user clicks on the newly created customer
            And the user clicks on Edit button
            And the user modifies the customer name
            And the user clicks on Save button after editing


            Examples:
                  | username                 |
                  | salesmanager101@info.com |
                  | salesmanager102@info.com |
                  | salesmanager105@info.com |

