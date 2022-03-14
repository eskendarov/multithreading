package ru.eskendarov.concurrent;

public class ConcurrentOutput {

    public static void main(String[] args) {

        final Thread first = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );

        final Thread second = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );

        first.start();
        second.start();
        System.out.println(Thread.currentThread().getName());
    }
}
