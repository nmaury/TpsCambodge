package TP03.ex1;

import java.sql.Time;
import java.util.Scanner;

public class SecondToTime {
    public static void main (String[] args){
        System.out.print("Input number of seconds: ");
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int h = e/3600;
        int m = (e%3600)/60;
        int s = (e%3600)%60;
        Time result = new Time(h,m,s);
        System.out.println("Time corresponding to "+e+" seconds is : "+result.toString()+".");
    }
}
