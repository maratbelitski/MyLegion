package com.example.frenchforeignlegion.practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.frenchforeignlegion.ButtonsAnimation;
import com.example.frenchforeignlegion.MainActivity;
import com.example.frenchforeignlegion.MenuMethods;
import com.example.frenchforeignlegion.R;

public class PracticeActivity extends AppCompatActivity implements MenuMethods, ButtonsAnimation {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        showMenu(item,this, MainActivity.class);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.toolbar_practice);

        Button history_creation=findViewById(R.id.b_psychologist);
        Button b_security_service=findViewById(R.id.b_security_service);
        Button b_test=findViewById(R.id.b_tests);

        showAnimationButton(history_creation);
        showAnimationButton(b_security_service);
        showAnimationButton(b_test);
    }

    public void showButtonAction(View view) {
        String toast = getResources().getString(R.string.toast_development);
        Class<?> destinations = null;
        int temp = view.getId();
        if (temp == R.id.b_psychologist) {
            Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
            //destinations = HistoryCreateActivity.class;
        } else if (temp == R.id.b_security_service) {
            Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
            // destinations = WarActivity.class;
        } else if (temp == R.id.b_tests) {
            Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
            //destinations = TraditionActivity.class;
        }
//        Intent intent = new Intent(this, destinations);
//        startActivity(intent);
    }
}