package TP10.ex1;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class DateTable {
    static void createDateTable() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the password: ");
        String passwd = sc.next();
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3308/i4db?user=root&password=" + passwd)) {
            Statement stmt = con.createStatement();
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            String createDateTable = "Create table dateUtil " +
                    "(ID Integer not null, date_start DATE, date_end DATE, n_days Integer, operation_type VARCHAR(32), changed_date DATE)";
            stmt.executeUpdate(createDateTable);
        }
    }
    static void createStoreTable() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the password: ");
        String passwd = sc.next();
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3308/i4db?user=root&password=" + passwd)) {
            Statement stmt = con.createStatement();
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            String createDateTable = "Create table Store " +
                    "(ID Integer not null, service_start DATE, service_end DATE, things_ordered VARCHAR(32), money_paid Float, service_duration DATE)";
            stmt.executeUpdate(createDateTable);
        }
    }

    static void insertDateTable(String data,String passwd) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3308/i4db?user=root&password=" + passwd)) {
            Statement stmt = con.createStatement();
            String insertStudent = "Insert into dateUtil values" +
                    data;
            stmt.executeUpdate(insertStudent);
        }
    }
    public static void selectDateTable(String passwd) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3308/i4db?user=root&password=" + passwd)) {
            Statement stmt = con.createStatement();
            String queryDate = "select * from dateutil";
            ResultSet rs = stmt.executeQuery(queryDate);
            while (rs.next()) {
                int ssn = rs.getInt("ID");
                Date dateStart= rs.getDate("date_start");
                Date dateEnd= rs.getDate("date_end");
                int daysNumber = rs.getInt("n_days");
                String operationType = rs.getString("operation_type");
                Date changedDate = rs.getDate("changed_date");
                System.out.println("date : "+ssn+" ; "+dateStart+" ; "+dateEnd+" ; "+daysNumber+" ; "+operationType+" ; "+changedDate+" . ");
            }
        }
    }
    public static ResultSet selectAllDateTable(String passwd) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3308/i4db?user=root&password=" + passwd)) {
            Statement stmt = con.createStatement();
            String queryDate = "select * from dateutil";
            return stmt.executeQuery(queryDate);
        }
    }
    public static String selectLast5Elements(String passwd) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3308/i4db?user=root&password=" + passwd)) {
            Statement stmt = con.createStatement();
            String queryDate = "select * from dateutil";
            ResultSet rs = stmt.executeQuery(queryDate);
            int numberElements = DateTable.getNumbersElementsDateTable(passwd);
            if(numberElements>5){
                while(numberElements!=5){
                    rs.next();
                    numberElements--;
                }
            }
            String res="";
            while (rs.next()) {
                int ssn = rs.getInt("ID");
                Date dateStart= rs.getDate("date_start");
                Date dateEnd= rs.getDate("date_end");
                int daysNumber = rs.getInt("n_days");
                String operationType = rs.getString("operation_type");
                Date changedDate = rs.getDate("changed_date");
                res+="date : "+ssn+" ; "+dateStart+" ; "+dateEnd+" ; "+daysNumber+" ; "+operationType+" ; "+changedDate+" . \n";
                //System.out.println("date : "+ssn+" ; "+dateStart+" ; "+dateEnd+" ; "+daysNumber+" ; "+operationType+" ; "+changedDate+" . ");
            }
            return res;
        }
    }
    public static void selectByDateDateTable(String passwd) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3308/i4db?user=root&password=" + passwd)) {
            Statement stmt = con.createStatement();
            String queryDate = "select * from dateutil group by changed_date,date_start,date_end,n_days,operation_type,ID order by changed_date asc;";
            ResultSet rs = stmt.executeQuery(queryDate);
            Date currentDate =  new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01");
            while (rs.next()) {
                Date changedDate = rs.getDate("changed_date");
                if(!changedDate.equals(currentDate)) {
                    System.out.println("date : " + changedDate);
                    currentDate=changedDate;
                }
                int ssn = rs.getInt("ID");
                Date dateStart= rs.getDate("date_start");
                Date dateEnd= rs.getDate("date_end");
                int daysNumber = rs.getInt("n_days");
                String operationType = rs.getString("operation_type");
                System.out.println("\t"+ssn+" ; "+dateStart+" ; "+dateEnd+" ; "+daysNumber+" ; "+operationType+" . ");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static void selectByDateRangeDateTable(String passwd) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3308/i4db?user=root&password=" + passwd)) {
            Statement stmt = con.createStatement();
            String queryDate = "select * from dateutil group by n_days,date_start,date_end,changed_date,operation_type,ID order by n_days asc;";
            ResultSet rs = stmt.executeQuery(queryDate);
            while (rs.next()) {
                int ssn = rs.getInt("ID");
                Date dateStart= rs.getDate("date_start");
                Date dateEnd= rs.getDate("date_end");
                int daysNumber = rs.getInt("n_days");
                String operationType = rs.getString("operation_type");
                Date changedDate = rs.getDate("changed_date");
                System.out.println("date : "+ssn+" ; "+dateStart+" ; "+dateEnd+" ; "+daysNumber+" ; "+operationType+" ; "+changedDate+" . ");
            }
        }
    }
    public static int getNumbersElementsDateTable(String passwd) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3308/i4db?user=root&password=" + passwd)) {
            Statement stmt = con.createStatement();
            String queryDate = "select Count(*) from dateutil";
            ResultSet rs = stmt.executeQuery(queryDate);
            /*while(rs.next()){
                System.out.println(rs.getInt(1));
            }*/
            int res=0;
            if(rs.next()){
                res=rs.getInt(1);
            }
            return res;
        }
    }

    static void dropDateTable() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the password: ");
        String passwd = sc.next();
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3308/i4db?user=root&password=" + passwd)) {
            Statement stmt = con.createStatement();
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            String queryDate = "drop table date";
        }
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        DateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
        Date dateStart =dateFormat.parse("2022-01-01");
        Date dateEnd = dateFormat.parse("2022-01-28");
        Date dateNow = Date.from(Instant.now());
        String data = "(1,\""+dateFormat.format(dateStart)+"\",\""+dateFormat.format(dateEnd)+"\",28,\"Substraction\",\""+dateFormat.format(dateNow)+"\")";
        //System.out.println(data);
        //DateTable.insertDateTable(data,"*************");
        //DateTable.createDateTable();
        DateTable.createStoreTable();
    }
}
