Feature:  Smartbear software link verification
  Agile Story:
 

  Scenario:
    Given User is on smartbear link
    When User enters username as "Tester" and password as "test"
    And User clicks login button
    And User lands on main page
    Then User prints each link text on this page and count

  Scenario:
    Given User is on smartBear main page
    Then  User clicks Order
    And User selects familyAlbum and quantity 2
    And User clicks calculate
    And User fills the required personal information
    And User clicks on visa button
    And User enters credit card information and clicks process
    Then Verify success message


  Scenario:
    Given User is on smartBear main page
    When User clicks view all orders
    Then User finds "Susan McLaren" s order date as "01/05/2010"


