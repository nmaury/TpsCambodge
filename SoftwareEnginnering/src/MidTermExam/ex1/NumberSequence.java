package MidTermExam.ex1;

import java.util.Scanner;

public class NumberSequence {
    Scanner sc;

    public NumberSequence() {
        this.sc = new Scanner(System.in);
        this.displayInput();
    }
    private int getIntInput(){
        System.out.print("Input positive number: ");
        while(!this.sc.hasNextInt()){
            sc.next();
            System.out.print("Input only positive number: ");
        }
        return this.sc.nextInt();
    }
    private void displayInput(){
        int number=this.getIntInput();
        while(number<1){
            number = this.getIntInput();
        }
        this.computeSequence(number);
    }
    public void computeSequence(int number){
        for(int i=number;i>0;i--){
            System.out.print("0"+i+" ");
        }
        for(int i = 2; i<=number;i++){
            System.out.print("0"+i+" ");
        }
    }
    public static void main(String[] args) {
        NumberSequence numberSequence = new NumberSequence();
    }

}
