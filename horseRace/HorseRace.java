package Threads.horseRace;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by magy on 23.08.16.
 */
public class HorseRace {
    public static void main(String[] args) throws InterruptedException {
        Set<Horse> horses = new HashSet<>();
        horses.addAll(Arrays.asList(new Horse("Fasturcho", 882), new Horse("Burzii", 678), new Horse("Slowercho", 400),
                new Horse("ToiSiZnae", 500), new LameHorse("Kalinka", 500), new LameHorse("Minzyharche", 300)));

        Collection<Thread> horsesThreads = new HashSet<>();
        for (Horse horse : horses) {
            Thread th = new Thread(horse, horse.getName());

            th.start();
            horsesThreads.add(th);
        }

        Thread annalist = new Thread(new Annalist());
        annalist.setDaemon(true);
        annalist.start();

        for (Thread t : horsesThreads) {
            if (Math.random() > 0.7) {
                t.interrupt();
                t.join(); //InterrupEx... ot try-catch
            }
        }

        System.out.println("The race is over!Nice day people! :)");
    }
}
