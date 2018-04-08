package com.keith.shutdown.cucumber;

import com.keith.shutdown.Shutdown;
import com.keith.shutdown.os.DummyShutdownInvoker;
import cucumber.api.java8.En;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShutdownStep implements En {
    private DummyShutdownInvoker shutdownInvoker;
    private Shutdown shutdown;
    private Instant startTime;
    private int delay;

    public ShutdownStep() {
        When("^I run shutdown with an argument of (\\d+) seconds$", (Integer totalDelay) -> {
            this.delay = totalDelay;
            this.startTime = Instant.now();
            this.shutdownInvoker = new DummyShutdownInvoker();
            this.shutdown = new Shutdown(shutdownInvoker);
            shutdown.start(this.delay);
        });

        Then("^windows shutdown is invoked after (\\d+) seconds$", (Integer expectedDelay) -> {
            Instant absoluteCorrectTime = this.startTime.plusSeconds(expectedDelay);
            Instant minimumCorrectTime = absoluteCorrectTime.minusSeconds(1);
            Instant maximumCorrectTime = absoluteCorrectTime.plusSeconds(1);

            Instant actualDelay = this.shutdownInvoker.getDelay();
            assertTrue(actualDelay.isAfter(minimumCorrectTime) && actualDelay.isBefore(maximumCorrectTime));
        });
    }
}
