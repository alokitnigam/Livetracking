package com.example.alokitnigam.trackingassignment.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.alokitnigam.trackingassignment.Dao.UserDao;
import com.example.alokitnigam.trackingassignment.Model.UserModel;

@Database(entities = {UserModel.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static UserDatabase INSTANCE;

    public static UserDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "user_db")

                            .build();
        }
        return INSTANCE;
    }
    public abstract UserDao userModel();
}
