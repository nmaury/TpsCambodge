package TP03.exce1;

import java.util.Scanner;

public class TasksRunner {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int choice =-1;
        while (choice !=0) {
            System.out.print("-------- Menu --------- \n 1. Seconds to Time \n 2. Time to Seconds \n 3. Calling Cost \n 4. Riels to Dollar \n 5. Traveling Duration \n 0. Exit \n Choose an option: ");
            choice = sc.nextInt();
            System.out.println("-----------------------");
            switch (choice) {
                case 1: {
                    TP03.ex1.SecondToTime.main(null);
                    break;
                }
                case 2: {
                    TP03.ex2.TimeToSecond.main(null);
                    break;
                }
                case 3: {
                    TP03.ex3.CallingCost.main(null);
                    break;
                }
                case 4: {
                    TP03.ex4.RielsToDollar.main(null);
                    break;
                }
                case 5: {
                    TP03.ex5.TravellingDuration.main(null);
                    break;
                }
            }
        }
        sc.close();
        System.out.println("End of the process...");
        System.exit(2);

    }
}
