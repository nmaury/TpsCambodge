package TP04.ex6;

import java.util.Scanner;

public class Shipping {
    private int distAB;
    private int distBC;
    private int weight;
    private int consumption;
    public Shipping(int distAB,int distBC,int weight) {
        this.distAB = distAB;
        this.distBC = distBC;
        this.weight = weight;
        if (this.weight > 30000) {
            this.consumption = -1;
        } else{
            if (this.weight < 5000) {
                this.consumption = 10;
            } else if (this.weight < 10000) {
                this.consumption = 20;
            } else if (this.weight < 20000) {
                this.consumption = 25;
            } else {
                this.consumption = 35;
            }
        }
    }
    public int getMinLiters(){
        if(this.consumption>0){
        int totalKm= this.distAB+this.distBC;
        int fuelUsed = totalKm*this.consumption;
        int fuelLeft = 5000-fuelUsed;
        if(fuelLeft<0){
            return Math.abs(fuelLeft);
        }else{
            return 0;
        }
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the distance between point A and B: ");
        int distAB = sc.nextInt();
        System.out.print("Please enter the distance between point B and C: ");
        int distBC = sc.nextInt();
        System.out.print("Please enter the weight of the payload: ");
        int weight = sc.nextInt();
        Shipping s = new Shipping(distAB,distBC,weight);
        if(s.getMinLiters()<0){
            System.out.println("The payload cannot be loaded");
        }else{
        System.out.println("the minimum number of liters needed to refill at point B is: "+s.getMinLiters());
        if(s.getMinLiters()>5000){
            System.out.println("The trip is not possible");
        }
        }
    }
}
