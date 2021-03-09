package com.rasyidf.adoptier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    CheckBox ckRemember;
    EditText edEmail, edPass;
    String email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btLogin);
        edEmail = findViewById(R.id.edEmail);
        edPass = findViewById(R.id.edPass);
        ckRemember = findViewById(R.id.ckRemember);
        btnLogin.setOnClickListener(view -> {
            email = edEmail.getText().toString();
            password = edPass.getText().toString();

            Toast t = Toast.makeText(getApplicationContext(), "email anda " + email + ", dan password anda : "+ password, Toast.LENGTH_LONG);
            t.show();

        });
    }


}