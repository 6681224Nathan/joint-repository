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
