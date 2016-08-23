package Threads.horseRace;

/**
 * Created by magy on 23.08.16.
 */
public class Annalist implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("************Az si analiziram tam..");
        }
    }
}