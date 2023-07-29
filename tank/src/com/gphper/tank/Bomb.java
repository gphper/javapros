package com.gphper.tank;

public class Bomb {
    int x,y;
    boolean isLive = true;
    int life = 9;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown(){

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (life > 0){
            this.life --;
        }else{
            this.isLive = false;
        }
    }
}
