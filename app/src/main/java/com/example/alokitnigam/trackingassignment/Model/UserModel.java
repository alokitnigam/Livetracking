package com.example.alokitnigam.trackingassignment.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity

public class UserModel {
    @PrimaryKey(autoGenerate = true)
    public int user_id;

    String name;
    String mobile;
    String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }



    public UserModel(String name, String password,String mobile) {
        this.name=mobile;
        this.password=password;
        this.mobile=name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
