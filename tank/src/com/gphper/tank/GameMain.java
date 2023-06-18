package com.gphper.tank;

import javax.swing.*;

public class GameMain extends JFrame {
    MyPanel panel = null;
    public static void main(String[] args) {
        new GameMain();
    }

    public GameMain(){
        panel = new MyPanel();
        this.add(panel);
        this.setSize(1000,750);
        this.addKeyListener(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
