// Project2_XXX/FactoryThread.java
// Names & IDs: [Replace with group member names and IDs]

package Project2_XXX;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class FactoryThread extends Thread {
    private final List<Warehouse> warehouses;
    private final List<Freight> freights;
    private final int maxProduction;
    private final int days;
    private final CyclicBarrier dailyStartBarrier;
    private final CyclicBarrier suppliersDoneBarrier;
    private final CyclicBarrier factoriesDoneBarrier;
    private final Random rand = new Random();
    private int unshippedProducts = 0;
    private int totalProduced = 0;
    private int totalShipped = 0;

    public FactoryThread(String name, List<Warehouse> warehouses, List<Freight> freights,
                         int maxProduction, int days,
                         CyclicBarrier dailyStartBarrier,
                         CyclicBarrier suppliersDoneBarrier,
                         CyclicBarrier factoriesDoneBarrier) {
        super(name);
        this.warehouses = warehouses;
        this.freights = freights;
        this.maxProduction = maxProduction;
        this.days = days;
        this.dailyStartBarrier = dailyStartBarrier;
        this.suppliersDoneBarrier = suppliersDoneBarrier;
        this.factoriesDoneBarrier = factoriesDoneBarrier;
    }

    @Override
    public void run() {
        try {
            for (int d = 1; d <= days; d++) {
                dailyStartBarrier.await();  // Wait for day start
                suppliersDoneBarrier.await();  // Wait for all suppliers

                Warehouse warehouse = warehouses.get(rand.nextInt(warehouses.size()));
                int got = warehouse.get(maxProduction);
                totalProduced += got;
                unshippedProducts += got;

                factoriesDoneBarrier.await(); // Wait for all factories to finish production

                Freight freight = freights.get(rand.nextInt(freights.size()));
                int shipped = freight.ship(unshippedProducts);
                totalShipped += shipped;
                unshippedProducts -= shipped;

                System.out.println(getName() + ": unshipped products = " + unshippedProducts);

                factoriesDoneBarrier.await(); // Wait again to sync before next day
            }

        } catch (Exception e) {
            System.err.println(getName() + " interrupted.");
        }
    }

    public int getTotalProduced() {
        return totalProduced;
    }

    public int getTotalShipped() {
        return totalShipped;
    }
}
