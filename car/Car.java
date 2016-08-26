package Threads.car;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by magy on 26.08.16.
 */
public abstract class Car implements Runnable {

    public static final int NUMBER_OF_SEATS = 5;
    public static final int NUMBER_OF_TYRE = 3;
    private int number;

    public Car(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Make this part " + getPartName() + " №" + number);
    }

    public abstract String getPartName();

    public abstract int getTimeToBuild();

    static class Seat extends Car {

        public static final int TIME_TO_BUILD_SEAL = 3000;

        public Seat(int number) {
            super(number);
        }

        @Override
        public String getPartName() {
            return "seal";
        }

        @Override
        public int getTimeToBuild() {
            return TIME_TO_BUILD_SEAL;
        }
    }

    static class Tyre extends Car {

        public static final int TIME_TO_BUILD_TYRE = 2000;

        public Tyre(int number) {
            super(number);
        }

        @Override
        public String getPartName() {
            return "tyre";
        }

        @Override
        public int getTimeToBuild() {
            return TIME_TO_BUILD_TYRE;
        }
    }

    static class Frame extends Car {

        public static final int TIME_TO_BUILD_FRAME = 5000;

        public Frame(int number) {
            super(number);
        }

        @Override
        public String getPartName() {
            return "frame";
        }

        @Override
        public int getTimeToBuild() {
            return TIME_TO_BUILD_FRAME;
        }
    }

    static class Engine extends Car {

        public static final int TIME_TO_BUILD_ENGINE = 7000;

        public Engine(int number) {
            super(number);
        }

        @Override
        public String getPartName() {
            return "frame";
        }

        @Override
        public int getTimeToBuild() {
            return TIME_TO_BUILD_ENGINE;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long starTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(new Engine(1));

        for (int i = 0; i < NUMBER_OF_SEATS; i++) {
            executorService.submit(new Seat(i));
        }

        for (int i = 0; i < NUMBER_OF_TYRE; i++) {
            executorService.submit(new Tyre(i));
        }

        executorService.submit(new Frame(1));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("The we need to make car's parts: " + (System.currentTimeMillis() - starTime));
    }
}