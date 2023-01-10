package TP05.ex7;

import TP05.ce2.MessageCoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharactersEscape {
    private String sentence;
    private Map<String,String> map;
    private MessageCoder messageCoder;
    public CharactersEscape(String sentence) {
        this.sentence = sentence;
        this.map = new HashMap<>();
        map.put("\\\\n","\\(new_line\\)");
        map.put("\\\\t","\\(tab\\)");
        map.put("\\\\\\\\","\\(slash\\)");
        map.put("//","\\(comment_line\\)");
        map.put(":\\)","\\(smile\\)");
        this.messageCoder = new MessageCoder(this.sentence,this.map);
    }
   public String computeRemplacement() {
       /*String res = this.sentence.replaceAll("\\\\n","(new_line)");
       res = res.replaceAll("\\\\t","(tab)");
       res = res.replaceAll("\\\\\\\\","(slash)");
       res = res.replaceAll("//","(comment_line)");
       res = res.replaceAll(":\\)","(smile)");

       return res;*/
       return this.messageCoder.encode();
   }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a sentence: ");
        String sentence = sc.nextLine();
        CharactersEscape charactersEscape = new CharactersEscape(sentence);
        System.out.print(charactersEscape.computeRemplacement());
    }
}
