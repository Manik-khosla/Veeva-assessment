@CP
Feature: Contains CP Tests

  @FilterProducts @Jackets
  Scenario: Filter products by Department
    Given user is on core product home page
    When user selects "Shop" from  NavigationBar
    And select "Men's" Category
    And Filters By "Jackets"
    Then All "Jackets" are displayed
    
    @Videos
    Scenario: Count All Video Feeds
    Given user is on core product home page
    When user selects "..." from  NavigationBar
    And select "News & Features" Category
    Then All "Videos" upto "3d" are displayed
