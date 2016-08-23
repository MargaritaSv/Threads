package Threads.ShreckDay;

/**
 * Created by magy on 23.08.16.
 */
public class Shrek implements Runnable {

    boolean hasGoodDay = false;
    Thread shrekWoman;

    public Shrek(Thread shrekWoman) {
        super();
        this.shrekWoman = shrekWoman;
    }

    @Override
    public void run() {

    }
}
