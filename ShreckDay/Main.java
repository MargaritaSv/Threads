package Threads.ShreckDay;

/**
 * Created by magy on 23.08.16.
 */
public class Main {
    public static void main(String[] args) {
        ShrekWoman fiona = new ShrekWoman();
        Thread fionaThread = new Thread(fiona, "Fiona");

        Shrek shrek = new Shrek(fionaThread);
        Thread shrekThread = new Thread(shrek);

        fiona.setShrek(shrek);
        fiona.setShrekThread(shrekThread);

        shrekThread.start();
    }
}