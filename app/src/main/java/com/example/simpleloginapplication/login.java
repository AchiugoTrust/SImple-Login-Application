package com.example.simpleloginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button login_btn;
    int attempt_counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }

    public void LoginButton() {
        username = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPassword);
        attempts = (TextView) findViewById(R.id.attempts);
        login_btn = (Button) findViewById(R.id.button);
        attempts.setText(Integer.toString (attempt_counter)) ;
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("user") && password.getText().toString().equals("pass")) {
                    Toast.makeText(login.this, "User and Password is correct",
                            Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(login.this, user.class)) ;
                } else {
                    Toast.makeText(login.this, "User and Password are not correct",
                            Toast.LENGTH_SHORT).show();
                    attempt_counter--;
                    attempts.setText(Integer.toString(attempt_counter));
                    if (attempt_counter == 0) {
                        login_btn.setEnabled(false);
                    }
                }
            }
        });
    }
}


