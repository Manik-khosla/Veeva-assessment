
@DP1
Feature: CP1 Home Page Test Cases 

  @slides
  Scenario Outline: Validate  Number of Slides displayed and title
    Given Dp1Home page url
    When user goes to Dp1 home page
    Then Slides containing title "<title>" is displayed with "<href>"  for duration "<duration>"
    
    Examples: 
      | title                                                                      	  |                                    href                                                                                                  | duration |
      | Sixers Defeat Nets on the Road                         	|   /sixers/videos/philadelphia-76ers-vs-brooklyn-nets-nov-19-2023                                   |     10      |
      | Sixers Take Down Hawks in Tournament Play  	  |    /sixers/videos/philadelphia-76ers-vs-atlanta-hawks-highlights-nov-17-2023                 |     10      |
      | Embiid Named Player of the Week                   	  |   /sixers/news/joel-embiid-named-eastern-conference-player-of-the-week                      |     10      |
