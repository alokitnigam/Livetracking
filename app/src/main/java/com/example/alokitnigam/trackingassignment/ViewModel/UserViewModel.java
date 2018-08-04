package com.example.alokitnigam.trackingassignment.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.alokitnigam.trackingassignment.Database.UserDatabase;
import com.example.alokitnigam.trackingassignment.Model.UserModel;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserDatabase userDatabase;

    public UserViewModel(Application application) {
        super(application);
        userDatabase = UserDatabase.getDatabase(this.getApplication());
    }


        public LiveData<List<UserModel>> checkUser (String email, String password){

            LiveData<List<UserModel>> data = userDatabase.userModel().checkUser(email, password);
            return data;

            //new checkAsyncTask(userDatabase).execute(email,password);
        }
        public void adduser (String email, String password,String name){
            //userDatabase.userModel().addUser(new UserModel(email,password));
            new addAsyncTask(userDatabase).execute(new UserModel(email, password,name));
        }
        private static class addAsyncTask extends AsyncTask<UserModel, Void, Void> {

            private UserDatabase db;

            addAsyncTask(UserDatabase appDatabase) {

                db = appDatabase;
            }

            @Override
            protected Void doInBackground(final UserModel... params) {
                db.userModel().addUser(params[0]);
                return null;
            }

        }
}

