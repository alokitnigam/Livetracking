package com.example.alokitnigam.trackingassignment.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.alokitnigam.trackingassignment.Model.LocationModel;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface LocationDao {
    @Insert(onConflict = REPLACE)
    void addLocation(LocationModel location);

    @Query("select * from LocationModel")
    LiveData<List<LocationModel>> getLocation();
}
