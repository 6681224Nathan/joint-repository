//Nathan Tanaboriboon 6681224
//Veerapat Leepiboonsawat 6580969

package Project2_6681224;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;

class Main
{
    public static void main(String[] args)
    {
        try
        {
            String path = "src/main/java/Project2_6681224/";
            Scanner sc = createFileScanner(path, "config_1.txt");
            int days = 0, warehouseNum = 0, freightNum = 0, freightCap = 0;
            int supplierNum = 0, supplierMin = 0, supplierMax = 0;
            int factoryNum = 0, factoryCap = 0;

            for(int i=0; sc.hasNext(); i++)
            {
                String line = sc.nextLine();
                if (i==0) {
                        days = Integer.parseInt(line.split(",")[1].trim());
                } else if (i==1) {
                        warehouseNum = Integer.parseInt(line.split(",")[1].trim());
                } else if (i==2) {
                        String[] parts = line.split(",");
                        freightNum = Integer.parseInt(parts[1].trim());
                        freightCap = Integer.parseInt(parts[2].trim());
                } else if (i==3) {
                        String[] parts = line.split(",");
                        supplierNum = Integer.parseInt(parts[1].trim());
                        supplierMin = Integer.parseInt(parts[2].trim());
                        supplierMax = Integer.parseInt(parts[3].trim());
                } else if (i==4) {
                        String[] parts = line.split(",");
                        factoryNum = Integer.parseInt(parts[1].trim());
                        factoryCap = Integer.parseInt(parts[2].trim());
                }
            }
            
            ArrayList<Warehouse> warehouses = new ArrayList<>();
            for (int i = 0; i < warehouseNum; i++) warehouses.add(new Warehouse());

            ArrayList<Freight> freights = new ArrayList<>();
            for (int i = 0; i < freightNum; i++) freights.add(new Freight(freightCap));

            CyclicBarrier dailyStart = new CyclicBarrier(1 + supplierNum + factoryNum);
            CyclicBarrier dayEnd = new CyclicBarrier(1 + supplierNum + factoryNum);
            CyclicBarrier suppliersDone = new CyclicBarrier(supplierNum + factoryNum);
            CyclicBarrier factoriesDone = new CyclicBarrier(factoryNum);

            ArrayList<SupplierThread> suppliers = new ArrayList<>();
            for (int i = 0; i < supplierNum; i++) {
                SupplierThread st = new SupplierThread("SupplierThread_" + i, warehouses,
                        supplierMin, supplierMax, days, dailyStart, suppliersDone, dayEnd
                        ,supplierNum);
                suppliers.add(st);
                st.start();
            }

            ArrayList<FactoryThread> factories = new ArrayList<>();
            for (int i = 0; i < factoryNum; i++) {
                FactoryThread ft = new FactoryThread("FactoryThread_" + i, warehouses, freights,
                        factoryCap, days, dailyStart, suppliersDone, factoriesDone, dayEnd
                , factoryNum);
                factories.add(ft);
                ft.start();
            }
            

            String mainName = Thread.currentThread().getName();
            System.out.printf("%16s  >>  ================== Parameters ==================\n", mainName);
            System.out.printf("%16s  >>  %-20s : %2d\n", mainName, "Days of simulation", days);
            System.out.printf("%16s  >>  %-20s : [", mainName, "warehouses");
            for (int i=0; i<warehouses.size(); i++) {
                System.out.print("Warehouse_" + i);
                if(i != warehouses.size()-1) System.out.print(", ");
                else System.out.println("]");
            }
            System.out.printf("%16s  >>  %-20s : [", mainName, "Freight");
            for (int i=0; i<freights.size(); i++) {
                System.out.print("Freight_" + i);
                if(i != freights.size()-1) System.out.print(", ");
                else System.out.println("]");
            }
            System.out.printf("%16s  >>  %-20s : max = %4d\n", mainName, "Freight capacity", freightCap);
            System.out.printf("%16s  >>  %-20s : [", mainName, "SupplierThreads");
            for (int i=0; i<suppliers.size(); i++) {
                System.out.print("SupplierThreads_" + i);
                if(i != suppliers.size()-1) System.out.print(", ");
                else System.out.println("]");
            }
            System.out.printf("%16s  >>  %-20s : min = %3d, max = %3d\n", mainName, "Daily supply", supplierMin
                    ,supplierMax);
            System.out.printf("%16s  >>  %-20s : [", mainName, "FactoryThreads");
            for (int i=0; i<factories.size(); i++) {
                System.out.print("FactoryThreads_" + i);
                if(i != factories.size()-1) System.out.print(", ");
                else System.out.println("]");
            }
            System.out.printf("%16s  >>  %-20s : max = %3d\n", mainName, "Daily production", factoryCap);
            

            
            for (int d = 1; d <= days; d++) {
                System.out.printf("%16s  >>\n%16s  >>  %s\n", Thread.currentThread().getName(), Thread.currentThread().getName()
                    , "=".repeat(30));
                System.out.printf("%16s  >>  Day %2d\n", Thread.currentThread().getName(), d);
                for (int i = 0; i < warehouses.size(); i++) {
                    System.out.printf("%16s  >>  Warehouse_%d balance  = %5d\n"
                            , Thread.currentThread().getName(),i, warehouses.get(i).getBalance());
                }
                for (int i = 0; i < freights.size(); i++) {
                    freights.get(i).reset();
                    System.out.printf("%16s  >>  Frieght_%d   capacity = %5d\n"
                            , Thread.currentThread().getName(),i, freights.get(i).getCapacity());
                }
                System.out.printf("%16s  >>  \n", Thread.currentThread().getName());
                
                dailyStart.await();
                dayEnd.await();
            }

            for (Thread t : suppliers) t.join();
            for (Thread t : factories) t.join();

            Collections.sort(factories);

            System.out.printf("%16s  >>  \n", Thread.currentThread().getName());
            System.out.printf("%16s  >>  %s\n", Thread.currentThread().getName(), "=".repeat(40));
            System.out.printf("%16s  >>  Summary\n", Thread.currentThread().getName());
            for (FactoryThread f : factories) {
                System.out.printf("%16s  >>  ", Thread.currentThread().getName());
                System.out.printf("%s: %d created, %3d shipped (%.2f%%)%n",
                        f.getName(), f.getTotalProduced(), f.getTotalShipped(),
                        f.getTotalProduced() == 0 ? 0.0 : 100.0 * f.getTotalShipped() / f.getTotalProduced());
            }
        }
        catch(Exception e) //the reason I use only Exception e is because I think InterruptedException is the only exception that
                           //might happen, missing file exception would have been caught in the createFileScanner already
                           //the createFileScanner itself is also a method borrowed from project1
        {
            e.printStackTrace();
        }
    }

    public static Scanner createFileScanner(String path, String fileName) 
    {
        String filePath = path + fileName;
        File file = new File(filePath);
        Scanner keyboardScanner = new Scanner(System.in);
        Scanner fileScanner = null;

        while(fileScanner == null){
            try {
                fileScanner = new Scanner(file);
            } catch(Exception e) {
                System.err.println(e);
                System.out.println("Enter correct file name (with.txt) = ");
                String ia = keyboardScanner.next();
                file = new File(path + ia);
                filePath = path + ia;
            }
        }

        System.out.println("Read from " + filePath);
        return fileScanner;
    }
    
    
}
