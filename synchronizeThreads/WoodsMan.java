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

            int howMuchToBuy = (int) (Math.random() * 200) + 2;
            System.out.println("I'll buy " + howMuchToBuy + " woods.");

            while (this.treeStore.getCurrTree() <= howMuchToBuy) {
                synchronized (treeStore) {
                    try {
                        System.out.println("Doesn't have enough woods.I'll wait.");
                        treeStore.wait(200);

                        if (this.treeStore.getCurrTree() <= howMuchToBuy) {
                            System.out.println("The tree store is empty!Buy!");
                            return;
                        }
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }

            System.out.println("Woods man buy a tree.");
            synchronized (treeStore) {
                treeStore.sellTree(howMuchToBuy);
            }

            if (treeStore.hasEnoughSpaceForTree()) {
                synchronized (treeStore) {
                    System.out.println("Other woods man can buy also.");
                    treeStore.notify();
                }
            }

        }
    }
}