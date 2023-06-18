package com.gphper.tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements KeyListener {
    Hero hero = null;
    public MyPanel(){
        hero = new Hero(100, 100,0);
        hero.setSpeed(5);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),0);
    }

    /**
     * @param x x坐标
     * @param y y坐标
     * @param g 画笔
     * @param direct 方向 0上 1下 2左 3右
     * @param type 0我方 1敌方
     */
    public void drawTank(int x,int y,Graphics g,int direct,int type){
        switch (type){
            case 0:
                g.setColor(Color.CYAN);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }

        switch (direct){
            case 0:
                // 左轮
                g.fill3DRect(x,y,30,140,false);
                // 右轮
                g.fill3DRect(x+80,y,30,140,false);
                // 壳子
                g.fill3DRect(x+30,y+20,50,100,false);
                // 炮管
                g.fill3DRect(x+50,y-30,10,100,false);
                // 圆盖
                g.fillOval(x+30,y+35,50,50);
                break;
            case 1:
                // 左轮
                g.fill3DRect(x,y,30,140,false);
                // 右轮
                g.fill3DRect(x+80,y,30,140,false);
                // 壳子
                g.fill3DRect(x+30,y+20,50,100,false);
                // 炮管
                g.fill3DRect(x+50,y+70,10,100,false);
                // 圆盖
                g.fillOval(x+30,y+35,50,50);
                break;
            case 2:
                // 左轮
                g.fill3DRect(x,y,140,30,false);
                // 右轮
                g.fill3DRect(x,y+80,140,30,false);
                // 壳子
                g.fill3DRect(x+20,y+30,100,50,false);
                // 炮管
                g.fill3DRect(x-30,y+50,100,10,false);
                // 圆盖
                g.fillOval(x+35,y+30,50,50);
                break;
            case 3:
                // 左轮
                g.fill3DRect(x,y,140,30,false);
                // 右轮
                g.fill3DRect(x,y+80,140,30,false);
                // 壳子
                g.fill3DRect(x+20,y+30,100,50,false);
                // 炮管
                g.fill3DRect(x+70,y+50,100,10,false);
                // 圆盖
                g.fillOval(x+35,y+30,50,50);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W){
            hero.setDirect(0);
            hero.moveUp();
        }else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(2);
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(1);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(3);
            hero.moveRight();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
