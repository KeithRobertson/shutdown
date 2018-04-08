package com.keith.shutdown.os;

import java.time.Instant;

public class DummyShutdownInvoker implements ShutdownInvoker {

    private Instant instantInvoked;

    @Override
    public void shutdown() {
        this.instantInvoked = Instant.now();
    }

    public Instant getDelay() {
        return this.instantInvoked;
    }
}