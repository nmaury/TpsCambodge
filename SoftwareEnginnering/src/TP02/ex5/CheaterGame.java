package TP02.ex5;

import java.util.Scanner;

public class CheaterGame {
    public static void checkFloat(Scanner sc){
        while(!sc.hasNextFloat()){
            System.out.println("This is not a number !");
            sc.next();
            System.out.print("Please input a positive number: ");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Program for guessing your luckiness.");
        System.out.print("Please input a positive number: ");
        checkFloat(sc);
        float number = sc.nextFloat();
        while(number<0){
            System.out.println("This is not a positive number !");
            System.out.print("Please input a positive number: ");
            checkFloat(sc);
            number =sc.nextFloat();
        }
        sc.close();
        float res_number = number+1;
        System.out.println("I got "+res_number+". I am luckier.");
    }
}
