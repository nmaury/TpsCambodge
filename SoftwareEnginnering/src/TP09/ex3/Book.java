package TP09.ex3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Book {
    private String title;
    private String description;
    private CategoryBook categoryBook;
    private boolean isBorrow;
    private String [] authors;
    private Date publishedDate;
    private Scanner sc;
    private int isbn;
    public Book() {
        this.sc = new Scanner(System.in);
        this.setTitle();
        this.setIsbn();
        this.setDescription();
        this.setCategory();
        this.isBorrow = false;
        this.setAuthors();
        this.setPublishedDate();
    }

    public int getIsbn(){return isbn;}

    public void setIsbn(){
        System.out.print("Enter the book ISBN: ");
        while(!this.sc.hasNextInt()){
            this.sc.next();
            System.out.print("Enter the book ISBN: ");
        }
        this.isbn= this.sc.nextInt();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle() {
        System.out.print("Enter the book's title (finish with END): ");
        String result = "";
        int number =0;
        while(!this.sc.hasNext("END")){
            if(number>50){
                throw new StringTooLongException("The title exceed 50 words or you forgot the END -> please retry");
            }
            result+=this.sc.next()+" ";
            number++;
        }
        this.sc.next();
        this.title = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription() {
        System.out.print("Enter the book's description (finish with END): ");
        String result = "";
        int number =0;
        while(!this.sc.hasNext("END")){
            if(number>50){
                throw new StringTooLongException("The description exceed 50 words or you forgot END -> please retry...");
            }
            result+=this.sc.next()+" ";
            number++;
        }
        this.sc.next();
        this.description = result;
    }

    public CategoryBook getCategory() {
        return categoryBook;
    }

    public void setCategory() {
        System.out.print("Enter the book's category (math, Java , Football, Beauty, Fairytale or other): ");
        String test = this.sc.next().toUpperCase();
        switch (test){
            case "MATH":
                this.categoryBook = CategoryBook.MATH;
                break;
            case "JAVA":
                this.categoryBook = CategoryBook.JAVA;
                break;
            case "FOOTBALL":
                this.categoryBook = CategoryBook.FOOTBALL;
                break;
            case "BEAUTY":
                this.categoryBook = CategoryBook.BEAUTY;
                break;
            case "FAIRYTALE":
                this.categoryBook = CategoryBook.FAIRYTALE;
                break;
            case "OTHER":
                this.categoryBook = CategoryBook.OTHER;
                break;
            default:
                throw new CategoryException("Wrong input : this category doesn't exist !");
        }
        this.sc.nextLine();
    }

    public boolean IsBorrowed() {
        return isBorrow;
    }

    public void setBorrowed() {
        this.isBorrow = true;
    }
    public void setAvailable() {
        this.isBorrow = false;
    }


    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors() {
        System.out.print("Please enter the list of authors following the pattern (author1;author2;author3;END): ");
        String[] authors = this.sc.nextLine().split(";");
        if(Arrays.asList(authors).contains("END") || Arrays.asList(authors).contains("end")){
            this.authors = Arrays.stream(authors).filter(s -> !"END".equals(s.toUpperCase())).toArray(String[]::new);
        }else{
            throw new AuthorSyntaxException("Wrong input: you should finish with \"END\" ! ");
        }
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate() {
        DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Please enter the publication date of the book following the dd/MM/yyyy pattern: ");
        try {
            this.publishedDate = d.parse(this.sc.next());
        } catch (Exception e) {
            throw new PublishedDateException("Wrong input: please respect the pattern dd/MM/yyyy");
        }
    }

    @Override
    public String toString() {
        String result =  "Title: "+this.title+
                " ; ISBN: "+this.isbn+
                " ; Description: "+this.description+
                " ; Category: "+this.categoryBook +
                " ; Borrowed: "+this.isBorrow+
                " ; Published Date: "+this.publishedDate+
                " ; Authors: ";
        for(String s : this.authors){
            result+= s+" | ";
        }
        return result;
    }

    public static void main(String[] args) {
        Book b = new Book();
        System.out.println(b);
    }
}
