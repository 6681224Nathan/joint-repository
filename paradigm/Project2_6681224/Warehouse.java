//Nathan Tanaboriboon 6681224
//Veerapat Leepiboonsawat 6580969

package Project2_6681224;

class Warehouse {
    private int materials = 0;

    public synchronized int get(int request) {
        int taken = Math.min(request, materials);
        materials -= taken;
        return taken;
    }

    public synchronized void put(int materials) {
        this.materials += materials;
    }

    public synchronized int getBalance() {
        return this.materials;
    }
}
