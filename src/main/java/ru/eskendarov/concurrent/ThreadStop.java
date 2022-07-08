package ru.eskendarov.concurrent;

public class ThreadStop {

    public static void main(final String[] args) throws InterruptedException {
        final long timeout = 3000L;
        final Thread thread = new Thread(new ConsoleProgress());
        thread.start();
        Thread.sleep(timeout);
        thread.interrupt();
    }
}
