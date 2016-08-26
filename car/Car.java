package Threads.car;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by magy on 26.08.16.
 */
public abstract class Car implements Runnable {

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

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Engine(1));
    }
}