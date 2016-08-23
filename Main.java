package Threads;

/**
 * Created by magy on 23.08.16.
 */
public class Main {
    public static void main(String[] args) {
        //extends thread
        Thread thread = new _1MyThread();

        //implementing runnable
        Thread thread1 = new Thread(new MyThread());

        thread.start();
        thread1.start();


        //lambda
        new Thread(() -> System.out.println("thread with lambda")).start();

        //using anonymous class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Some stuff");
            }
        }).start();


        for (int i = 0; i < 30; i++) {
            System.out.println("main thread " + i);
        }
    }
}
