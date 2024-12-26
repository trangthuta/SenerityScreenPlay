Feature: Test login function

  Scenario: Login successfully
    Given I open the website chatib.us
    And I enter a valid username "trangthuta1" into the username textbox
    And  I enter a valid password "trangthuta1" into the password textbox
    And I click on login button
    Then I login successfully