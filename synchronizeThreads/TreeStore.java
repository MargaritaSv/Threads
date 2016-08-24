package Threads.synchronizeThreads;

/**
 * Created by magy on 24.08.16.
 */
public class TreeStore {
    private static final double COEFICIENT_FOR_PRODUCTION = 0.6;
    private static final double COEFICIENT_FOR_SELL = 0.3;
    private static final int MAX_THREE = 200000;
    private int currTree = 0;

    public int getCurrTree() {
        return currTree;
    }

    public void addTree(int numberOfTree) {
        if ((numberOfTree > 0) && (numberOfTree + currTree <= MAX_THREE)) {
            currTree += numberOfTree;
        }
    }

    public void sellTree(int numberOfTree) {
        if ((numberOfTree > 0) && (currTree - numberOfTree >= 0)) {
            currTree -= numberOfTree;
        }
    }

    //thresh hold
    public boolean hasEnoughTree() {
        return currTree > COEFICIENT_FOR_SELL * MAX_THREE;
    }

    public boolean hasEnoughSpaceForTree() {
        return currTree < COEFICIENT_FOR_PRODUCTION * MAX_THREE;
    }
}
