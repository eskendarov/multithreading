package ru.eskendarov.concurrent;

public class ThreadState {

    private ThreadState() {
    }

    public static void main(final String[] args) {

        final Thread first = new Thread(
                () -> System.out.println(Thread.currentThread().getName()),
                "First Thread"
        );
        final Thread second = new Thread(
                () -> System.out.println(Thread.currentThread().getName()),
                "Second Thread"
        );

        first.start();
        second.start();
        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Job completed!");
    }
}
