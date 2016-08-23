package Threads.ShreckDay;

/**
 * Created by magy on 23.08.16.
 */
public class ShrekWoman implements Runnable {
    Shrek shrek;
    private Thread shrekThread;//composition

    public Shrek getShrek() {
        return shrek;
    }

    public void setShrek(Shrek shrek) {
        this.shrek = shrek;
    }

    public void setShrekThread(Thread shrekThread) {
        this.shrekThread = shrekThread;
    }

    @Override
    public void run() {
        try {
            if (!shrek.hasGoodDay) {
                System.out.println("I will kiss him when: ");
                Thread.sleep(200);
                System.out.println(" ---> I get from the bad");
                Thread.sleep(200);
                System.out.println(" ---> I drink coffee");
                Thread.sleep(300);
                System.out.println("Kiss");
                shrek.hasGoodDay = true;
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}