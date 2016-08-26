package Threads.car;

/**
 * Created by magy on 26.08.16.
 */
public abstract class Car {

    private int number;

    public Car(int number) {
        this.number = number;
    }

    public abstract String getPartName();

    public abstract int getTimeToBuild();

    static class Seat extends Car {

        public Seat(int number) {
            super(number);
        }

        @Override
        public String getPartName() {
            return "seal";
        }

        @Override
        public int getTimeToBuild() {
            return 3000;
        }
    }
}
