package TP04.ex4;

import java.util.Scanner;

public class MoneyExchanges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while(choice!=6) {
            System.out.printf("Welcome to program Money Exchanges!\n   1. Riels to Dollar\n   2. Riels to Thai Baht\n   3. Dollar to Riels\n   4. Dollar to Thai Baht\n   5. Thai Baht to Riels\n   6. Exit\n Choose an option: ");
            choice = sc.nextInt();
            String inputMoney="";
            String exchangeMoney="";
            double rate=0.;
            switch (choice) {
                case 1 :
                    inputMoney = "RIELS";
                    exchangeMoney = "USD";
                    rate = 1./4000;
                    break;
                case 2 :
                    inputMoney = "RIELS";
                    exchangeMoney = "BHT";
                    rate = 30./4000;
                    break;
                case 3 :
                    inputMoney = "USD";
                    exchangeMoney = "RIELS";
                    rate = 4000;
                    break;
                case 4 :
                    inputMoney = "USD";
                    exchangeMoney = "BHT";
                    rate = 30;
                    break;
                case 5 :
                    inputMoney = "BHT";
                    exchangeMoney = "RIELS";
                    rate = 4000./30;
                    break;
                default :
                    System.out.println("ending...");
                    System.exit(201);

            }
            System.out.print("Input money in "+inputMoney+": ");
            int money = sc.nextInt();
            System.out.printf("\n"+money+" "+inputMoney+" = %.2f "+exchangeMoney+"\n\n",rate*money);
        }
    }
}
