//Nathan Tanaboriboon 6681224
//Veerapat Leepiboonsawat 6580969

package Ex7_6681224;

import java.util.*;
import java.util.concurrent.*;

public class Ex7 {
    public static void main(String[] args) {
        Ex7 mainApp = new Ex7();
        mainApp.runSimulation();
    }

    public void runSimulation()
    {    
        Shop shop = new Shop();          
        Exchanger<Basket> exchanger = new Exchanger<>();        
        ArrayList<CustomerThread> allThreads = new ArrayList<>();
        ArrayList<Basket> allBaskets = new ArrayList<>();

        for(int i=0; i < 4; i++) 
        {
            Basket basket = new Basket("B"+i);
            CustomerThread thread = new CustomerThread("C"+i, shop, basket);
            if (i <= 1) thread.setExchanger(exchanger);
            else        thread.setExchanger(null);

            allBaskets.add(basket);
            allThreads.add(thread);
        }

        CyclicBarrier roundStart = new CyclicBarrier(allThreads.size() + 1);
        CyclicBarrier roundEnd   = new CyclicBarrier(allThreads.size() + 1);

        for (CustomerThread ct : allThreads) {
            ct.setBarriers(roundStart, roundEnd);
            ct.start();
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("#rounds (<=0 to quit)? ");
            int rounds = sc.nextInt();

            if (rounds <= 0) {
                for (CustomerThread ct : allThreads) ct.terminate();
                try { roundStart.await(); } catch (Exception e) { }
                break;
            }

            shop.reset();

            for (CustomerThread ct : allThreads) {
                ct.setRounds(rounds);
            }

            try {
                roundStart.await(); // allow threads to sync start/exchange message
                roundStart.await(); // allow threads to finish printing

                for (int i = 1; i <= rounds; i++) {
                    roundStart.await(); // let all threads start round i
                    roundEnd.await();   // wait for all to finish round i
                }
            } catch (Exception e) { e.printStackTrace(); }
        }

        try {
            for (CustomerThread ct : allThreads) ct.join();
        } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("Final basket balances:");
        for (Basket b : allBaskets) {
            System.out.printf("%s = %d\n", b.getName(), b.getItems());
        }
    }
}