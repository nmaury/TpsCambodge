package TP04.ex3;

import java.util.Scanner;

public class ReversingNumber {
    private String value;
    public ReversingNumber(String value) {
        this.value=value;
    }
    public boolean isValid(){
        return this.value.length()==4;
    }
    public int getReverse(){
        char digitOne = this.value.charAt(0);
        char digitTwo = this.value.charAt(1);
        char digitThree = this.value.charAt(2);
        char digitFour = this.value.charAt(3);
        String result = String.valueOf(digitFour)+String.valueOf(digitThree)+String.valueOf(digitTwo)+String.valueOf(digitOne);
        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        System.out.println("Program for reversing a 4 digits number.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input 4 digits number: ");
        String input = sc.next();
        ReversingNumber rn= new ReversingNumber(input);
        if(rn.isValid()){
            System.out.println("After reverse: "+rn.getReverse());
        }else{
            System.out.println("Error: invalid number, please input only 4 digits number.");
        }

    }
}
