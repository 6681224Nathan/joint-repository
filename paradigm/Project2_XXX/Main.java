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
