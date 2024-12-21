Feature: Login and Update Profile Summary on Naukri

  Scenario: User logs in and updates the profile summary
    Given User navigates to the Naukri login page
    When User enters valid credentials
    And User logs in successfully
    Then User should be redirected to the profile page
    When User updates the profile summary
    Then User should see the updated profile summary
