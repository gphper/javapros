package com.gphper.view;

import com.gphper.domain.House;
import com.gphper.service.HouseService;
import com.gphper.utils.Utility;

import java.util.ArrayList;

public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private HouseService serive = new HouseService();
    public void mainMenu(){
        do {
            System.out.println("===============房屋出租系统菜单==============");
            System.out.println("\t\t\t\t1 新 增 房 屋");
            System.out.println("\t\t\t\t2 查 找 房 源");
            System.out.println("\t\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t\t6 退      出");

            System.out.println("请输入你的选择(1-6):");

            key = Utility.readChar();
            switch (key){
                case '1':
                    this.addHouse();
                    break;
                case '2':
                    this.searchHouse();
                    break;
                case '3':
                    this.deleteHouse();
                    break;
                case '4':
                    this.editHouse();
                    break;
                case '5':
                    this.listHouses();
                    break;
                case '6':
                    loop = false;
                    break;

            }

        }while (loop);
    }

    public void deleteHouse(){
        System.out.print("输入删除ID:");
        int id = Utility.readInt();
        boolean result = this.serive.delete(id);
        if (!result){
            System.out.println("删除失败");
            return;
        }
        System.out.println("删除成功");
    }

    public void searchHouse(){
        System.out.print("输入查找ID:");
        int id = Utility.readInt();
        House h = this.serive.search(id);
        if (h == null){
            System.out.println("查找的房屋信息不存在");
            return;
        }
        System.out.println(h);
    }

    public void addHouse(){
        System.out.println("===========添加房屋==============");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String stat = Utility.readString(3);

        House h = new House(name,phone,address,rent,stat);
        this.serive.add(h);
    }

    public void  listHouses(){
        System.out.println("============房屋列表=============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        ArrayList data = this.serive.list();
        for(int i = 0;i<data.size();i++){
            System.out.println(data.get(i));
        }
        System.out.println("------------房屋列表显示完毕--------");
    }

    public void editHouse(){
        System.out.println("============修改房屋=============");
        System.out.print("选择修改房屋的ID：");
        int id = Utility.readInt();
        House h = this.serive.search(id);
        if(h == null){
            System.out.println("房屋信息不存在");
            return ;
        }
        System.out.print("姓名["+h.getName()+"]：");
        String name = Utility.readString(8);
        System.out.print("电话["+h.getPhone()+"]：");
        String phone = Utility.readString(12);
        System.out.print("地址["+h.getAddress()+"]：");
        String address = Utility.readString(16);
        System.out.print("月租["+h.getRent()+"]：");
        int rent = Utility.readInt();
        System.out.print("状态["+h.getStat()+"]：");
        String stat = Utility.readString(3);

        House newH = new House(name,phone,address,rent,stat);
        newH.setId(id);
        this.serive.save(id,newH);
    }
}
