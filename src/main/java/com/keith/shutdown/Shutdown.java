package com.keith.shutdown;

import com.keith.shutdown.os.ShutdownInvoker;

public class Shutdown {

    private static final int MILLIS_IN_SECOND = 1000;
    private final ShutdownInvoker shutdownInvoker;

    public Shutdown(ShutdownInvoker shutdownInvoker) {
        this.shutdownInvoker = shutdownInvoker;
    }

    public void start(int delay) {
        int delayInMillis = delay * MILLIS_IN_SECOND;
        try {
            Thread.sleep(delayInMillis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        this.shutdownInvoker.shutdown();

    }
}
