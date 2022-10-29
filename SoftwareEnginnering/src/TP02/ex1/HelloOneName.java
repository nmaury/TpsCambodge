package TP02.ex1;

import java.util.Scanner;
public class HelloOneName {
    public static void main(String[] args){
        System.out.print("Input your name: ");
        Scanner sc = new Scanner(System.in);
        String e = sc.nextLine();
        sc.close();
        System.out.println("Hello "+e+"!");
    }
}
