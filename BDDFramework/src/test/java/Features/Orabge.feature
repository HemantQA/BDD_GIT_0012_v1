Feature: Test orange HRM Application

  Scenario: validate login functionality
    Given user is on login page
    When user enter valid userrname and valid password
      | Admin | admin123 |
    Then user click login button
    And user capture title
