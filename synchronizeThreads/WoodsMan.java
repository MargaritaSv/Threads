package Threads.synchronizeThreads;

/**
 * Created by magy on 24.08.16.
 */
public class WoodsMan implements Runnable {

    private TreeStore treeStore;

    public WoodsMan(TreeStore treeStore) {
        this.treeStore = treeStore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            int howMuchToBuy = (int) (Math.random() * 20000) + 2;

            while (this.treeStore.getCurrTree() <= howMuchToBuy) {
                synchronized (treeStore) {
                    try {
                        treeStore.wait();

                        if (this.treeStore.getCurrTree() <= howMuchToBuy) {
                            System.out.println("The tree store is empty!Buy!");
                            return;
                        }
                    } catch (InterruptedException e) {
                        // e.printStackTrace();
                        return;
                    }
                }
            }
        }
    }
}