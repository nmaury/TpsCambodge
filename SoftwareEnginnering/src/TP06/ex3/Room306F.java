package TP06.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Room306F {
    List<PC> pcList;
    Scanner sc;
    public Room306F(List<PC> pcList){
        this.pcList = pcList;
        sc = new Scanner(System.in);
        this.displayMenu();
    }
    private void displayMenu(){
        System.out.printf("-----------------------------------------\n1. List all PCs\n" +
                "2. List all damaged PCs\n" +
                "3. List all good PCs\n" +
                "4. Mark a PC as damaged\n" +
                "5. Mark a PC as not damaged\n"+
                "6. Quit\n"+
                "Choice: ");
        int choice = sc.nextInt();
        System.out.print("-----------------------------------------\n");
        switch (choice){
            case 1 :
                this.listPcs();
                break;
            case 2 :
                this.listDamagedPcs();
                break;
            case 3 :
                this.listGoodPcs();
                break;
            case 4 :
                this.markDamagedPc();
                break;
            case 5 :
                this.markGoodPc();
                break;
            case 6 :
                sc.close();
                System.exit(1);
                break;
        }
    }
    private void listPcs(){
        for(PC pc:this.pcList){
            System.out.println(pc);
        }
        this.displayMenu();
    }
    private void listDamagedPcs(){
        for(PC pc:this.pcList){
            if(pc.status==Status.DAMAGED){
                System.out.println(pc);
            }
        }
        this.displayMenu();
    }
    private void listGoodPcs(){
        for(PC pc:this.pcList){
            if(pc.status==Status.GOOD){
                System.out.println(pc);
            }
        }
        this.displayMenu();
    }
    private void markDamagedPc(){
        System.out.print("enter a PC ID: ");
        int id = sc.nextInt();
        for(PC pc: this.pcList){
            if(pc.id==id){
                pc.setAsDamaged();
            }
        }
        this.displayMenu();
    }
    private void markGoodPc(){
        System.out.print("enter a PC ID: ");
        int id = sc.nextInt();
        for(PC pc: this.pcList){
            if(pc.id==id){
                pc.setAsGood();
            }
        }
        this.displayMenu();
    }

    public static void main(String[] args) {
        List<PC> list = new ArrayList<>();
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        list.add(new PC());
        Room306F room306F = new Room306F(list);
    }
}
