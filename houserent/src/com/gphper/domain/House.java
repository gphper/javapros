package com.gphper.domain;

public class House {
    private int id;
    private String name;
    private String phone;
    private String address;
    private int rent;
    private String stat;
    public House(String name, String phone, String address, int rent,String stat) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.stat = stat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getRent() {
        return rent;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getStat() {
        return stat;
    }

    @Override
    public String toString() {
        return  id +
                "\t\t" + name +
                "\t\t" + phone  +
                "\t\t" + address  +
                "\t\t" + rent +
                "\t\t" + stat;
    }
}
