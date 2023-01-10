package MidTermExam.ex2;

import java.util.Scanner;

public class CostCalculation {
    private double cost;
    private int discount;
    private double totalPrice;

    public CostCalculation(double cost) {
        this.cost = cost;
        this.discount = 0;
        this.totalPrice = 0;
    }
    public void computeCostCalculation(){
        if(this.cost<30 && this.cost>=10){
            this.discount = 5;
        }else if(this.cost<80 && this.cost>=30){
            this.discount = 10;
        }else if(this.cost<150 && this.cost>=80){
            this.discount = 15;
        }else if(this.cost<300 && this.cost>=150){
            this.discount = 20;
        }else if(this.cost >= 300){
            this.discount =25;
        }
        if(this.discount>0){
            double totalDiscount = (this.discount*this.cost)/100;
            this.totalPrice = this.cost - totalDiscount;
            System.out.printf("\n\t Total cost:   %.2f $\n"+
                    "\t   Discount: \t  %d %%\n" +
                    " Total discount:    %.2f $\n" +
                    "------------------------------\n" +
                    "  Total payment:    %.2f $",this.cost,this.discount,totalDiscount,this.totalPrice);
        }else{
            this.totalPrice = this.cost;
            System.out.printf("\t Total cost:   %.2f $\n" +
                    "  Total discount:    0.00 $\n" +
                    "-----------------------------------\n" +
                    "  Total payment:    %.2f $",this.cost,this.totalPrice);
        }
    }
    public static double getDoublePrice(Scanner sc){
        System.out.print("Input total buying cost: ");
        while(!sc.hasNextDouble()){
            sc.next();
            System.out.print("Input total buying cost: ");
        }
        return sc.nextDouble();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double buyingCost = CostCalculation.getDoublePrice(sc);
        while(buyingCost<1){
            System.out.println("Cost must be positive.");
            buyingCost=CostCalculation.getDoublePrice(sc);
        }
        CostCalculation costCalculation = new CostCalculation(buyingCost);
        costCalculation.computeCostCalculation();
        sc.close();
    }
}
