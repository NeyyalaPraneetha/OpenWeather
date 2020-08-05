Feature: Open Weather map with city

  Scenario Outline: 1 Search the forcast with the city name
    Given the home page of opens Weather map is displayed
    And the user searches with <city_name>
    When the user click on cityname on the page <city_name>
    Then the Weather forcaste is displayed for the <city_name> on the page
    Examples:
      | city_name |
      | Norwich   |
      | Dundee    |
      | Edinburgh |
      | Glasgow   |
      | Perth     |
      | Stirling  |

  Scenario Outline: 2 Search to get given no of days forcast for a given location
    Given the home page of opens Weather map is displayed
    And the user searches with <city_name>
    When the user click on cityname on the page <city_name>
    Then the Weather forcaste is displayed for all "5" days on the page
    Examples:
      | city_name |
      | Norwich   |
      | Dundee    |
      | Edinburgh |
      | Glasgow   |
      | Perth     |
      | Stirling  |

  Scenario Outline: 3 search with incorrect cityname
    Given the home page of opens Weather map is displayed
    When the user searches with <cityname>
    Then the error message "Search engine is very flexible. How it works:"
    Examples:
      | cityname |
      | invalid  |
      |          |

  Scenario: 4 select a day for summary forcast
    Given the home page of opens Weather map is displayed
    And the user searches with Edinburgh
    When the user click on cityname on the page Edinburgh
    Then the weather forcast should display for summary of whole day

  Scenario: 5 Select a day twice temeperature summary for the whole day should be hidden
    Given the home page of opens Weather map is displayed
    And the user searches with Perth
    And the user click on cityname on the page Perth
    And the Weather forcaste is displayed for the Perth on the page
    When the user clicks to hide the summary info
    Then the weather forcast of whole day is not displayed


