package TP06.ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Courses {
    List<Course> courseList;
    Scanner sc;
    public Courses(){
        this.courseList = new ArrayList<>();
        this.sc = new Scanner(System.in);
        this.displayMenu();
    }
    private void displayMenu(){
        System.out.printf("-----------------------------------------\n1. List all courses\n" +
                "2. Find courses by name\n" +
                "3. Add new course\n" +
                "4. Quit\n"+
                "Choice: ");
        int choice = sc.nextInt();
        System.out.print("-----------------------------------------\n");
        switch (choice){
            case 1 :
                this.listCourses();
                break;
            case 2 :
                this.findByName();
                break;
            case 3 :
                this.addNewCourse();
                break;
            case 4 :
                sc.close();
                System.exit(1);
                break;
        }
    }
    private void listCourses(){
        for(Course c: this.courseList){
            System.out.println(c);
        }
        this.displayMenu();
    }
    private void findByName(){
        System.out.print("Please enter a course name: ");
        String course = sc.next();
        boolean find =false;
        for(Course c: this.courseList){
            if(c.name.equals(course)){
                find=true;
                System.out.println(c);
            }
        }
        if(!find){
            System.out.println("Not found !");
        }
        this.displayMenu();
    }
    private void addNewCourse(){
        System.out.print("Please enter a course name: ");
        String course = sc.next();
        System.out.print("Please enter a course teacher: ");
        String teacher = sc.next();
        System.out.print("Please enter a course room: ");
        String room = sc.next();
        this.courseList.add(new Course(course,teacher,room));
        this.displayMenu();
    }

    public static void main(String[] args) {
        Courses courses = new Courses();
    }
}
