package TP05.ex2;

import TP05.ce1.RangeUtil;

public class OddNumber {
    public OddNumber() {
    }
    public static void displayNumbers(){
        System.out.println("Start: ");
        /*for (int i=1;i<=500;i+=2){
            System.out.println(i);
        }*/
        RangeUtil rangeUtil = new RangeUtil(1,500,2);
        System.out.println(rangeUtil);
        System.out.println("End...");
    }
    public static void main(String[] args) {
        OddNumber.displayNumbers();
    }
}
