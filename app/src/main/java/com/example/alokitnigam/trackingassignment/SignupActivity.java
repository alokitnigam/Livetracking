package com.example.alokitnigam.trackingassignment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alokitnigam.trackingassignment.ViewModel.UserViewModel;

public class SignupActivity extends AppCompatActivity {
    private UserViewModel viewModel;
    EditText email,email3,password;
    TextView info;
    Button buttonl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        email=findViewById(R.id.email2);
        password=findViewById(R.id.password2);
        info=findViewById(R.id.info);
        email3=findViewById(R.id.email3);

        buttonl=findViewById(R.id.button2);

        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        buttonl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.adduser(email.getText().toString(),password.getText().toString(),email3.getText().toString());
                Toast.makeText(SignupActivity.this, "User Registered Succesfully", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(SignupActivity.this,LoginActivity.class));
            }
        });
    }
}
