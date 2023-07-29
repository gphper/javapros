package com.gphper.tank;

public class Tank {
    private int x;
    private int y;
    private int direct;
    private int speed  = 1;
    boolean isLive = true;
    public Tank(int x, int y,int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public void moveUp(){
        if (y > 30){
            y -= speed;
        }
    }

    public void moveDown(){
        if (y < GlobalVar.PanelHeight - 170){
            y += speed;
        }
    }

    public void moveLeft(){
        if (x > 30){
            x -= speed;
        }
    }

    public void moveRight(){
        if (x < GlobalVar.PanelWidth - 170){
            x += speed;
        }
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public int getDirect() {
        return direct;
    }
    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
