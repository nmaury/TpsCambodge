package TP04.ex5;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class MaxNumber {

    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (numberList.size()!=8){
            System.out.print("Please enter a new number: ");
            numberList.add(sc.nextInt());
        }
        System.out.println("The maximum number among "+numberList.toString()+" is: "+ Collections.max(numberList));
    }
}
