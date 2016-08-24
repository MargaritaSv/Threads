package Threads.synchronizeThreads;

/**
 * Created by magy on 24.08.16.
 */
public class Main {
    public static void main(String[] args) {
        TreeStore treeStore = new TreeStore();
        Forest forest = new Forest(treeStore);
        WoodsMan woodsMan = new WoodsMan(treeStore);

        // for (int i = 0; i < 11; i++) {
        new Thread(forest).start();
        new Thread(woodsMan).start();
        // }

        Ekoravnovesie safeTree = new Ekoravnovesie();
        new Thread(safeTree).setDaemon(true);
        safeTree.run();
    }
}
