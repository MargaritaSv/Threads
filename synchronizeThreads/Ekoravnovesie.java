package Threads.synchronizeThreads;

/**
 * Created by magy on 24.08.16.
 */
public class Ekoravnovesie implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.err.println("SAFE THE PLANTS!");
        }
    }
}
