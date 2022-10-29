package TP02.ex4;

import java.util.Scanner;

public class HundredsCounter {
    public static void checkFloat(Scanner sc){
        while(!sc.hasNextFloat()){
            System.out.println("This is not a number !");
            sc.next();
            System.out.print("Please input a positive number: ");
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Program for counting the number of hundreds.");
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
        System.out.println("There are "+(int) number/100+" hundred in number "+number);
    }
}
