package Threads.horseRace;

/**
 * Created by magy on 23.08.16.
 */
public class Horse implements Runnable {
    public static final int METERS = 50;
    private String name;
    private int speed;

    public Horse(String name, int metros) {
        this.name = name;
        this.speed = metros;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        System.out.println("Horse's name: " + this.getName());
        for (int i = 1; i <= METERS; i++) {
            try {
                Thread.sleep(500 / getSpeed());
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

            if (Thread.currentThread().isInterrupted()) {
                System.err.println("Leaving the race " + this.getName());
                return;
            }

            System.err.println("Thread who started me is " + Thread.currentThread().getName());
            System.out.println("I am " + this.getName() + " and in " + i + "m.");
        }

        System.out.println(this.getName() + "                        --> FINISH!");
    }
}