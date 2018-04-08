Feature: Shutdown Windows on a timer

  Scenario Outline: A valid argument causes the shutdown to be delayed for the specified duration
    Given I run shutdown with an argument of <delay> seconds
    When <delay> seconds have passed
    Then windows shutdown is invoked

    Examples:
      | delay |
      | 60    |
      | 200   |
