package com.gphper.tank;

public class Shot implements Runnable{
    int x;
    int y;
    int direct = 0; // 0上 1下 2左 3右
    int speed = 1;
    boolean isLive = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {

        while (true){

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            switch (direct){
                case 0:
                    y -= speed;
                    break;
                case 1:
                    y += speed;
                    break;
                case 2:
                    x -= speed;
                    break;
                case 3:
                    x += speed;
                    break;
            }

            if(x < 0 || x > GlobalVar.PanelWidth || y < 0 || y > GlobalVar.PanelHeight || !isLive){
                isLive = false;
                break;
            }

        }
    }
}
