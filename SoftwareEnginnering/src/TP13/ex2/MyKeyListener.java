package TP13.ex2;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyListener extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        char ch = e.getKeyChar();
        System.out.println(ch);
    }

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setSize(500,500);
        f.setVisible(false);
        f.addKeyListener(new MyKeyListener());
    }
}
