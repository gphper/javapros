package com.gphper.tank;

import javax.swing.*;

public class GameMain extends JFrame {
    MyPanel panel = null;
    public static void main(String[] args) {
        new GameMain();
    }

    public GameMain(){
        panel = new MyPanel();
        (new Thread(panel)).start();

        this.add(panel);
        this.setSize(GlobalVar.PanelWidth,GlobalVar.PanelHeight);
        this.addKeyListener(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
