package com.rasyidf.adoptier;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

public class HomeActivity extends AppCompatActivity {
    private ListView list;
    private ListViewAdapter adapter;
    Boolean isAuth;
    String email, pass;

    KontakItem listNama[] = {
            new KontakItem("Ani", "085123456789"),
            new KontakItem("Budi", "085123456789"),
            new KontakItem("Caca", "085123456789"),
            new KontakItem("Danu", "085123456789"),
            new KontakItem("Ervan", "085123456789"),
            new KontakItem("Fatimah", "085123456789"),
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnDaftar:
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
                break;
            case R.id.Lupa:
                Toast.makeText(getApplicationContext(), "@string/tryRemember", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        list = findViewById(R.id.lstKontak);



        adapter = new ListViewAdapter(getApplicationContext(), listNama);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this::onItemClick);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Floating Button Clicked", Snackbar.LENGTH_LONG).setAction("Action", null).show());
    }

    private void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        KontakItem pilihan = listNama[pos];
        Bundle bundle = new Bundle();
        bundle.putString("nama", pilihan.getNama());
        bundle.putString("nomor", pilihan.getNomor());

        PopupMenu pm = new PopupMenu(getApplicationContext(), view, Gravity.RIGHT);

        Intent i = new Intent(getApplicationContext(), EditorActivity.class);
        pm.setOnMenuItemClickListener(getOnMenuItemClickListener(bundle, i));

        pm.inflate(R.menu.popup_menu);

        pm.show();

    }

    @NotNull
    private PopupMenu.OnMenuItemClickListener getOnMenuItemClickListener(Bundle bundle, Intent i) {
        return (MenuItem item) -> {
            switch (item.getItemId()) {
                case R.id.mnuView:
                    bundle.putBoolean("editable", false); 
                    break;
                case R.id.mnuEdit:
                    bundle.putBoolean("editable", true);
                    break;
                default:
                    return false;
            }
            i.putExtras(bundle);
            startActivity(i);
            return true;

        };
    }
}