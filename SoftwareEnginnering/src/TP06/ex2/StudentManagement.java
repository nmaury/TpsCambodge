package TP06.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentManagement {
    List<Student> studentList;
    Scanner sc;
    public StudentManagement() {
        this.studentList = new ArrayList<>();
        sc = new Scanner(System.in);
        this.displayMenu();
    }
    private void displayMenu(){
        System.out.printf("-----------------------------------------\n1. Add new student\n" +
                "2. List students\n" +
                "3. Remove student by name\n" +
                "4. Update student information by id\n" +
                "5. Quit\n"+
                "Choice: ");
        int choice = sc.nextInt();
        System.out.print("-----------------------------------------\n");
        //sc.close();
        switch (choice){
            case 1 :
                this.addStudent();
                break;
            case 2 :
                this.printList();
                break;
            case 3 :
                this.removeByName();
                break;
            case 4 :
                this.updateInfoById();
                break;
            case 5 :
                sc.close();
                System.exit(1);
                break;
        }
    }
    private void addStudent(){
        System.out.print("Please enter a firstname: ");
        String firstName = sc.next();
        System.out.print("\nPlease enter a lastname: ");
        String lastName = sc.next();
        Student student = new Student(firstName,lastName);
        this.studentList.add(student);
        System.out.println(firstName+" "+lastName+" added !");
        this.displayMenu();
    }
    private void printList(){
        for (Student s: this.studentList) {
            System.out.println(s);
        }
        this.displayMenu();
        }
    private void removeByName(){
        System.out.print("Please enter a lastname: ");
        String lastNameToRm = sc.next();
        int length = this.studentList.size();
        this.studentList.removeIf(s ->s.lastName.equals(lastNameToRm));
        if(this.studentList.size()!=length){
            System.out.println("A student has been removed");
        }
        this.displayMenu();
    }
    private void updateInfoById(){
        System.out.print("Please enter a ID: ");
        int id = sc.nextInt();
        System.out.print("Please enter a group: ");
        String group = sc.next();
        for(Student s:this.studentList){
            if(s.studentID==id){
                s.group=group;
                System.out.println("Info modified !");
            }
        }
        this.displayMenu();
    }

    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
    }
}
