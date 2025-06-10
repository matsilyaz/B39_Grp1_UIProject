Feature: discuss page click functionality


  Scenario: user should click Discuss module
    Given the user logged in with username as "salesmanager50@info.com" and password as "salesmanager"
    When the user clicked on Discuss module.
    Then the user should see the Discuss module page.


  Scenario: user should Calender module
    Given the user logged in with username as "salesmanager50@info.com" and password as "salesmanager"
    When the user clicked on Calender module.
    Then the user should see the Calender module page.

  @wip
  Scenario Outline: user should Calender module
    Given the user logged in with username as "salesmanager50@info.com" and password as "salesmanager"
    When the user clicked on "<module name>".
    Then the user should see the module page.
Examples:
  | module name     |
  | Discuss         |
  | Calendar        |
  | Notes           |
  | Contacts        |
  | CRM             |
  | Sales           |
  | Website         |
  | Point of Sale   |
  | Purchases       |
  | Inventory       |
  | Repairs         |
  | Invoicing       |
  | Email Marketing |
  | Events          |
  | Employees       |
  | Leaves          |
  | Expenses        |
  | Maintenance     |
  | Dashboards      |

