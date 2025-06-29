//Nathan Tanaboriboon 6681224
//Veerapat Leepiboonsawat 6580969

package Project2_6681224;

class Freight {
    private int capacity;
    private final int maxCapacity;

    public Freight(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.capacity = maxCapacity;
    }

    public synchronized void reset() {
        capacity = maxCapacity;
    }

    public synchronized int ship(int products) {
        int shipped = Math.min(products, capacity);
        capacity -= shipped;
        return shipped;
    }

    public synchronized int getCapacity() {
        return capacity;
    }
}
