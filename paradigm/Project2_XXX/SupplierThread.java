// Project2_XXX/SupplierThread.java
// Names & IDs: [Replace with group member names and IDs]

package Project2_XXX;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class SupplierThread extends Thread {
    private final List<Warehouse> warehouses;
    private final int minSupply;
    private final int maxSupply;
    private final int days;
    private final CyclicBarrier dailyStartBarrier;
    private final CyclicBarrier suppliersDoneBarrier;
    private final Random rand = new Random();

    public SupplierThread(String name, List<Warehouse> warehouses, int minSupply, int maxSupply,
                          int days, CyclicBarrier dailyStartBarrier, CyclicBarrier suppliersDoneBarrier) {
        super(name);
        this.warehouses = warehouses;
        this.minSupply = minSupply;
        this.maxSupply = maxSupply;
        this.days = days;
        this.dailyStartBarrier = dailyStartBarrier;
        this.suppliersDoneBarrier = suppliersDoneBarrier;
    }

    @Override
    public void run() {
        try {
            for (int d = 1; d <= days; d++) {
                dailyStartBarrier.await();  // Wait for day to begin

                int supply = rand.nextInt(maxSupply - minSupply + 1) + minSupply;
                Warehouse warehouse = warehouses.get(rand.nextInt(warehouses.size()));
                warehouse.put(supply);

                suppliersDoneBarrier.await(); // Wait for all suppliers
            }
        } catch (Exception e) {
            System.err.println(getName() + " interrupted.");
        }
    }
}
