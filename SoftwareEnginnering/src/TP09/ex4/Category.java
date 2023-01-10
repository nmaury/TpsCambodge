package TP09.ex3;

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
}
