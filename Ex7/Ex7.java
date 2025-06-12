// Don't forget to rename the package
package Ex7;    

import java.util.*;
import java.util.concurrent.*;

////////////////////////////////////////////////////////////////////////////////
class CustomerThread extends Thread {
    private Shop                sharedShop;    
    private Basket              basket;
    private Exchanger<Basket>   exchanger;         
    private CyclicBarrier       barrier;
    private int                 rounds;

    public CustomerThread(String n, Shop sa, Basket bk) { 
        super(n); 
        sharedShop = sa;
        basket     = bk; 
    }
    public void setBarrier(CyclicBarrier ba)         { barrier = ba; }
    public void setExchanger(Exchanger<Basket> ex)   { exchanger = ex; }
    
    public void run() {
        // Loop for shopping simulation. In each simulation:        
        //  (1) Wait until main thread gets #rounds from user and pass it to CustomerThread.
        
        //  (2) If this is the first simulation, skip this step.
        //      Otherwise, threads with exchanger exchange baskets.
        //      Threads without exchanger (i.e. exchanger is null) wait until this is done.
        
        //  (3) Each thread identifies current basket in this simulation.
        
        //  (4) Each thread buys items from the same shop & put them in current basket.
        //      Do it for #rounds. In each round, update shop & basket balance.
        
        // Break from loop & return if user doesn't want to run a new simulation
    }
}

////////////////////////////////////////////////////////////////////////////////
class Shop {
    private int items;       //remaining items
     
    public Shop()            { }
    public int getItems()    { return items; }
    
    public void reset() 
    {
        // Reset remaining items to 100
        // Report thread activity (see example output)
    }
    
    public void buy()
    {
        // Random amount of items to buy from 1 to items/2; update shop balance
        // Put items in thread's current basket; update basket balance
        // Report thread activity (see example output)
    }
}

////////////////////////////////////////////////////////////////////////////////
class Basket {
    private String name;
    private int    items;
    
    public Basket(String id)    { name  = id; }    
    public String getName()     { return name; }
    public int    getItems()    { return items; } 
    
    public void add()
    {
        // Add items to basket
    }
}
////////////////////////////////////////////////////////////////////////////////
public class Ex7 {
    public static void main(String[] args) {
        Ex7 mainApp = new Ex7();
        mainApp.runSimulation();
    }

    public void runSimulation()
    {    
        Shop shop = new Shop();          
        Exchanger<Basket> exchanger          = new Exchanger<>();        
        ArrayList<CustomerThread> allThreads = new ArrayList<>();
        ArrayList<Basket>         allBaskets = new ArrayList<>();

        for(int i=0; i < 4; i++) 
        {
            Basket basket         = new Basket("B"+i);
            CustomerThread thread = new CustomerThread("C"+i, shop, basket);
            if (i <= 1) thread.setExchanger(exchanger);
            else        thread.setExchanger(null);
            
            allBaskets.add( basket );
            allThreads.add( thread );
        }
        
        CyclicBarrier barrier = new CyclicBarrier( allThreads.size()+1 );
        
        
        // Start all BankThreads

        
        // Loop for shopping simulation. In each simulation:
        //  (1) Main thread reset shop's balance
        //  (2) Main thread gets #rounds from user and passes it to CustomerThread.
        //  (3) Main thread waits until all CustomerThreads complete #rounds of shopping.
        
        
        // If user dosn't want to run a new simulation:
        //   - Main thread waits until all CustomerThreads return.
        //   - Main thread reports final balances of all baskets.
    }
}
