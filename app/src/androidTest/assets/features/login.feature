Feature: Hello World

  Scenario: First Test
    Given I see the Calculator screen
    When I press the button 4
    And I press the button 2
    Then I should see the value 42 displayed