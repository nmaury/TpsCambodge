package TP09.ex5;

import TP09.ex1.Student;
import TP09.ex3.Book;
import TP09.ex4.Category;

import java.util.*;

public class Library {
    private List<Category> categoryList;
    private List<Book> bookList;
    private Map<Student,Book> studentBookMap;
    public Library() {
        this.categoryList=new ArrayList<>();
        this.bookList=new ArrayList<>();
        this.studentBookMap = new HashMap<>();
    }

    public void listAllCategories(){
        for(Category c : this.categoryList){
            System.out.println(c.getName());
        }
    }
    public void listBooksByCategories(){
        for(Category c : this.categoryList){
            System.out.println(c.getName());
            System.out.println(c.getBooksString());
        }
    }
    public void listBooksByYears(){
        List<Date> years = this.computeYears();
        for(Date d:years){
            System.out.println("Date: "+d);
            for(Book b:this.bookList){
                if(b.getPublishedDate().equals(d)){
                    System.out.println(b);
                }
            }
        }
    }
    private List<Date> computeYears(){
        List<Date> years = new ArrayList<>();
        for(Book b : this.bookList){
            if(!years.contains(b.getPublishedDate())){
                years.add(b.getPublishedDate());
            }
        }
        return years;
    }
    public void listAvailableBooks(){
        for(Book b:this.bookList){
            if(!b.IsBorrowed()){
                System.out.println(b);
            }
        }
    }
    public void addNewBooks(Category c,Book b,int number){
        int temp = number;
        while(temp>0){
            this.bookList.add(b);
            temp--;
        }
        while(number>0){
            for(Category category:this.categoryList){
                if(category.getName().equals(c.getName())){
                    category.addBook(b);
                }
            }
            number--;
        }
    }
    public void decreaseBookByIsbn(int isbn){
        for(Category c:this.categoryList){
            for(Book b:c.getBooks()){
                if(b.getIsbn()==isbn){
                    c.getBooks().remove(b);
                    break;
                }
            }
        }
        for(Book b:this.bookList){
            if(b.getIsbn()==isbn){
                this.bookList.remove(b);
                break;
            }
        }
    }
    public void removeBookByIsbn(int isbn){
        for(Category c:this.categoryList){
            for(Book b:c.getBooks()){
                if(b.getIsbn()==isbn){
                    c.getBooks().remove(b);
                }
            }
        }
        for(Book b:this.bookList){
            if(b.getIsbn()==isbn){
                this.bookList.remove(b);
            }
        }
    }
    public void addNewCopies(Category c,Book b,int number){
        while(number>0){
            for(Category category:this.categoryList){
                if(category.getName().equals(c.getName())){
                    category.addBook(b);
                }
            }
            this.bookList.add(b);
            number--;
        }
    }
    public void markBookNotAvailable(int isbn){
        for(Category c:this.categoryList){
            for(Book b : c.getBooks()){
                if(b.getIsbn()==isbn){
                    b.setBorrowed();
                    break;
                }
            }
        }
        for(Book b:this.bookList){
            if(b.getIsbn()==isbn){
                b.setBorrowed();
                break;
            }
        }
    }
    public void borrow(Student s,Book b,int number){
        if(number<=5) {
            while (number > 0) {
                this.studentBookMap.put(s, b);
                this.markBookNotAvailable(b.getIsbn());
                number--;
            }
        }
    }
    public void listStudentsThatBorrow(){
        for(Student s: this.studentBookMap.keySet()){
            System.out.println(s);
        }
    }
    public void returnBook(Student s,Book b){
        for(Student student : this.studentBookMap.keySet()){
            if(student.getName().equals(s.getName())&&this.studentBookMap.get(student).getIsbn()==b.getIsbn()){
                this.studentBookMap.remove(s);
                break;
            }
        }
        for(Category c:this.categoryList){
            for(Book book:c.getBooks()){
                if(book.getIsbn()==b.getIsbn()){
                    book.setAvailable();
                    break;
                }
            }
        }
        for(Book book:this.bookList){
            if(book.getIsbn()==b.getIsbn()){
                book.setAvailable();
                break;
            }
        }
    }
}
