package com.example.alokitnigam.trackingassignment.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.alokitnigam.trackingassignment.Database.LocationDatabase;
import com.example.alokitnigam.trackingassignment.Database.UserDatabase;
import com.example.alokitnigam.trackingassignment.Model.LocationModel;
import com.example.alokitnigam.trackingassignment.Model.UserModel;

import java.util.List;

public class LocationViewModel extends AndroidViewModel {
    private LocationDatabase userDatabase;

    public LocationViewModel( Application application) {
        super(application);
        userDatabase= LocationDatabase.getDatabase(application.getApplicationContext());
    }
    public LiveData<List<LocationModel>> getLocations (){

        LiveData<List<LocationModel>> data = userDatabase.userModel().getLocation();
        return data;

        //new checkAsyncTask(userDatabase).execute(email,password);
    }
    public void addloc (String lat, String lng){
        //userDatabase.userModel().addUser(new UserModel(email,password));
        new LocationViewModel.addAsyncTask(userDatabase).execute(new LocationModel(lat,lng));
    }
    private static class addAsyncTask extends AsyncTask<LocationModel, Void, Void> {

        private LocationDatabase db;

        addAsyncTask(LocationDatabase appDatabase) {

            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final LocationModel... params) {
            db.userModel().addLocation(params[0]);
            return null;
        }

    }

}
