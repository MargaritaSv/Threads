package Threads.horseRace;

/**
 * Created by magy on 23.08.16.
 */
public class LameHorse extends Horse {
    public LameHorse(String name, int metros) {
        super(name, metros);
    }

    @Override
    public int getSpeed() {
        return super.getSpeed() / 3;
    }
}