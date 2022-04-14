package ru.eskendarov.concurrent;

import static java.lang.Thread.State.TERMINATED;

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

        System.out.printf("First: %s, Second: %s\n", first.getState(), second.getState());
        while (!(first.getState() == TERMINATED && second.getState() == TERMINATED)) {
            System.out.printf("First: %s, Second: %s\n", first.getState(), second.getState());
        }
        System.out.printf("First: %s, Second: %s\n", first.getState(), second.getState());

        System.out.println("Job completed!");
    }
}
