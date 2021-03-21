package com.rasyidf.adoptier;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    Boolean isAuth;
    String email, pass;
    TextView auth, tmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        isAuth = bundle.getBoolean("Remembered");
        email = bundle.getString("email");
        pass = bundle.getString("pass");

        auth = findViewById(R.id.tbAuth);
        tmail = findViewById(R.id.tbEmail);
        auth.setText(isAuth?"Anda akan diingat": "Anda tidak diingat");
        tmail.setText(email);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Floating Button Clicked", Snackbar.LENGTH_LONG).setAction("Action", null).show());
    }
}