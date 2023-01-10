package TP07.ex3;

import TP07.ex2.AES;
import TP07.ex2.Sms;
import TP07.ex2.Type;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SMSListDecrypt {
    ArrayDeque<Sms> smsList;
    Scanner sc;
    public SMSListDecrypt(ArrayDeque<Sms> smsList){
        this.smsList= smsList;
        this.sc = new Scanner(System.in);
        this.displayMenu();
    }
    private void displayMenu(){
        System.out.printf("-----------------------------------------\n1. List all SMSes\n" +
                "2. View SMS detail\n" +
                "3. View readable SMSes\n" +
                "4. Remove SMSes by index\n"+
                "5. Exit program\n"+
                "Choice: ");
        int choice = sc.nextInt();
        System.out.print("-----------------------------------------\n");
        switch (choice) {
            case 1 -> this.listSMS();
            case 2 -> this.viewSMS();
            case 3 -> this.viewreadableSMS();
            case 4 -> this.removeByIndex();
            case 5 -> {
                sc.close();
                System.exit(1);
            }
        }
    }
    private void listSMS(){
        for (Sms sms: this.smsList){
            System.out.println(sms);
        }
        this.displayMenu();
    }
    private void viewSMS(){
        System.out.print("Please enter a sms index: ");
        int index =this.sc.nextInt();
        for (Sms sms: this.smsList){
            if(sms.getId()==index){
                System.out.print("Please enter the password to decrypt: ");
                AES.SECRET_KEY = sc.next();
                System.out.print(sms.toStringDecrypt());
                sms.setAsRead();
            }
        }
        this.displayMenu();

    }
    private void viewreadableSMS(){
        for(Sms sms : this.smsList){
            if(sms.isReadable()){
                System.out.println(sms);
            }
        }
        this.displayMenu();
    }
    private void removeByIndex(){
        System.out.print("Please enter a sms index: ");
        int index =this.sc.nextInt();
        this.smsList.removeIf(sms -> sms.getId() == index);
        this.displayMenu();
    }

    public static void main(String[] args) {
        ArrayDeque<Sms> array = new ArrayDeque();
        array.add(new Sms("hello","0902020301","0101010101", Type.TEXT,AES.encrypt("hello, how are you ?")));
        array.add(new Sms("hola","0902020302","0101010102", Type.MMS,AES.encrypt("hola, que tal ?")));
        array.add(new Sms("bonjour","0902020303","0101010103", Type.TEXT,AES.encrypt("bonjour, comment allez vous ?")));
        array.add(new Sms("hallo","0902020304","0101010104", Type.MMS,AES.encrypt("hallo, wie geht's ?")));
        array.add(new Sms("ciao","0902020305","0101010105", Type.TEXT,AES.encrypt("ciao, como stai ?")));
        SMSListDecrypt smsListDecrypt = new SMSListDecrypt(array);
    }

}
