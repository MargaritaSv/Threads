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
        System.out.println("Hi,beautiful green woman! :D");

        if (!hasGoodDay) {
            System.out.println("I have a very bad day!");
            System.out.println("Give me a kiss," + this.shrekWoman.getName() + "! :)");

            try {
                System.out.println("Fiona!");
                shrekWoman.start();//dava i start(vika q)
                shrekWoman.join(2000);//until "shrekWoman" ended foresee action ,he doesn't move (but he wait 2000sek)

                if (!hasGoodDay) {   //if he doesn't  wait her(2000)
                    System.err.println("eeeeeeeeee give me deeee :D");
                    System.out.println("I'll sleep bad!");
                    return;
                }

                System.out.println("Good night!"); //and if he wait her
            } catch (InterruptedException ex) {
                System.out.println("I have bad morning!");
                return;
            }
        }
    }
}