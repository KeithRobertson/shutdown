Feature: Shutdown Windows on a timer

  Scenario Outline: A valid argument causes the shutdown to be delayed for the specified duration
    When I run shutdown with an argument of <delay> seconds
    Then windows shutdown is invoked after <delay> seconds

    Examples:
      | delay |
      | 10    |
      | 35   |
