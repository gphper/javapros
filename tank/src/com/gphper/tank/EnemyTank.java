package com.gphper.tank;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y, int direct) {
        super(x, y, direct);
    }

    @Override
    public void run() {

        while(true){

            switch (getDirect()){
                case 0:
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

            setDirect((int)(Math.random() * 4));
            if (!isLive){
                break;
            }
        }

    }
}
