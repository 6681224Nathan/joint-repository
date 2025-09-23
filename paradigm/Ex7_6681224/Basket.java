//Nathan Tanaboriboon 6681224
//Veerapat Leepiboonsawat 6580969

package Ex7_6681224;

public class Basket {
    private String name;
    private int items;

    public Basket(String id) { name = id; }    
    public String getName() { return name; }
    public int getItems() { return items; }
    public void setName(String newName) { this.name = newName; }
    public void add(int amount) { items += amount; }

    public String toString() {
        return String.format("%s = %d", name, items);
    }
}
