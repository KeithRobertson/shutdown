package com.keith.shutdown.cucumber;

import cucumber.api.java8.En;

public class ShutdownStep implements En {
    public ShutdownStep() {
        Given("^I run shutdown with an argument of (\\d+) seconds$", (Integer arg1) -> {
        });

        When("^(\\d+) seconds have passed$", (Integer arg1) -> {
        });

        Then("^windows shutdown is invoked$", () -> {
        });
    }
}
