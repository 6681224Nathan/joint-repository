//Nathan Tanaboriboon 6681224
//Veerapat Leepiboonsawat 6580969

package Project2_6681224;

import java.util.*;
import java.util.concurrent.*;

class FactoryThread extends Thread implements Comparable<FactoryThread>
{
    private ArrayList<Warehouse> warehouses;
    private ArrayList<Freight> freights;
    private int maxProduction;
    private int days;
    private CyclicBarrier dailyStartBarrier;
    private CyclicBarrier suppliersDoneBarrier;
    private CyclicBarrier factoriesDoneBarrier;
    private CyclicBarrier dayEnd;
    private int factoryNum;
    private Random rand = new Random();
    private int unshippedProducts = 0;
    private int totalProduced = 0;
    private int totalShipped = 0;

    public FactoryThread(String name, ArrayList<Warehouse> warehouses, ArrayList<Freight> freights,
                         int maxProduction, int days,
                         CyclicBarrier dailyStartBarrier,
                         CyclicBarrier suppliersDoneBarrier,
                         CyclicBarrier factoriesDoneBarrier,
                         CyclicBarrier dayEnd,
                         int factoryNum) 
    {
        super(name);
        this.warehouses = warehouses;
        this.freights = freights;
        this.maxProduction = maxProduction;
        this.days = days;
        this.dailyStartBarrier = dailyStartBarrier;
        this.suppliersDoneBarrier = suppliersDoneBarrier;
        this.factoriesDoneBarrier = factoriesDoneBarrier;
        this.dayEnd = dayEnd;
        this.factoryNum = factoryNum;
    }

    @Override
    public void run()
    {
        try
        {
            for(int d=1; d<=days; d++)
            {
                dailyStartBarrier.await();
                suppliersDoneBarrier.await();

                /*int supply = rand.nextInt(maxSupply - minSupply + 1) + minSupply;
                int warehouseIndex = rand.nextInt(warehouses.size());
                warehouses.get(warehouseIndex).put(supply);
                System.out.println(Thread.currentThread().getName() + "  >>  put  "
                + supply +"    Warehouse_" + warehouseIndex + " balance = " + warehouses.get(warehouseIndex).getBalance());
                */
                
                
                int materialsToday=0;
                int warehouseIndex = rand.nextInt(warehouses.size());
                Warehouse warehouse = warehouses.get(warehouseIndex);

                synchronized(warehouse){
                    materialsToday = warehouse.get(maxProduction);
                    synchronized(System.out){
                        /*System.out.println(Thread.currentThread().getName() + "  >>  get  "
                        + materialsToday +"    Warehouse_" + warehouseIndex + " balance = " + 
                        warehouses.get(warehouseIndex).getBalance());*/
                        System.out.printf("%16s  >>  get %4d materials    "
                                , Thread.currentThread().getName(), materialsToday);
                        System.out.printf("Warehouse_%d balance = %7d\n"
                                ,warehouseIndex, warehouses.get(warehouseIndex).getBalance());
                    }
                }
                
                factoriesDoneBarrier.await();
                
                synchronized(this){
                    unshippedProducts += materialsToday;
                    totalProduced += materialsToday;
                    synchronized(System.out){
                        /*System.out.println(Thread.currentThread().getName() + "  >>  total products to ship  =    "
                        + unshippedProducts);*/
                        System.out.printf("%16s  >>  total products to ship = %5d\n", Thread.currentThread().getName()
                                , unshippedProducts);
                    }
                }
               
                factoriesDoneBarrier.await();
                
                
                int freightIndex = rand.nextInt(freights.size());
                Freight freight = freights.get(freightIndex);
                
                synchronized(this){
                    int shippedProduct = freight.ship(unshippedProducts);
                    unshippedProducts -= shippedProduct;
                    totalShipped += shippedProduct;

                    synchronized(System.out){
                        /*System.out.println(Thread.currentThread().getName() + "  >>  ship "
                        + shippedProduct + " products   Freight_" + freightIndex + " storage size/capacity left =   " 
                        + (100-freight.getCapacity()) + " / " + (freight.getCapacity()));*/
                        System.out.printf("%16s  >>  ship %3d products     Freight_%d remaining capacity = %3d\n"
                                ,Thread.currentThread().getName(), shippedProduct, freightIndex, freight.getCapacity());
                    }
                }
                
                factoriesDoneBarrier.await();
                
                /*System.out.println(Thread.currentThread().getName() + "  >>  unshipped products=  " + unshippedProducts);*/
                System.out.printf("%16s  >>  unshipped products = %7d\n", Thread.currentThread().getName(), unshippedProducts);
                
                
                
                //System.out.println(getName() + " >> produced today = " + materialsToday);


                
                dayEnd.await();


            }
        }
        catch(Exception e)
        {
            System.err.println(Thread.currentThread().getName() + " gets interrupted");
        }
    }

    public int getTotalProduced() {
        return totalProduced;
    }

    public int getTotalShipped() {
        return totalShipped;
    }
    
    @Override
    public int compareTo(FactoryThread other)
    {
        if(this.getTotalProduced() != other.getTotalShipped())
        {
            return other.getTotalShipped() - this.getTotalProduced();
        }
        else
        {
            return other.getTotalShipped() - this.getTotalShipped();
        }
    } 

}