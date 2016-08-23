package Threads;

/**
 * Created by magy on 23.08.16.
 */
public class MyThread implements Runnable {
    @Override
    public void run() {

        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                System.out.println("Something wrong happened");
            }

            System.out.println("My first thread." + i);
        }
    }
}
