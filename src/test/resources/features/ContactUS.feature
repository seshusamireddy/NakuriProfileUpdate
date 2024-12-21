Feature:  Contact us

  Scenario: Validate Sucessful on submit
    Given I open url
    When I enter firstname
    And I enter email
    And I enter Comment
    And submit
    Then I should the sucess message