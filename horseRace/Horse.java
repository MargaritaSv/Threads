package Threads.horseRace;

/**
 * Created by magy on 23.08.16.
 */
public class Horse implements Runnable {
    private String name;
    private int metros;

    public Horse(String name, int metros) {
        this.name = name;
        this.metros = metros;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Horse's name: " + this.getName());
        for (int i = 1; i <= 200; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Leaving the race " + this.getName());
                return;
            }

            System.out.println("Thread who started me is " + Thread.currentThread().getName());
            System.out.println("I am " + this.getName() + " and in " + i + "meter");
        }
    }
}