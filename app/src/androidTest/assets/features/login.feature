Feature: Hello World
  This is a first try to use Cucumber in Android instrumentation tests.

  @ScenarioId("FUNCTIONAL.AUTH.SCN.001")
  @UserStory("MyApp-135")
  Scenario: First Test
    Given I see the Calculator screen
    When I press the button 4
    And I press the button 2
    Then I should see the value 42 displayed
    And I take a screenshot