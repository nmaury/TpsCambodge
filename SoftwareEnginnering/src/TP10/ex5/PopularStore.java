package TP10.ex5;

import TP10.ex3.Customer;
import TP10.ex3.Status;
import TP10.ex4.CustomerQueue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PopularStore {
    private static CustomerQueue customerQueue;
    private static List<Customer> customerServed;
    public PopularStore() {
        PopularStore.customerServed = new ArrayList<>();
        PopularStore.customerQueue=new CustomerQueue();
        PopularStore.customerQueue.addNewCustomer();
        PopularStore.customerQueue.addNewCustomer();
        PopularStore.customerQueue.addNewCustomer();
        PopularStore.customerQueue.addNewCustomer();
        PopularStore.customerQueue.addNewCustomer();
    }

    public static void serveCustomer() throws SQLException, ClassNotFoundException {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        Date dateNow = Date.from(Instant.now());
        System.out.println("Start serving time: "+dateFormat.format(dateNow));
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you like ?");
        String custThings =sc.nextLine();
        //System.out.println(custThings);
        System.out.print("Amount to pay ($): ");
        while(!sc.hasNextFloat()){
            sc.next();
            System.out.print("Amount to pay ($): ");
        }
        float moneyPaid = sc.nextFloat();
        //System.out.println(moneyPaid);
        System.out.print("Pay by (0: cash, 1: credit card): ");
        int choice = sc.nextInt();
        //System.out.println(choice);
        switch (choice){
            case 0 :
                System.out.print("In case cash, please enter the ammount given: ");
                while(!sc.hasNextFloat()){
                    sc.next();
                    System.out.print("Amount to pay ($): ");
                }
                float moneyCusto = sc.nextFloat();
                System.out.println("You have to give him back: "+(moneyCusto-moneyPaid)+"$");
                break;
            case 1 :
                System.out.println("In case credit card, please input credit card number:");
                sc.nextLine();
                String creditCardNumbers = sc.nextLine();
                //System.out.println(creditCardNumbers);
                System.out.print("and pass code: ");
                while(!sc.hasNextInt()){
                    sc.next();
                    System.out.print("and pass code: ");
                }
                int passcode = sc.nextInt();
                //System.out.println(passcode);
        }
        double serviceDurationTime = (Math.random()*9)+1;
        //System.out.println(serviceDurationTime);
        int min = Math.toIntExact((long) serviceDurationTime);
        //System.out.println(min);
        int sec = Math.toIntExact((long)(serviceDurationTime*60)-min*60);
        //System.out.println(sec);
        String serviceDuration = "00:"+min+":"+sec;
        //System.out.println(serviceDuration);
        double endServiceTime = dateNow.getTime()+(serviceDurationTime*60*1000);
        Date endService = new Date((long) endServiceTime);
        //System.out.println(dateFormat.format(dateNow));
        //System.out.println(dateFormat.format(endService));
        PopularStore.printReceipt(dateNow,endService,custThings,moneyPaid,serviceDuration);
    }
    public static void printReceipt(Date startService,Date endService,String customerThings, float moneyPaid, String serviceDuration) throws SQLException, ClassNotFoundException {
        Customer c = PopularStore.customerQueue.removeCustomer();
        int id = c.getId();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        String data = "("+id+",\""+dateFormat.format(startService)+"\",\""+dateFormat.format(endService)+"\",\""+customerThings+"\","+moneyPaid+",\""+serviceDuration+"\")";
        System.out.println(data);
        PopularStore.insertStoreTable(data,"************");
        c.setStatus(Status.WAITING_FOR_FOOD);
        PopularStore.customerQueue.addNewCustomer(c);
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        System.out.println("Receipt:\n" +
                "---------------------------------------\n" +
                "Customer No.: "+id+"\n" +
                customerThings+"="+ moneyPaid+"$ \n" +
                "(In credit card **** **** **** 1254)\n" +
                "------------ Thanks you!!! ------------\n" +
                "Issue date: "+dateFormat1.format(endService)+"\n" +
                "---------------------------------------\n" +
                "End serving time: "+dateFormat.format(endService)+"\n" +
                "Serving duration: "+serviceDuration);
    }
    static void insertStoreTable(String data,String passwd) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3308/i4db?user=root&password=" + passwd)) {
            Statement stmt = con.createStatement();
            String insertStudent = "Insert into store values" +
                    data;
            stmt.executeUpdate(insertStudent);
        }
    }
    public void displayCustomerList(){
        System.out.println(PopularStore.customerQueue);
    }
    public void listAllServedcustomers(){
        for(Customer c:PopularStore.customerServed){
            System.out.println(c);
        }
    }
    public static void foodArrived(){
        Customer c =customerQueue.serveCustomer();
        PopularStore.customerServed.add(c);
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PopularStore popularStore = new PopularStore();
        PopularStore.serveCustomer();
        popularStore.displayCustomerList();
        PopularStore.serveCustomer();
        PopularStore.foodArrived();
        popularStore.displayCustomerList();
        popularStore.listAllServedcustomers();
    }
}
