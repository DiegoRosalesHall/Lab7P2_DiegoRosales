
package lab7p2_diegorosales;

public class Producto {
    int id, aisle, category, bin;
    String name;
    double price;

    public Producto() {
    }

    public Producto(int id, int aisle, int category, int bin, String name, double price) {
        this.id = id;
        this.aisle = aisle;
        this.category = category;
        this.bin = bin;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAisle() {
        return aisle;
    }

    public void setAisle(int aisle) {
        this.aisle = aisle;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getBin() {
        return bin;
    }

    public void setBin(int bin) {
        this.bin = bin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
