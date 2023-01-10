package TP06.ex5;

public class Product {
    String name;
    int id;
    double price;
    int stock;
    static int numberProducts = 0;
    public Product(String name, double price,int stock){
        this.name=name;
        this.price = price;
        this.stock=stock;
        this.id=++numberProducts;
    }

    @Override
    public String toString() {
        return this.id+" - "+this.name.toUpperCase()+" - "+this.price+" $ per unit - quantity: "+this.stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
