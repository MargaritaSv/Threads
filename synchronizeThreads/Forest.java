package Threads.synchronizeThreads;

/**
 * Created by magy on 24.08.16.
 */
public class Forest implements Runnable {
    private static final int NUMBER_OF_TREES = 50;
    private static final int THREE_TO_PRODUCE = 34;
    private TreeStore treeStore;

    public Forest(TreeStore treeStore) {
        this.treeStore = treeStore;
    }


    @Override
    public void run() {
        for (int i = 0; i < NUMBER_OF_TREES; i++) {
            System.out.println("I begin to cut trees");
            //wait for the space
            while (!treeStore.hasEnoughSpaceForTree()) {
                try {
                    synchronized (treeStore) {
                        System.out.println("The woodsman cutting woods or not .. I'll wait.");
                        treeStore.wait();
                    }
                } catch (InterruptedException e) {
                    System.out.println("Buy!");
                    return;
                }
            }

            //produce tree
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Produce the woods");
            synchronized (treeStore) {
                this.treeStore.addTree(THREE_TO_PRODUCE);
            }

            //notify others
            if (this.treeStore.hasEnoughTree()) {
                synchronized (treeStore) {
                    //   System.out.println("There is enough tree.Call the other woodsman");
                    this.treeStore.notify();
                }
            }
        }
    }
}