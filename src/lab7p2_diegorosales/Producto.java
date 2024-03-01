
package lab7p2_diegorosales;

public class Producto {
    int id, aisle, category, bin;
    String name;
    double price;

    public Producto() {
    }

    public Producto(int id, String name, int category, double price, int aisle, int bin) throws DiegoException{
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

    public void setAisle(int aisle) throws DiegoException{
        if(aisle>=100 && aisle<1000){
        this.aisle = aisle;
        }
        else{
            throw new DiegoException();
        }
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) throws DiegoException {
        if(category>=0 && category<10){
        this.category = category;
        }
        else{
            throw new DiegoException();
        }
    }

    public int getBin() {
        return bin;
    }

    public void setBin(int bin) throws DiegoException{
        if(bin>=100 && bin<1000){
        this.bin = bin;
        }
        else{
            throw new DiegoException();
        }
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
