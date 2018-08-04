package com.example.alokitnigam.trackingassignment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alokitnigam.trackingassignment.Model.UserModel;
import com.example.alokitnigam.trackingassignment.ViewModel.UserViewModel;
import com.example.alokitnigam.trackingassignment.storage.MySharedPreferences;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private UserViewModel viewModel;
    EditText email,password;
    TextView info;
    Button buttonl;
    TextView button2;

    MySharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp=MySharedPreferences.getInstance(this);

        if (sp.chk("name"))
            startActivity(new Intent(LoginActivity.this,MainActivity.class));


        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        info=findViewById(R.id.info);
        button2=findViewById(R.id.signup);
        buttonl=findViewById(R.id.button);

        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
            }
        });
        buttonl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.checkUser(email.getText().toString(),password.getText().toString()).observe(LoginActivity.this,
                        new Observer<List<UserModel>>() {
                    @Override
                    public void onChanged(@Nullable List<UserModel> userModels) {
                        if (userModels.size()>0)
                        {
                            sp.set("name",""+userModels.get(0).getName());
                            sp.set("id",""+userModels.get(0).getUser_id());
                            sp.set("mobile",""+userModels.get(0).getMobile());
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        }

                    }
                });

            }
        });



    }
}
