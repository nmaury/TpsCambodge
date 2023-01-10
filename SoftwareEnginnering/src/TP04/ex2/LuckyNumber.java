package TP04.ex2;

import java.util.Scanner;

public class LuckyNumber {
    private String luckyNumber;
    public LuckyNumber(String luckyNumber) {
        this.luckyNumber=luckyNumber;
    }
    public boolean isLucky(){
        int firstNumber = Integer.parseInt(String.valueOf(this.luckyNumber.charAt(0)))+Integer.parseInt(String.valueOf(this.luckyNumber.charAt(1)))+Integer.parseInt(String.valueOf(this.luckyNumber.charAt(2)));
        int lastNumber = Integer.parseInt(String.valueOf(this.luckyNumber.charAt(3)))+Integer.parseInt(String.valueOf(this.luckyNumber.charAt(4)))+Integer.parseInt(String.valueOf(this.luckyNumber.charAt(5)));
        return firstNumber==lastNumber;
    }
    public boolean isValid(){
        return this.luckyNumber.length()==6;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Program for testing for lucky number.");
        System.out.print("Please input 6 digits number: ");
        String input = sc.nextLine();
        LuckyNumber luckyNumber = new LuckyNumber(input);
        if(luckyNumber.isValid()){
            if(luckyNumber.isLucky()){
                System.out.println(input+" is lucky number.");
            }else{
                System.out.println(input+" is not lucky number.");
            }
        }else {
            System.out.println("Invalid input number, please input only 6 digits number.");
        }
    }
}
