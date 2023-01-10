package TP05.ex6;

import java.util.Scanner;

public class StringMirror {
    private String word;

    public StringMirror(String word) {
        this.word = word;
    }
    public String makePalindrome(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.word);
        String res = this.word.concat(sb.reverse().toString());
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a word: ");
        String word = sc.next();
        StringMirror stringMirror = new StringMirror(word.toUpperCase());
        System.out.println(stringMirror.makePalindrome());
    }
}
