package TP09.ex1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student {
    private String name;
    private Date dateOfBirth;
    private String telNumber;
    private String city;
    private String country;
    private Group group;
    private Scanner sc;
    public Student() {
        this.sc = new Scanner(System.in);
        this.setName();
        this.setDateOfBirth();
        this.setTelNumber();
        this.setCity();
        this.setCountry();
        this.setGroup();
    }
    public void setDateOfBirth(){
        try {
            System.out.print("Enter the date of bith of the student following the MM/DD/YYYY pattern: ");
            this.dateOfBirth = new Date(this.sc.next());
        }catch(Exception e){
            throw new BirthDateException("Invalid Date : format error !");
        }
    }
    public void setName(){
        System.out.print("Enter the name of the student: ");
        this.name = this.sc.next();
    }
    public void setCity(){
        System.out.print("Enter the city of the student: ");
        this.city = this.sc.next();
    }
    public void setCountry(){
        System.out.print("Enter the country of the student: ");
        this.country = this.sc.next().toUpperCase();
    }
    public void setTelNumber(){
        System.out.print("Enter the telephone number of the student: ");
        String number = this.sc.next();
        if(number.length()!=10){
            throw new TelNumberException("You have to enter 10 digits !");
        }else{
            this.telNumber = number;
        }
    }
    public void setGroup(){
        System.out.print("Enter the class group of the student (A,B,C or D): ");
        String group = this.sc.next().toUpperCase();
        switch (group){
            case "A":
                this.group=Group.A;
                break;
            case "B":
                this.group=Group.B;
                break;
            case "C":
                this.group=Group.C;
                break;
            case "D":
                this.group=Group.D;
                break;
            default:
                throw new GroupException("wrong input: you should choose between [A-D] !");
        }
    }
    @Override
    public String toString() {
        return "Name: "+this.name+" ; Birth date: "+this.dateOfBirth+" ; Telephone number: "+this.telNumber+" ; City: "+this.city+" ; Country: "+this.country+" ; Group: "+this.group;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Group getGroup() {
        return group;
    }

    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s);
    }
}
