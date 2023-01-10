package TP05.ce2;

import java.util.HashMap;
import java.util.Map;

public class MessageCoder {
    private String message;
    private String encodedMessage;
    private Map<String,String> specialsCharacters;

    public MessageCoder(String message, Map<String, String> specialsCharacters) {
        this.message = message;
        this.specialsCharacters = specialsCharacters;
    }
    public String encode(){
        this.encodedMessage = this.message;
        for(Map.Entry<String,String> entry : this.specialsCharacters.entrySet()){
            this.encodedMessage = this.encodedMessage.replaceAll(entry.getKey(),entry.getValue());
        }
        return this.encodedMessage;
    }
    public String decode(){
        this.message = this.encodedMessage;
        for(Map.Entry<String,String> entry : this.specialsCharacters.entrySet()){
            this.message = this.message.replaceAll(entry.getValue(),entry.getKey());
        }
        return this.message;
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("\\\\n","\\(new_line\\)");
        map.put("\\\\t","\\(tab\\)");
        map.put("\\\\\\\\","\\(slash\\)");
        map.put("//","\\(comment_line\\)");
        map.put(":\\)","\\(smile\\)");
        String sentence = "\\n \\t is used to represent new line \\n\\\\ it is a // line comment :)";
        System.out.println(sentence);
        MessageCoder messageCoder = new MessageCoder(sentence,map);
        System.out.println(messageCoder.encode());
        System.out.println(messageCoder.decode());
        System.out.println(messageCoder.encode());
        System.out.println(messageCoder.decode());
    }
}
