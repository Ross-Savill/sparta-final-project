Feature:Change password on accounts page
  Scenario: Input the same password for both inputs
    Given I am logged in
    And I click change password
    When I input the new password in ‘New Password’ field
    And  I input the exact same password in ‘Confirm Password’field
    Then my password is updated.

  Scenario: Input a different password for both inputs
    Given I am logged in
    And  I click change password
    When  I input the new password in ‘New Password’ field
    And  I input a different password in ‘Confirm Password’field
    Then the password isn’t updated.
    