package com.rasyidf.adoptier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edEmail, edPass, edPassRe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edEmail = findViewById(R.id.edEmail);
        edPass = findViewById(R.id.edPass);
        edPassRe = findViewById(R.id.edPassRe);
    }


    public void Register_onClick(View view) {
        String email = edEmail.getText().toString();
        String pass = edPass.getText().toString();
        String passre = edPassRe.getText().toString();

        if (email.isEmpty()) {
            edEmail.setError("You must add email");
            Notify("You must add email");
        } else if (pass.isEmpty()) {
            edPass.setError("You must specify password");
        } else if (passre.isEmpty()) {
            edPassRe.setError("Enter your confirmation password");
        } else if (!pass.equals(passre)) {
            edPassRe.setError("The password must same, please check again");
        } else {
            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(i);
            Notify("Account Created! Login using you credentials");
        }
    }


    private void Notify(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }
}