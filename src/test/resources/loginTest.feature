Feature: Saucelab Mobile App Functionality


  @local
  Scenario: Test login functionality on local setup
    When User login to mobile app with "local" setup
    Then the user should have access to the dashboard
