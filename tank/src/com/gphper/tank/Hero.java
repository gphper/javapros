package com.gphper.tank;

public class Hero extends Tank{
    // 定义子弹对象
    Shot shot;
    public Hero(int x, int y,int direct) {
        super(x, y,direct);
    }

    public void shotEnemyTank(){

        //创建子弹
        switch (getDirect()){
            case 0:
                shot = new Shot(getX()+50,getY()-30,getDirect());
                break;
            case 1:
                shot = new Shot(getX()+50,getY()+170,getDirect());
                break;
            case 2:
                shot = new Shot(getX()-30,getY()+50,getDirect());
                break;
            case 3:
                shot = new Shot(getX()+170,getY()+50,getDirect());
                break;
        }

        (new Thread(shot)).start();
    }
}
