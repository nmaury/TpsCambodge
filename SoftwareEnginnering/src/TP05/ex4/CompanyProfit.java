package TP05.ex4;

import java.util.Scanner;

public class CompanyProfit {
    private float [] yearlyProfit;
    private int id;
    public CompanyProfit(){
        this.yearlyProfit = new float[12];
        this.id=0;
    }
    public void addMonth(float newvalue){
        this.yearlyProfit[this.id]= newvalue;
        this.id++;
    }
    public void computeTotalProfit(){
        float total=0;
        for (int i = 0; i<yearlyProfit.length;i++){
            System.out.println(this.yearlyProfit[i]);
            total += this.yearlyProfit[i];
        }
        System.out.printf("Total profits for 12 months   : %.2f",total);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CompanyProfit cp = new CompanyProfit();
        for(int i = 1; i<=12;i++){
            System.out.print("Profit for month "+i+"  : ");
            cp.addMonth(sc.nextFloat());
        }
        cp.computeTotalProfit();
    }
}
