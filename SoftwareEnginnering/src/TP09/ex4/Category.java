package TP09.ex4;

import TP09.ex3.Book;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private String description;
    private List<Book> bookList;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
        this.bookList = new ArrayList<>();
    }
    public void addBook(Book b){
        this.bookList.add(b);
    }
    public void removeBook(Book b){
        this.bookList.removeIf(book -> book.getTitle().equals(b.getTitle()));
    }
    public void listBooks(){
        this.bookList.forEach(book -> System.out.println(book));
    }
    public void findBooksByIsbn(int isbn){
        this.bookList.forEach(book->{
            if(book.getIsbn()==isbn){
                System.out.println(book);
            }
        });
    }
    public void findBooksByTitle(String title){
        this.bookList.forEach(book->{
            if(book.getTitle().equals(title)){
                System.out.println(book);
            }
        });
    }
    public int getBooksNumber(){
        return this.bookList.size();
    }

    public String getName(){
        return this.name;
    }
    public List<Book> getBooks(){
        return this.bookList;
    }
    public String getBooksString(){
        String result="Books:\n";
        for(Book b:this.bookList){
            result+=b+"\n";
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "Category: "+this.name+
                "\n\t - Description: "+this.description+
                "\n\t - Books: \n";
        for(Book b:this.bookList){
            result+=b+"\n";
        }
        return result;
    }
}
