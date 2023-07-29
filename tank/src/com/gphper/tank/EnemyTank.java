package com.gphper.tank;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{
    Vector<Shot> shots = new Vector<>();
    public EnemyTank(int x, int y, int direct) {
        super(x, y, direct);
    }

    @Override
    public void run() {

        while(true){

            switch (getDirect()){
                case 0:

                    if (shots.size() == 0){
                        Shot shot = new Shot(getX()+50,getY()-30,getDirect());
                        new Thread(shot).start();
                        shots.add(shot);
                    }

                    for (int i = 0; i < 30; i++) {
                        if (getY() > 30){
                            moveUp();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:

                    if (shots.size() == 0){
                        Shot shot = new Shot(getX()+50,getY()+170,getDirect());
                        new Thread(shot).start();
                        shots.add(shot);
                    }

                    for (int i = 0; i < 30; i++) {

                        if (getY() < GlobalVar.PanelHeight - 170){
                            moveDown();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:

                    if (shots.size() == 0){
                        Shot shot = new Shot(getX()-30,getY()+50,getDirect());
                        new Thread(shot).start();
                        shots.add(shot);
                    }

                    for (int i = 0; i < 30; i++) {

                        if(getX() > 30){
                            moveLeft();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:

                    if (shots.size() == 0){
                        Shot shot = new Shot(getX()+170,getY()+50,getDirect());
                        new Thread(shot).start();
                        shots.add(shot);
                    }

                    for (int i = 0; i < 30; i++) {

                        if (getX() < GlobalVar.PanelWidth - 170){
                            moveRight();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }

            int direct = (int) (Math.random() * 4);
            // 设置方向，发射子弹
            setDirect(direct);

            if (!isLive){
                break;
            }
        }

    }
}
