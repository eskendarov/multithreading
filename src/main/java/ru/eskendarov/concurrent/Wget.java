package ru.eskendarov.concurrent;

public class Wget {

    public static void main(final String[] args) {
        final long timeout = 1000L;
        final int seconds = 100;

        new Thread(() -> {
            try {
                for (int i = 0; i < seconds; i++) {
                    Thread.sleep(timeout);
                    System.out.printf("\rLoading : %d%%", i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
