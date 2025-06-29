days,                  5
warehouse_num,         3
freight_num_max,       2, 100
supplier_num_min_max,  3, 50, 100
factory_num_max,       3, 80
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
// Project2_XXX/Freight.java
// Names & IDs: [Replace with group member names and IDs]

package Project2_XXX;

import java.util.concurrent.locks.ReentrantLock;

public class Freight {
    private int capacity;
    private final int maxCapacity;
    private final ReentrantLock lock = new ReentrantLock();

    public Freight(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.capacity = maxCapacity;
    }

    public void reset() {
        lock.lock();
        try {
            capacity = maxCapacity;
        } finally {
            lock.unlock();
        }
    }

    public int ship(int products) {
        lock.lock();
        try {
            int shipped = Math.min(products, capacity);
            capacity -= shipped;
            System.out.println(Thread.currentThread().getName() + ": ship " + shipped + " (left = " + capacity + ")");
            return shipped;
        } finally {
            lock.unlock();
        }
    }

    public int getCapacity() {
        lock.lock();
        try {
            return capacity;
        } finally {
            lock.unlock();
        }
    }
}
// Project2_XXX/Main.java
// Names & IDs: [Replace with group member names and IDs]

package Project2_XXX;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        String folder = "Project2_XXX";
        File file = new File(folder + "/config_1.txt");

        try (Scanner sc = new Scanner(file)) {
            int days = 0, warehouseNum = 0, freightNum = 0, freightCap = 0;
            int supplierNum = 0, supplierMin = 0, supplierMax = 0;
            int factoryNum = 0, factoryCap = 0;

            while (sc.hasNext()) {
                String line = sc.nextLine().trim();
                if (line.startsWith("days")) {
                    days = Integer.parseInt(line.split(",")[1].trim());
                } else if (line.startsWith("warehouse_num")) {
                    warehouseNum = Integer.parseInt(line.split(",")[1].trim());
                } else if (line.startsWith("freight_num_max")) {
                    String[] parts = line.split(",");
                    freightNum = Integer.parseInt(parts[1].trim());
                    freightCap = Integer.parseInt(parts[2].trim());
                } else if (line.startsWith("supplier_num_min_max")) {
                    String[] parts = line.split(",");
                    supplierNum = Integer.parseInt(parts[1].trim());
                    supplierMin = Integer.parseInt(parts[2].trim());
                    supplierMax = Integer.parseInt(parts[3].trim());
                } else if (line.startsWith("factory_num_max")) {
                    String[] parts = line.split(",");
                    factoryNum = Integer.parseInt(parts[1].trim());
                    factoryCap = Integer.parseInt(parts[2].trim());
                }
            }

            List<Warehouse> warehouses = new ArrayList<>();
            for (int i = 0; i < warehouseNum; i++) warehouses.add(new Warehouse());

            List<Freight> freights = new ArrayList<>();
            for (int i = 0; i < freightNum; i++) freights.add(new Freight(freightCap));

            CyclicBarrier dailyStart = new CyclicBarrier(1 + supplierNum + factoryNum);
            CyclicBarrier suppliersDone = new CyclicBarrier(supplierNum);
            CyclicBarrier factoriesDone = new CyclicBarrier(factoryNum);

            List<SupplierThread> suppliers = new ArrayList<>();
            for (int i = 0; i < supplierNum; i++) {
                SupplierThread st = new SupplierThread("Supplier-" + i, warehouses,
                        supplierMin, supplierMax, days, dailyStart, suppliersDone);
                suppliers.add(st);
                st.start();
            }

            List<FactoryThread> factories = new ArrayList<>();
            for (int i = 0; i < factoryNum; i++) {
                FactoryThread ft = new FactoryThread("Factory-" + i, warehouses, freights,
                        factoryCap, days, dailyStart, suppliersDone, factoriesDone);
                factories.add(ft);
                ft.start();
            }

            for (int d = 1; d <= days; d++) {
                System.out.println("Day " + d);

                for (int i = 0; i < warehouses.size(); i++) {
                    System.out.println("Warehouse[" + i + "] = " + warehouses.get(i).getBalance());
                }

                for (int i = 0; i < freights.size(); i++) {
                    freights.get(i).reset();
                    System.out.println("Freight[" + i + "] = " + freights.get(i).getCapacity());
                }

                dailyStart.await();
            }

            for (Thread t : suppliers) t.join();
            for (Thread t : factories) t.join();

            factories.sort((a, b) -> {
                int cmp = b.getTotalProduced() - a.getTotalProduced();
                return cmp != 0 ? cmp : a.getName().compareTo(b.getName());
            });

            System.out.println("=== Summary ===");
            for (FactoryThread f : factories) {
                System.out.printf("%s: %d created, %d shipped (%.2f%%)\n",
                        f.getName(), f.getTotalProduced(), f.getTotalShipped(),
                        f.getTotalProduced() == 0 ? 0.0 : 100.0 * f.getTotalShipped() / f.getTotalProduced());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Missing config file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
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
// Project2_XXX/Warehouse.java
// Names & IDs: [Replace with group member names and IDs]

package Project2_XXX;

import java.util.concurrent.locks.ReentrantLock;

public class Warehouse {
    private int materials;
    private final ReentrantLock lock = new ReentrantLock();

    public void put(int amount) {
        lock.lock();
        try {
            materials += amount;
            System.out.println(Thread.currentThread().getName() + ": put " + amount + " (total = " + materials + ")");
        } finally {
            lock.unlock();
        }
    }

    public int get(int request) {
        lock.lock();
        try {
            int taken = Math.min(request, materials);
            materials -= taken;
            System.out.println(Thread.currentThread().getName() + ": get " + taken + " (left = " + materials + ")");
            return taken;
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        lock.lock();
        try {
            return materials;
        } finally {
            lock.unlock();
        }
    }
}



