package Threads;

/**
 * Created by magy on 23.08.16.
 */
public class MyThread implements Runnable {
    @Override
    public void run() {

        for (int i = 0; i < 30; i++) {
            System.out.println("My first thread." +i);

        }    }
}
