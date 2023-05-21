package com.gphper.service;

import com.gphper.domain.House;

import java.util.ArrayList;

public class HouseService {

    private ArrayList<House> data;
    int index = 0;

    public HouseService() {
        this.data = new ArrayList<>();
    }

    public ArrayList list(){
        return this.data;
    }

    public boolean add(House h){
        index ++;
        h.setId(index);
        this.data.add(h);
        return true;
    }

    public House search(int id){
        for(int i = 0;i<this.data.size();i++){
            if (this.data.get(i).getId() == id){
                return this.data.get(i);
            }
        }

        return null;
    }

    public boolean delete(int id){

        for(int i = 0;i<this.data.size();i++){
            if (this.data.get(i).getId() == id){
                this.data.remove(this.data.get(i));
                return true;
            }
        }

        return false;
    }

    public boolean save(int id,House newHouse){

        for(int i = 0;i<this.data.size();i++){
            if (this.data.get(i).getId() == id){
                this.data.set(i,newHouse);
                return true;
            }
        }

        return true;
    }
}
