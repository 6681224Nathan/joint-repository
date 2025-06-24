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
