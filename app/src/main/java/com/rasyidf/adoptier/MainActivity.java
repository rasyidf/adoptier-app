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
    String success, wrongEmail , wrongPass ,wrongCreds, tmpmsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        success = getResources().getString(R.string.loginSuccess);
        wrongEmail = getResources().getString(R.string.loginInvalidEmail);
        wrongPass = getResources().getString(R.string.loginInvalidPass);
        wrongCreds = getResources().getString(R.string.loginInvalidCreds);

        btnLogin = findViewById(R.id.btLogin);
        edEmail = findViewById(R.id.edEmail);
        edPass = findViewById(R.id.edPass);
        ckRemember = findViewById(R.id.ckRemember);
        btnLogin.setOnClickListener(view -> {
            String userEmail = "admin@mail.com";
            String userPass = "1234";
            email = edEmail.getText().toString();
            password = edPass.getText().toString();
            Boolean userRight = (email.equals(userEmail));
            Boolean passRight = (password.equals(userPass));

            if (userRight && passRight){
                tmpmsg = success;
            } else {
                tmpmsg = wrongCreds;
                if (userRight)
                    tmpmsg = wrongPass;

                if (passRight)
                    tmpmsg = wrongEmail;
            }
            Toast t = Toast.makeText(getApplicationContext(), tmpmsg, Toast.LENGTH_LONG);
            t.show();

        });
    }


}