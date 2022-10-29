package TP03.ex3;

import java.util.Scanner;

public class CallingCost {
    public static void main(String[]args){
        System.out.println("Program for calculating cost of a call.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input start hours: ");
        int startHours = sc.nextInt();//20
        System.out.print("Please input start minutes: ");
        int startMinutes = sc.nextInt();//30
        System.out.print("Please input start seconds: ");
        int startSeconds = sc.nextInt();//50
        System.out.println("");
        System.out.print("Please input end hours: ");
        int endHours = sc.nextInt();//20
        System.out.print("Please input end minutes: ");
        int endMinutes = sc.nextInt();//35
        System.out.print("Please input end seconds: ");
        int endSeconds = sc.nextInt();//5
        System.out.println("");
        int hoursSpend = endHours-startHours;
        int minutesSpend = endMinutes - startMinutes;
        int secondsSpend = endSeconds - startSeconds;
        if(secondsSpend<0){
            minutesSpend = minutesSpend -1;
            secondsSpend = 60 + secondsSpend;
        }
        if(minutesSpend<0){
            hoursSpend = hoursSpend-1;
            minutesSpend = 60 + minutesSpend;
        }
        System.out.println("Total call duration: "+hoursSpend+"h "+minutesSpend+"mn "+secondsSpend+"s");
        float minutesSpendf = hoursSpend*60 + minutesSpend + (float)secondsSpend/60;
        System.out.printf("Total cost of this call: %.4f$\n",minutesSpendf*0.05);
    }
}
