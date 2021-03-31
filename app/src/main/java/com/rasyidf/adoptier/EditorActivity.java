package com.rasyidf.adoptier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class EditorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);


        Bundle bundle = getIntent().getExtras();
        Boolean editable = bundle.getBoolean("editable");
        String nama = bundle.getString("nama");
        String nomor = bundle.getString("nomor");
        EditText edNama = findViewById(R.id.edName);
        EditText edNomor = findViewById(R.id.edNoHP);
        edNama.setText(nama);
        edNomor.setText(nomor);
        if (!editable){
            edNama.setEnabled(false);
            edNomor.setEnabled(false);
        }

    }

    public void back_OnClick(View view) {

        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(i);

    }
}