package TP09.ex3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class BookInformations {
    private Map<Book,Integer> bookList;
    private Scanner sc;
    public BookInformations() {
        this.sc = new Scanner(System.in);
        this.bookList = new HashMap<>();
    }

    public void addBookInfo(){
        Book b = new Book();
        System.out.print("Please the amount of books added: ");
        while(!this.sc.hasNextInt()){
            this.sc.next();
            System.out.print("Please the amount of books added: ");
        }
        int amount = this.sc.nextInt();
        this.bookList.put(b,amount);
    }

    @Override
    public String toString() {
        String result = "Informations of books: \n";
        for(Book b: this.bookList.keySet()){
            result+= "---------------------------------------------\n"+
                    b+"\nAmount: "+this.bookList.get(b)+" ; \n";
        }
        return result;
    }

    public static void main(String[] args) {
            BookInformations bookInformations = new BookInformations();
            bookInformations.addBookInfo();
            bookInformations.addBookInfo();
            System.out.println(bookInformations);
    }
}
