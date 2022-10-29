package TP03.ex2;

import java.util.Scanner;

public class TimeToSecond {
    public static void main(String[] args){
        System.out.println("Program to converting time to seconds.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input hours: ");
        int hours = sc.nextInt();
        System.out.print("Please input minutes: ");
        int minutes = sc.nextInt();
        System.out.print("Please input seconds: ");
        int seconds = sc.nextInt();
        System.out.println("Number of seconds = "+hours+"x3600 + "+minutes+"x60 + "+seconds+" = "+(hours*3600+minutes*60+seconds));
    }
}
