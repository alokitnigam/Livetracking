package com.example.alokitnigam.trackingassignment.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.alokitnigam.trackingassignment.Model.UserModel;

import java.util.List;
import java.util.Optional;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {
    @Query("select * from UserModel where mobile = :name and password=:password")
    LiveData<List<UserModel>> checkUser(String name, String password);

    @Insert(onConflict = REPLACE)
    void addUser(UserModel userModel);
}
