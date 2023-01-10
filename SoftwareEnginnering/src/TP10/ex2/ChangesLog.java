package TP10.ex2;

import TP10.ex1.DateTable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ChangesLog {

    @Override
    public String toString(){
        String s="";
        try {
            s = DateTable.selectLast5Elements("*************");
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return s;
    }
    public static void listAllChanges() throws SQLException, ClassNotFoundException {
        DateTable.selectDateTable("*************");
    }
    public static void listChangesByDate() throws SQLException, ClassNotFoundException {
        DateTable.selectByDateDateTable("*************");
    }
    public static void listChangesByWeek(){
        //not understood
    }
    public static void listChangesByDateRange() throws SQLException, ClassNotFoundException {
        DateTable.selectByDateRangeDateTable("*************");
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*ChangesLog changesLog = new ChangesLog();
        System.out.println(changesLog);*/
        //ChangesLog.listAllChanges();
        //ChangesLog.listChangesByDate();
        ChangesLog.listChangesByDateRange();
    }
}
