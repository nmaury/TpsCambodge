package TP03.ex5;

import java.sql.Time;
import java.util.Scanner;

public class TravellingDuration {
    public static void main(String[] args) {
        System.out.println("Program for calculating duration of travel from ITC to Airport.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input traffic jam factor (in percentage [0-100]): ");
        float percent = sc.nextFloat();
        float realSpeed = 30 - percent * 30 / 100;
        if (realSpeed == 0) {
            realSpeed = (float) 0.01;
        }
        float timeInHour = 7 / realSpeed;
        if (timeInHour > 24) {
            System.out.println("Travelling Duration > 1 Day");
        } else{
        float timeInMinutes = timeInHour * 60;
        int h = (int) timeInHour;
        int m = (int) ((timeInHour - h) * 60);
        int s = (int) ((timeInMinutes - h * 60 - m) * 60);
        Time result = new Time(h, m, s);
        System.out.println("Travelling Duration = "+result.toString());
}
}
}
