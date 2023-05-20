package com.gphper.main;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double balance = 0;
        boolean exist = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        ArrayList<UseLog> logs = new ArrayList<>();

        do{

            System.out.println("=================零钱通菜单=================");
            System.out.println("\t\t\t\t1 零钱通明细");
            System.out.println("\t\t\t\t2 收益入账");
            System.out.println("\t\t\t\t3 消费");
            System.out.println("\t\t\t\t4 退     出");

            System.out.println("请选择(1-4): ");
            key = scanner.next();

            Date data = new Date();
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            switch (key){
                case "1":
                    System.out.println("--------零钱通明细----------");
                    for(int i = 0;i<logs.size();i++){
                        System.out.println(logs.get(i).mark+"\t"+logs.get(i).type+logs.get(i).one+"\t"+logs.get(i).date+"\t余额:"+logs.get(i).currentBalance);
                    }
                    break;
                case "2":
                    System.out.println("收益入账");

                    double in = scanner.nextDouble();
                    balance += in;

                    logs.add(new UseLog("收益入账","+",in,form.format(data),balance));
                    break;
                case "3":
                    System.out.println("消费项目");
                    String mark = scanner.next();
                    System.out.println("消费金额");
                    double out = scanner.nextDouble();
                    balance -= out;
                    logs.add(new UseLog(mark,"-",out,form.format(data),balance));
                    break;
                case "4":
                    System.out.println("退出");
                    break;
                default:
                    System.out.println("错误选项");
                    exist = false;
            }

        }while(exist);
    }
}