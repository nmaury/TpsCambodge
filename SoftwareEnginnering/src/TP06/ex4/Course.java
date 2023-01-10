package TP06.ex4;

public class Course {
    int id;
    String name;
    String teacher;
    String roomNumber;
    static int numberCourses = 0;
    public Course(String name,String teacher, String roomNumber){
        this.name = name;
        this.roomNumber=roomNumber;
        this.teacher = teacher;
        this.id=++Course.numberCourses;
    }

    @Override
    public String toString() {
        return this.id+" - "+this.name.toUpperCase()+" - teacher: "+this.teacher+" - room: "+this.roomNumber;
    }
}
