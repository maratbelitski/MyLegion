package com.example.frenchforeignlegion;

import static android.content.Intent.ACTION_VIEW;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class SettingsActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.toolbar_setting);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        ImageButton b_youtube = findViewById(R.id.b_youtube);
        ImageButton b_website = findViewById(R.id.b_website);
        ImageButton b_instagram = findViewById(R.id.b_instagram);
        ImageButton b_recruiting = findViewById(R.id.b_recruiting);

        Animation scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        Animation scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        b_youtube.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    b_youtube.startAnimation(scaleUp);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    b_youtube.startAnimation(scaleDown);
                }
                return false;
            }
        });

        b_website.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    b_website.startAnimation(scaleUp);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    b_website.startAnimation(scaleDown);
                }
                return false;
            }
        });

        b_instagram.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    b_instagram.startAnimation(scaleUp);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    b_instagram.startAnimation(scaleDown);
                }
                return false;
            }
        });

        b_recruiting.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    b_recruiting.startAnimation(scaleUp);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    b_recruiting.startAnimation(scaleDown);
                }
                return false;
            }
        });
    }


    public void showButtonAction(View view) {
        String link = "";
        int temp = view.getId();

        if (temp == R.id.b_website) {
            link = "https://www.legion-etrangere.com/";
        }else if(temp == R.id.b_youtube) {
            link = "https://www.youtube.com/user/LegionEtrangereCOMLE";
        }else if(temp == R.id.b_instagram) {
            link = "https://www.instagram.com/legionetrangereofficiel/";
        }else if(temp == R.id.b_recruiting) {
            link = "https://www.legion-recrute.com/fr";
        }
        Intent intent = new Intent(ACTION_VIEW, Uri.parse(link));
        startActivity(intent);
    }
}