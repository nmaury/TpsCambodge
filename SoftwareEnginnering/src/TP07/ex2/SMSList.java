package TP07.ex2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SMSList {
    ArrayDeque<Sms> smsList;
    Scanner sc;
    AES aes;
    static int max_characters_per_sms = 160;
    public SMSList(){
        this.smsList = new ArrayDeque<>();
        this.sc = new Scanner(System.in);
        this.aes = new AES();
        this.displayMenu();
    }
    private void displayMenu(){
        System.out.printf("-----------------------------------------\n1. Send new SMS with Encrypted content using password method\n" +
                "2. View SMS detail\n" +
                "3. List SMSes\n" +
                "4. Remove SMSes by index\n"+
                "5. Exit program\n"+
                "Choice: ");
        int choice = sc.nextInt();
        System.out.print("-----------------------------------------\n");
        switch (choice) {
            case 1 -> this.sendSMS();
            case 2 -> this.viewSMS();
            case 3 -> this.listSMS();
            case 4 -> this.removeByIndex();
            case 5 -> {
                sc.close();
                System.exit(1);
            }
        }
    }

    private void add(Sms sms){
        this.smsList.add(sms);
        this.displayMenu();
    }
    private void add(String msg){
        this.smsList.add(new Sms(msg));
        this.displayMenu();
    }
    private void add(String msg, String title){
        this.smsList.add(new Sms(msg,title));
        this.displayMenu();
    }
    private void sendSMS(){
        System.out.println("Please enter the content of the sms (required): ");
        this.sc.nextLine();
        String msg = this.sc.nextLine();
        //System.out.println(msg);
        System.out.println("Please enter the title of the sms (optional): ");
        String title = this.sc.nextLine();
        //System.out.println(title);
        System.out.println("Please enter the type of the sms (text or mms) (optional): ");
        String type = this.sc.nextLine();
        //System.out.println(type);
        if(!type.equalsIgnoreCase("text") && !type.equalsIgnoreCase("mms") && !type.equals("")){
            System.out.println("Wrong Type !");
            System.exit(-1);
        }else {
            System.out.println("Please enter your phone number (10 digits only) (optional): ");
            String sPhoneNumber = this.sc.nextLine();
            //System.out.println(sPhoneNumber);
            if(sPhoneNumber.length()!=10 && sPhoneNumber.length()!=0){
                System.out.println("Wrong number !");
                System.exit(-2);
            }else {
                System.out.println("Please enter the receiver phone number (10 digits only) (optional): ");
                String rPhoneNumber = this.sc.nextLine();
                //System.out.println(rPhoneNumber);
                if (rPhoneNumber.length()!=10 && rPhoneNumber.length()!=0){
                    System.out.println("Wrong number !");
                    System.exit(-3);
                }else{
                    boolean isRPhoneNumber = !rPhoneNumber.isEmpty();
                    boolean isSPhoneNumber = !sPhoneNumber.isEmpty();
                    boolean isType = !type.isEmpty();

                    String newRPhoneNumber;
                    String newSPhoneNumber;
                    Type newType;
                    if(isRPhoneNumber){
                        newRPhoneNumber = rPhoneNumber;
                    }else{
                        newRPhoneNumber = "not set";
                    }
                    if(isSPhoneNumber){
                        newSPhoneNumber = sPhoneNumber;
                    }else{
                        newSPhoneNumber = "not set";
                    }

                    if(isType){
                        if(type.equalsIgnoreCase("text")){
                            newType = Type.TEXT;
                        }else if(type.equalsIgnoreCase("mms")){
                            newType = Type.MMS;
                        }else{
                            newType = Type.TEXT;
                        }
                    }else{
                        newType = Type.TEXT;
                    }
                    String newContent="";
                    if(msg.length()<=SMSList.max_characters_per_sms) {
                        newContent = AES.encrypt(msg);
                    }else{
                        System.out.println("Sms too long !");
                        System.exit(-4);
                    }
                    String newTitle;
                    if(title.isEmpty()){
                        newTitle = "new message";
                    }else{
                        newTitle=title;
                    }
                    if(isRPhoneNumber || isSPhoneNumber){
                        this.add(new Sms(newTitle,newSPhoneNumber,newRPhoneNumber,newType,newContent));
                    }else {
                        if (title.isEmpty()) {
                            this.add(newContent);
                        } else {
                            this.add(newContent, title);
                        }
                    }
                }
            }
        }
    }
    private void viewSMS(){
        System.out.print("Please enter a sms index: ");
        int index =this.sc.nextInt();
        for (Sms sms: this.smsList){
            if(sms.id==index){
                sms.setAsRead();
                System.out.println(sms);
            }
        }
        this.displayMenu();
    }
    private void listSMS(){
        for (Sms sms: this.smsList){
            System.out.println(sms);
        }
        this.displayMenu();
    }
    private void removeByIndex(){
        System.out.print("Please enter a sms index: ");
        int index =this.sc.nextInt();
        this.smsList.removeIf(sms -> sms.id==index);
        this.displayMenu();
    }

    public static void main(String[] args) {
        SMSList smsList = new SMSList();
    }
}
