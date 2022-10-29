package TP02.ex3;

import java.util.Scanner;
public class Equation {
    public static void checkFloat(Scanner sc,String s){
        while(!sc.hasNextFloat()){
            System.out.println("This is not a number !");
            sc.next();
            System.out.print("Please input "+s+" : ");
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Program for calculating the equation 1/x = 1/y + 1/z");
        System.out.print("Please input y : ");
        checkFloat(sc,"y");
        float y = sc.nextFloat();
        while(y==0){
            System.out.println("Divide by zero is not allowed !");
            System.out.print("Please input y : ");
            checkFloat(sc,"y");
            y= sc.nextFloat();
        }
        System.out.print("Please input z : ");
        checkFloat(sc,"z");
        float z = sc.nextFloat();
        while(z==0){
            System.out.println("Divide by zero is not allowed !");
            System.out.print("Please input z : ");
            checkFloat(sc,"z");
            z= sc.nextFloat();
        }
        sc.close();
        float x = 1/(1/y + 1/z);
        System.out.println("Result x = "+x);
    }
}
