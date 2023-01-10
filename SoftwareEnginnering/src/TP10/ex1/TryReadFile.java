package TP10.ex1;

import java.io.*;
public class TryReadFile {
    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } //will call br.close() automatically
    }
    public static void main(String[] args) {
        try {
            var text = readFirstLineFromFile("data.txt");
            System.out.println(text);
        } catch (IOException e) {
            System.out.println("OOPs Sth went wrong!");
        }
    }
}