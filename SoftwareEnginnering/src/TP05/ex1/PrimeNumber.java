package TP05.ex1;

import java.util.Scanner;

public class PrimeNumber {
    private int value;
    public PrimeNumber(int value){
        this.value=value;
    }
    public static boolean isPrime(int number){
        if(number<2){
            return false;
        }else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    public void printAllPrimeNumbers() {
        if (this.value < 2) {
            System.out.println("Number too low...");
        }else{
            for (int i = 2; i <= this.value; i++) {
                if (PrimeNumber.isPrime(i)) {
                    System.out.print(i + " ");
                }
            }
            System.out.print("is prime number.\n");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number to list prime numbers from 2 to it: ");
        try {
            int number = sc.nextInt();
            sc.close();
            PrimeNumber p = new PrimeNumber(number);
            p.printAllPrimeNumbers();
        }catch (Exception e){
            System.out.printf("The input is not a positif number");
        }

    }
}
