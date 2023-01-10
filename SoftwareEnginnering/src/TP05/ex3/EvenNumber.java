package TP05.ex3;

import TP05.ce1.RangeUtil;

import java.util.Scanner;

public class EvenNumber {
    private int lowLimit;
    public EvenNumber(int lowLimit) {
        this.lowLimit=lowLimit;
    }
    public void displayEvenNumbers(){
        System.out.println("Start: ");
        /*for(int i = this.lowLimit;i<=500;i++){
            if(i%2 == 0){
                System.out.println(i);
            }
        }*/
        int limit;
        if(this.lowLimit%2==0){
            limit = this.lowLimit;
        }else{
            limit = this.lowLimit+1;
        }
        RangeUtil rangeUtil = new RangeUtil(limit,500,2);
        System.out.println(rangeUtil);
        System.out.println("End...");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a low limit between 0 and 500: ");
        try{
            int lowLimit= sc.nextInt();
            if(lowLimit>0 && lowLimit<500){
                EvenNumber evenNumber = new EvenNumber(lowLimit);
                evenNumber.displayEvenNumbers();
            }
        }catch(Exception e){
            System.out.println("Input incorrect");
        }
    }
}
