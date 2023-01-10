package TP06.ex2;

public class Student {
    int studentID;
    String firstName;
    String lastName;
    static int studentNumber=0;
    String group;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID=++studentNumber;
        this.group=null;
    }

    @Override
    public String toString() {
        return this.studentID+" - "+this.firstName+" "+this.lastName+" - "+this.group;
    }
}
