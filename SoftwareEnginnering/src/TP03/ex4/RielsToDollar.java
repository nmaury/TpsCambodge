package TP03.ex4;

import java.util.Scanner;

public class RielsToDollar {
    public static void main(String[] args){
        System.out.println("Program for converting money in Riels to Dollars.");
        System.out.println("Conversion rate is: 1 USD = 4000 RIELS");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input money in Riels: ");
        int riels = sc.nextInt();

        System.out.printf("%d RIELS = %.2f USD \n",riels,(float)riels/4000);
    }
}
