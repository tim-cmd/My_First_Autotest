Feature: Logged in user should be able to search  for necessary music artist and then  play all available tracks.


  Scenario Outline: Login into account with correct credentials
    Given User navigates to mixcloud website
    When User clicks on the login button on homepage
    And User enters a valid username "<username>"
    And User enters a valid password "<password>"
    When User clicks on the login button
    Then User should be logged in
    Then User clicks Search field
    When User enters artistname in the Search field
    Then User opens the artists page
    When User plays all available tracks
    And User add artists to favorite
    Then User opens his own profile
    When Artist should be in favorites
    And User deletes favorites

    Examples:
      | username                | password |
      | artemlysechko@gmail.com | 260195   |

