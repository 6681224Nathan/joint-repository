//Nathan Tanaboriboon 6681224
//Veerapat Leepiboonsawat 6580969

package Ex7_6681224;

import java.util.concurrent.*;

public class CustomerThread extends Thread {
    private Shop shop;
    private Basket basket;
    private Exchanger<Basket> exchanger;
    private CyclicBarrier roundStart;
    private CyclicBarrier roundEnd;
    private int totalRounds;
    private boolean running = true;
    private boolean firstSimulation = true;

    public CustomerThread(String name, Shop shop, Basket basket) {
        super(name);
        this.shop = shop;
        this.basket = basket;
    }

    public void setExchanger(Exchanger<Basket> ex) { exchanger = ex; }
    public void setBarriers(CyclicBarrier start, CyclicBarrier end) {
        this.roundStart = start;
        this.roundEnd = end;
    }
    public void setRounds(int rounds) { this.totalRounds = rounds; }
    public void terminate() { running = false; }

    public void run() {
        while (true) {
            try {
                roundStart.await();  // wait for main signal
                if (!running) break;

                if (!firstSimulation && exchanger != null) {
                    System.out.printf("%-3s : exchange basket\n", Thread.currentThread().getName());
                    Basket oldBasket = basket;
                    basket = exchanger.exchange(basket);
                    /*System.out.printf("%-3s : received basket %s (was %s)\n",
                        Thread.currentThread().getName(), basket.getName(), oldBasket.getName());*/
                }

                System.out.printf("%-3s : start with basket %s\n",
                        Thread.currentThread().getName(), basket);
                roundStart.await();  // wait for all to finish printing start msg

                for (int i = 1; i <= totalRounds; i++) {
                    roundStart.await();  // wait for all to start this round
                    shop.buy(basket, i);
                    roundEnd.await();    // wait for all to finish this round
                }

                firstSimulation = false;
            } catch (Exception e) {
                break;
            }
        }
    }
}
