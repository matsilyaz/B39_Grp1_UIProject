Feature: Order list and actions verification for POS Manager

  Background:
    Given User is on the login page
    When User logs in as POS Manager
    Then The POS manager is on the Base page
    Given The POS manager is on the Base page
    When User click Point of the Sale
    Then User should be on the Point of Sales page
    Then User click Orders button
    Then The POS manager checks the Order Reference

  @wip1
  Scenario: Verify the POS manager can view the order list

    Then All the orders should be displayed


  @wip1
    Scenario: Verify Action drop-down options

      When The POS manager clicks the Action drop-down
      Then The dropdown should contain Import, Export and Delete