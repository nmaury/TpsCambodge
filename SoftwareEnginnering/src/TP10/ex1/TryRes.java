package TP10.ex1;

import java.util.Scanner;

public class TryRes {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Input sentence: ");
            String str = sc.nextLine();
        } // will call sc.close() automatically
    }
}
