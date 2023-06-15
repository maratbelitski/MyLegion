package com.example.frenchforeignlegion.history;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.frenchforeignlegion.R;

public class HistoryActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.toolbar_history);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button b_history_creation=findViewById(R.id.b_history_creation);
        Button b_war=findViewById(R.id.b_war);
        Button b_tradition=findViewById(R.id.b_tradition);

        Animation scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        Animation scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        b_history_creation.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    b_history_creation.startAnimation(scaleUp);
                } else if (event.getAction()==MotionEvent.ACTION_UP) {
                   b_history_creation.startAnimation(scaleDown);
                }
                return false;
            }
        });

        b_war.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                   b_war.startAnimation(scaleUp);
                } else if (event.getAction()==MotionEvent.ACTION_UP) {
                    b_war.startAnimation(scaleDown);
                }
                return false;
            }
        });

        b_tradition.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    b_tradition.startAnimation(scaleUp);
                } else if (event.getAction()==MotionEvent.ACTION_UP) {
                   b_tradition.startAnimation(scaleDown);
                }
                return false;
            }
        });
    }

    public void showHistoryCreations(View view) {
        Intent intent = new Intent(HistoryActivity.this, HistoryCreateActivity.class);
        startActivity(intent);
    }

    public void showWar(View view) {
        Intent intent = new Intent(HistoryActivity.this, WarActivity.class);
        startActivity(intent);
    }

    public void showTradition(View view) {
        Intent intent = new Intent(HistoryActivity.this, TraditionActivity.class);
        startActivity(intent);
    }
}