package TP04.ce1;

import java.util.Scanner;

public class Tp04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice =-1;
        while (choice != 0) {
            System.out.print("-------- Menu ---------\n" +
                    "1. Prime number\n" +
                    "2. Lucky number\n" +
                    "3. Reversing number\n" +
                    "4. Money exchange\n" +
                    "5. Max among 8 numbers\n" +
                    "6. Shipping\n" +
                    "7. Leap year\n" +
                    "0. Exit\n" +
                    "Choose an option: ");
            choice = sc.nextInt();
            System.out.println("\n-----------------------");

                    switch (choice){
                case 1:
                    TP04.ex1.PrimeNumber.main(null);
                    break;
                case 2:
                    TP04.ex2.LuckyNumber.main(null);
                    break;
                case 3:
                    TP04.ex3.ReversingNumber.main(null);
                    break;
                case 4:
                    TP04.ex4.MoneyExchanges.main(null);
                    break;
                case 5:
                    TP04.ex5.MaxNumber.main(null);
                    break;
                case 6:
                    TP04.ex6.Shipping.main(null);
                    break;
                case 7:
                    TP04.ex7.LeapYear.main(null);
                    break;
                case 0:
                    sc.close();
                    System.exit(200);
            }
        }
    }
}
