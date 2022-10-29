package TP02.ex2;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Program for calculating perimeter and surface of a Rectangle.");
        System.out.print("Please input width (in meter): ");
        while(!sc.hasNextFloat()){
            System.out.println("This is not a number !");
            sc.next();
            System.out.print("Please input width (in meter): ");
        }
        float width = sc.nextFloat();
        System.out.print("Please input height (in meter): ");
        while(!sc.hasNextFloat()){
            System.out.println("This is not a number !");
            sc.next();
            System.out.print("Please input height (in meter): ");
        }
        float height = sc.nextFloat();
        sc.close();
        float perimeter = (width+height)*2;
        float surface = width*height;
        System.out.println("Perimeter = ("+width+" + "+height+") x 2 = "+perimeter+" m");
        System.out.println("Surface = "+width+" x "+height+" = "+surface+" m^2");
    }
}
