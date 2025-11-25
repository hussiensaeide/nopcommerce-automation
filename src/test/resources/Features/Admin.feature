Feature: Admin records management

  Scenario: Verify add and delete record
    Given User is on the login page
    Given I am logged in as admin
    And I navigate to Admin page
    When I get the current number of records
    And I add a new user
    Then the number of records should increase by 1
    When I search for the created user
    And I delete the user
    Then the number of records should decrease by 1
