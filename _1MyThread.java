package Threads;

/**
 * Created by magy on 23.08.16.
 */
public class _1MyThread extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 30; i++) {
            System.err.println("Another thread ->" + i);

        }
    }
}
