package TP05.ex5;

import java.util.Scanner;

public class Palindrome {
    private String word;
    public Palindrome(String word){
        this.word = word;
    }
    public boolean isPalindromeRev(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.word);
        StringBuilder reverse = sb.reverse();
        return this.word.equals(reverse.toString());
    }
    public boolean isPalindromeLoop(){
        for (int i = 0;i<this.word.length();i++){
            if(this.word.charAt(i) != this.word.charAt(this.word.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please gives a word to check: ");
        String word = sc.next();
        Palindrome p = new Palindrome(word.toUpperCase());
        System.out.print("Choose method (REV, LOOP): ");
        String method = sc.next();
        if(method.equals("REV")){
            if(p.isPalindromeRev()){
                System.out.println(word.toUpperCase()+" is a Palindrome");
            }else{
                System.out.println(word.toUpperCase()+" is not a Palindrome");
            }
        }else if(method.equals("LOOP")){
            if(p.isPalindromeLoop()){
                System.out.println(word.toUpperCase()+" is a Palindrome");
            }else{
                System.out.println(word.toUpperCase()+" is not a Palindrome");
            }
        }else{
            System.out.println("This method doesn't exist !");
        }
    }
}
