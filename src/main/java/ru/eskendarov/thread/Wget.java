package ru.eskendarov.thread;

import java.io.*;
import java.net.URL;

public class Wget implements Runnable {

    private final String url;
    private final int speed;

    public Wget(final String url, final int speed) {
        this.url = url;
        this.speed = speed;
    }

    @Override
    public void run() {
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             final FileOutputStream fileOutputStream = new FileOutputStream("pom_tmp.xml")
        ) {
            final byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                Thread.sleep(Math.min(speed, 1000));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(final String[] args) throws InterruptedException {
        if (args.length != 2) {
            throw new IllegalArgumentException("input 2 arguments: String url, int speed");
        }
        final String url = args[0];
        final int speed = Integer.parseInt(args[1]);
        final Thread wget = new Thread(new Wget(url, speed));
        wget.start();
        wget.join();
    }
}
