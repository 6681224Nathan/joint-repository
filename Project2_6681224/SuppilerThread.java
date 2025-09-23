//Nathan Tanaboriboon 6681224
//Veerapat Leepiboonsawat 6580969

package Project2_6681224;

import java.util.*;
import java.util.concurrent.*;

class SupplierThread extends Thread
{
    private ArrayList<Warehouse> warehouses;
    private int minSupply;
    private int maxSupply;
    private int days;
    private CyclicBarrier dailyStartBarrier;
    private CyclicBarrier suppliersDoneBarrier;
    private CyclicBarrier dayEnd;
    private int supplierNum;
    private Random rand = new Random();

    public SupplierThread(String name, ArrayList<Warehouse> warehouses, int minSupply, int maxSupply,
                          int days, CyclicBarrier dailyStartBarrier, CyclicBarrier suppliersDoneBarrier
                          ,CyclicBarrier dayEnd, int supplierNum) {
        super(name);
        this.warehouses = warehouses;
        this.minSupply = minSupply;
        this.maxSupply = maxSupply;
        this.days = days;
        this.dailyStartBarrier = dailyStartBarrier;
        this.suppliersDoneBarrier = suppliersDoneBarrier;
        this.dayEnd = dayEnd;
        this.supplierNum = supplierNum;
    }


    @Override
    public void run()
    {
        try
        {
            for(int d=1; d<= days; d++)
            {
                dailyStartBarrier.await();
                
                
                int supply = rand.nextInt(maxSupply - minSupply + 1) + minSupply;
                int warehouseIndex = rand.nextInt(warehouses.size());
                Warehouse warehouse = warehouses.get(warehouseIndex);
                
                synchronized(warehouse){
                    warehouse.put(supply);
                    synchronized(System.out){
                        
                        /*System.out.println(Thread.currentThread().getName() + "  >>  put  "
                        + supply +"    Warehouse_" + warehouseIndex + 
                        " balance = " + warehouses.get(warehouseIndex).getBalance());*/
                        System.out.printf("%16s  >>  put %4d materials    "
                                , Thread.currentThread().getName(), supply);
                        System.out.printf("Warehouse_%d balance = %7d\n"
                                ,warehouseIndex, warehouses.get(warehouseIndex).getBalance());
                    }
                }
                suppliersDoneBarrier.await();
                dayEnd.await();
                
            }
        }
        catch(Exception e)
        {
            System.err.println(getName() + " gets interrupted");
        }
    }
    


}