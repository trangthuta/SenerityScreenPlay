Feature: Test login function

  @chat
  Scenario: Login successfully
    Given Username_1 open the website chatib.us
    When Username_1 enter a valid username "trangthuta1" into the username textbox
    And Username_1 enter a valid password "trangthuta1" into the password textbox
    And Username_1 click on login button
    And Username_1 login successfully , a welcome message display at home page to welcome "trangthuta1"
    And Username_1 click on search icon
    And Username_1 enter "Trangthuta2" into search input textbox
    And Username_1 choose value "Viet Nam" in All Countries dropdown
    And Username_1 click on search button
    And Username_1 choose account "Trangthuta2" from  searching result
    And Username_1 send message "Hello friend" to account "Trangthuta2"
    And Username_2 open the website chatib.us
    And Username_2 enter a valid username "trangthuta2" into the username textbox
    And Username_2 enter a valid password "trangthuta2" into the password textbox
    And Username_2 click on login button
    And Username_2 login successfully , a welcome message display at home page to welcome "trangthuta2"
    And Username_2 have inbox notification and click on that
    Then Username_2 received a message "Hello friend" from account "trangthuta1"





