
@DP1
Feature: CP1 Home Page Test Cases 

  @slides
  Scenario Outline: Validate  Number of Slides displayed and title
    Given Dp1Home page url
    When user goes to Dp1 home page
    Then Slides containing title "<title>" are displayed for duration "<duration>"
    
    Examples: 
      | title                                                                     | duration |
      | Sixers Defeat Nets on the Road                       |    0      |
      | Sixers Take Down Hawks in Tournament Play |    0      |
      | Embiid Named Player of the Week                   |   0       |
