package Threads.synchronizeThreads;

/**
 * Created by magy on 24.08.16.
 */
public class TreeStore {

    private static final int MAX_THREE = 200000;
    private int currTree = 0;

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
}
