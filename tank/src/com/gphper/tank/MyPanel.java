package com.gphper.tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener,Runnable {
    Hero hero = null;
    Vector<EnemyTank> enemyTank = new Vector<>();
    // 存放炸弹的集合
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 3;

    // 定义三张图
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel(){
        hero = new Hero(100, 500,0);
        hero.setSpeed(5);
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank tank = new EnemyTank((150 * (i+1)),0,1);
            // 添加地方坦克子弹对象
            Shot shot = new Shot(tank.getX()+50,tank.getY()+170,tank.getDirect());
            new Thread(shot).start();
            tank.shots.add(shot);
            enemyTank.add(tank);
        }

        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/big.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/mid.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/small.png"));
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),0);
        //画我方坦克子弹
        if (hero.shot != null && hero.shot.isLive){
            g.setColor(Color.RED);
            g.fillOval(hero.shot.x,hero.shot.y,10,10);
        }

        //画敌军坦克
        for(int i = 0;i < enemyTank.size();i++) {
            EnemyTank tmp = enemyTank.get(i);
            if(tmp.isLive){
                drawTank(tmp.getX(), tmp.getY(), g, tmp.getDirect(), 1);

                // 绘制当前坦克的子弹
                for(int j = 0;j < tmp.shots.size();j++){
                    Shot shot = tmp.shots.get(j);
                    if (shot.isLive){
                        g.setColor(Color.PINK);
                        g.fillOval(shot.x,shot.y,10,10);
                    }else{
                        tmp.shots.remove(shot);
                    }
                }
            }else{
                enemyTank.remove(tmp);
            }
        }

        // 绘制爆炸效果
        if (bombs.size() > 0){
            for (int i = 0; i < bombs.size();i++){
                Bomb bomb = bombs.get(i);

                if (bomb.life == 0) {
                   bombs.remove(bomb);
                   continue;
                }

                if (bomb.life > 6){
                    g.drawImage(image1, bomb.x, bomb.y,100,100,this);
                }else if(bomb.life > 3){
                    g.drawImage(image2, bomb.x, bomb.y,100,100,this);
                } else{
                    g.drawImage(image3, bomb.x, bomb.y,100,100,this);
                }

                bomb.lifeDown();
            }
        }
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
        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            // 按J发射
            hero.shotEnemyTank();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (hero.shot != null && hero.shot.isLive){
                for(int i = 0;i< enemyTank.size();i++){
                    EnemyTank enemyTank1 = enemyTank.get(i);
                    hitTank(hero.shot,enemyTank1);
                }
            }

            this.repaint();
        }
    }


    public void hitTank(Shot shot,EnemyTank tank){
        switch (tank.getDirect()){
            case 0:
            case 1:
                if(shot.x > tank.getX() && shot.x < tank.getX() + 110 && shot.y > tank.getY() && shot.y < tank.getY() + 140){
                    shot.isLive = false;
                    tank.isLive = false;
                    bombs.add(new Bomb(tank.getX(),tank.getY()));
                }
                break;
            case 2:
            case 3:
                if(shot.x > tank.getX() && shot.x < tank.getX() + 140 && shot.y > tank.getY() && shot.y < tank.getY() + 110){
                    shot.isLive = false;
                    tank.isLive = false;
                    bombs.add(new Bomb(tank.getX(),tank.getY()));
                }
                break;
        }
    }
}
