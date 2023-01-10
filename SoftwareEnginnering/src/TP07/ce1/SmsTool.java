package TP07.ce1;

import TP07.ex2.Sms;
import TP07.ex2.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SmsTool {
    HashMap<String,String> passwordTable;
    Scanner sc;
    List<Sms> smsList;
    String username;
    public SmsTool(HashMap<String,String> map) {
        this.passwordTable = map;
        this.sc=new Scanner(System.in);
        this.smsList = new ArrayList<>();
        this.checkCredentials();
    }
    public void checkCredentials(){
        System.out.print("Please enter username: ");
        String username = this.sc.next();
        System.out.print("Password: ");
        String password = this.sc.next();
        if(!this.passwordTable.containsKey(username)){
            System.out.println("User not allowed !");
            System.exit(-1);
        }else{
            if(!this.passwordTable.get(username).equals(password)){
                System.out.print("Wrong Password !");
                System.exit(-2);
            }else{
                this.username=username;
                this.displayMenu();
                }
            }
        }
    private void displayMenu() {
        System.out.print("---------- Welcome to private SMS app -----------\n" +
                "1. List all SMS\n" +
                "2. View SMS Detail \n" +
                "3. Send SMS\n" +
                "4. Remove SMS by index\n" +
                "5. Quit\n" +
                "Choice: ");
        while (!this.sc.hasNextInt()) {
            System.out.print("This is not a number !\n" + "1. List all SMS\n" +
                    "2. View SMS Detail \n" +
                    "3. Send SMS\n" +
                    "4. Remove SMS by index\n" +
                    "5. Quit\n" +
                    "Choice: ");
        }
        int choice = this.sc.nextInt();
        switch (choice) {
            case 1 -> this.listAllSms();
            case 2 -> this.viewDetail();
            case 3 -> this.sendSms();
            case 4 -> this.removeById();
            case 5 -> {
                System.out.println("Quiting the program....");
                System.exit(0);
            }
        }
    }
    private void listAllSms(){
        for (Sms sms: this.smsList){
            System.out.println(sms);
        }
        this.displayMenu();
    }
    private void viewDetail(){
        System.out.print("Enter an sms id: ");
        while (!this.sc.hasNextInt()){
            System.out.print("Enter an sms id: ");
        }
        int id = this.sc.nextInt();
        for (Sms sms:this.smsList){
            if (sms.getId()==id){
                sms.setAsRead();
                System.out.println(sms);
            }
        }
        this.displayMenu();
    }
    private void sendSms(){
        System.out.print("To username: ");
        String receiver = this.sc.next();
        System.out.print("Title: ");
        String title = this.sc.next();
        System.out.println("Content (Enter END to end the content): ");
        String content ="";
        while(!this.sc.hasNext("END")){
            content+=this.sc.next();
        }
        this.sc.next();
        Sms sms = new Sms(title,this.username,receiver, Type.TEXT,content);
        this.smsList.add(sms);
        System.out.println(":) Your message has been sent to "+receiver+".");
        this.displayMenu();
    }
    private void removeById(){
        System.out.print("Enter an sms id: ");
        while (!this.sc.hasNextInt()){
            System.out.print("Enter an sms id: ");
        }
        int id = this.sc.nextInt();
        this.smsList.removeIf(sms -> sms.getId() == id);
        this.displayMenu();
    }

    public static void main(String[] args) {
        HashMap<String,String> passwordTable = new HashMap<>();
        passwordTable.put("nmaury","123456");
        SmsTool smsTool = new SmsTool(passwordTable);
    }
}
