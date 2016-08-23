package Threads.horseRace;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by magy on 23.08.16.
 */
public class HorseRace {
    public static void main(String[] args) {
        Set<Horse> horses = new HashSet<>();
        horses.addAll(Arrays.asList(new Horse("Fasturcho", 882), new Horse("Burzii", 678), new Horse("Slowercho", 400), new Horse("ToiSiZnae", 500)));

    }
}
