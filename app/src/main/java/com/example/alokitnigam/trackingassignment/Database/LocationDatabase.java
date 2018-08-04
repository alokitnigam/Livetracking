package com.example.alokitnigam.trackingassignment.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.alokitnigam.trackingassignment.Dao.LocationDao;
import com.example.alokitnigam.trackingassignment.Dao.UserDao;
import com.example.alokitnigam.trackingassignment.Model.LocationModel;


@Database(entities = {LocationModel.class}, version = 1)
public  abstract class LocationDatabase extends RoomDatabase {
    private static LocationDatabase INSTANCE;

    public static LocationDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), LocationDatabase.class, "location_db")

                            .build();
        }
        return INSTANCE;
    }
    public abstract LocationDao userModel();
}
