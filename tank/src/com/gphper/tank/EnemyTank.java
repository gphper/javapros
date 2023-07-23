package com.gphper.tank;

import java.util.Vector;

public class EnemyTank extends Tank{
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y, int direct) {
        super(x, y, direct);
    }
}
