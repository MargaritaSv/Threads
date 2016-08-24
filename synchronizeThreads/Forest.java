package Threads.synchronizeThreads;

/**
 * Created by magy on 24.08.16.
 */
public class Forest implements Runnable {
    private static final int NUMBER_OF_TREES = 50;
    private TreeStore treeStore;

    public Forest(TreeStore treeStore) {
        this.treeStore = treeStore;
    }


    @Override
    public void run() {
        for (int i = 0; i < NUMBER_OF_TREES; i++) {

            //wait for the space
            while (!treeStore.hasEnoughSpaceForTree()) {
                try {
                    treeStore.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //produce tree
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //notify others
            if (this.treeStore.hasEnoughTree()) {
                synchronized (treeStore) {
                    this.treeStore.notify();
                }
            }
        }
    }
}
