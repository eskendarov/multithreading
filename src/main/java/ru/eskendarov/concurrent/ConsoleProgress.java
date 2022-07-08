package ru.eskendarov.concurrent;

public final class ConsoleProgress implements Runnable {

    @Override
    public void run() {
        final char[] process = {'\\', '/', '|'};
        final long timeout = 500L;

        while (!Thread.currentThread().isInterrupted()) {
            try {
                for (char s : process) {
                    Thread.sleep(timeout);
                    System.out.printf("\rLoading: %s", s);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
