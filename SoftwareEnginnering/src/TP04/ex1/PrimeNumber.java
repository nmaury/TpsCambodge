package TP04.ex1;

import java.util.Scanner;

public class PrimeNumber {
    private int value;
    private int divideNumber;
    public PrimeNumber(int number){
        this.value=number;
        this.divideNumber=1;
    }
    public boolean isPrime(){
        if(this.value<2){
            return false;
        }else {
            for (int i = 2; i < this.value; i++) {
                if (this.value % i == 0) {
                    this.divideNumber=i;
                    return false;
                }
            }
            return true;
        }
    }

    public int getDivideNumber() {
        return divideNumber;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number to check whether it is prime number: ");
        int inputNumber = sc.nextInt();
        PrimeNumber p = new PrimeNumber(inputNumber);
        if(p.isPrime()){
            System.out.println(inputNumber+" is prime number.");
        }else{
            System.out.println(inputNumber+" is not prime number, because it is divisible to "+p.getDivideNumber()+".");
        }
    }
}
