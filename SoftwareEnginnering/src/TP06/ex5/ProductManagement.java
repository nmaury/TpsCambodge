package TP06.ex5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    List<Product> productList;
    Scanner sc;
    public ProductManagement(){
        this.productList=new ArrayList<>();
        this.sc = new Scanner(System.in);
        this.displayMenu();
    }
    private void displayMenu(){
        System.out.printf("-----------------------------------------\n1. List all products in shop with product number, name, price, and amount in stock\n" +
                "2. Add new product to the list\n" +
                "3. Remove product from list by index\n" +
                "4. Update product in list\n"+
                "5. Exit program\n"+
                "Choice: ");
        int choice = sc.nextInt();
        System.out.print("-----------------------------------------\n");
        switch (choice){
            case 1 :
                this.listProducts();
                break;
            case 2 :
                this.addNewProduct();
                break;
            case 3 :
                this.removeByIndex();
                break;
            case 4 :
                this.updateProduct();
            case 5 :
                sc.close();
                System.exit(1);
                break;
        }
    }
    private void listProducts(){
        for(Product p : this.productList){
            System.out.println(p);
        }
        this.displayMenu();
    }
    private void addNewProduct(){
        System.out.print("Please enter a product name: ");
        String name = sc.next();
        System.out.print("Please enter a product price ($): ");
        double price = sc.nextDouble();
        System.out.print("Please enter a product stock: ");
        int stock = sc.nextInt();
        this.productList.add(new Product(name,price,stock));
        this.displayMenu();
    }
    private void removeByIndex(){
        System.out.print("Please enter a product index: ");
        int index = this.sc.nextInt();
        this.productList.removeIf(p -> p.id == index);
        this.displayMenu();
    }
    private void updateProduct(){
        System.out.print("Please enter a product index: ");
        int index = this.sc.nextInt();
        System.out.print("Choose between the options: \n"+
                            "1- Change the name of the product \n"+
                            "2- Change the price of the product \n"+
                            "3- Change the quantity of the product \n"+
                            "4- Change all \n"+
                            "Choice : ");
        int choiceUpdate = this.sc.nextInt();
        switch (choiceUpdate) {
            case 1 -> this.changeName(index);
            case 2 -> this.changePrice(index);
            case 3 -> this.changeQuantity(index);
            case 4 -> this.changeAll(index);
        }
    }
    private void changeName(int index){
        System.out.print("Please enter a new name: ");
        String name = this.sc.next();
        for (Product p : this.productList){
            if(p.id == index){
                p.setName(name);
            }
        }
        this.displayMenu();
    }
    private void changePrice(int index){
        System.out.print("Please enter a new price ($): ");
        double price = this.sc.nextDouble();
        for (Product p : this.productList){
            if(p.id == index){
                p.setPrice(price);
            }
        }
        this.displayMenu();
    }
    private void changeQuantity(int index){
        System.out.print("Please enter a new quantity: ");
        int quantity = this.sc.nextInt();
        for (Product p : this.productList){
            if(p.id == index){
                p.setStock(quantity);
            }
        }
        this.displayMenu();
    }
    private void changeAll(int index){
        System.out.print("Please enter a new name: ");
        String name = this.sc.next();
        System.out.print("Please enter a new price ($): ");
        double price = this.sc.nextDouble();
        System.out.print("Please enter a new quantity: ");
        int quantity = this.sc.nextInt();
        for (Product p : this.productList){
            if(p.id == index){
                p.setPrice(price);
                p.setName(name);
                p.setStock(quantity);
            }
        }
        this.displayMenu();
    }

    public static void main(String[] args) {
        ProductManagement productManagement = new ProductManagement();
    }

}
