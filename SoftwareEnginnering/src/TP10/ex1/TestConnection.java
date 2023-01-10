package TP10.ex1;
import java.sql.*;
import java.util.Scanner;

public class TestConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the password: ");
        String passwd =sc.next();
        try(Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3308/i4db?user=root&password="+passwd)){
            Statement stmt = con.createStatement() ;
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            /*String createStudentTable = "Create table students " +
                    "(ID Integer not null, Name VARCHAR(32), " + "Marks Integer)";
            stmt.executeUpdate(createStudentTable);*/
            /*String insertStudent = "Insert into students values" +
            "(20226789,\"abc\",10)";
            stmt.executeUpdate(insertStudent);*/
            String queryStudent = "select * from students";
            ResultSet rs = stmt.executeQuery(queryStudent);
            while (rs.next()) {
                int ssn = rs.getInt("ID");
                String name = rs.getString("NAME");
                int marks = rs.getInt("MARKS");
                System.out.println("student : "+ssn+" ; "+name+" ; "+marks+" . ");
            }
        }
    }
}
