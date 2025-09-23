//Nathan Tanaboriboon 6681224
//Veerapat Leepiboonsawat 6580969

package Ex7_6681224;

import java.util.concurrent.*;

public class Shop {
    private int items;
    private final Semaphore mutex = new Semaphore(1);

    public int getItems() { return items; }

    public void reset() {
        items = 100;
        System.out.printf("%-3s : Shop reset to 100 items\n", Thread.currentThread().getName());
    }

    public void buy(Basket basket, int round) {
        try {
            mutex.acquire();
            if (items == 0) {
                System.out.printf("%-3s : Round %2d    no items to buy\n",
                        Thread.currentThread().getName(), round);
                return;
            }
            int wantToBuy = 1 + (int)(Math.random() * (items / 2 + 1));
            items -= wantToBuy;
            basket.add(wantToBuy);
            System.out.printf("%-3s : Round %2d    buy    %2d    shop balance = %3d    %s\n",
                    Thread.currentThread().getName(), round, wantToBuy, items, basket);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mutex.release();
        }
    }
}