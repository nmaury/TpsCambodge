package TP04.ex7;

import java.util.Scanner;

public class LeapYear {
    private int year;
    public LeapYear(int year) {
        this.year=year;
    }
    public boolean isLeap(){
        if(this.year%4==0){
            if(this.year%100==0){
                if(this.year%400==0){
                    return true;
                }else{
                    return false;
                }
            }else{
             return true;
            }
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a year: ");
        int year = sc.nextInt();
        if(year<1){
            System.out.println("ERROR: Number not accepted !");
        }else{
            LeapYear l = new LeapYear(year);
            if(l.isLeap()){
                System.out.println("The year "+year+" is a leap year !");
            }else{
                System.out.println("The year "+year+" is not a leap year !");
            }
        }
    }
}
