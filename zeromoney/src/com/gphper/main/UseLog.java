package com.gphper.main;

public class UseLog {
    public String mark; //记录声明
    public String type; // 正负号
    public double one; //本次交易金额
    public String date; //时间
    public double currentBalance; //当前余额

    public UseLog(String mark, String type, double one, String date, double currentBalance) {
        this.mark = mark;
        this.type = type;
        this.one = one;
        this.date = date;
        this.currentBalance = currentBalance;
    }
}
