package com.example.frenchforeignlegion;

import static android.content.Intent.ACTION_VIEW;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.action_back) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.action_info) {
            Toast toast = Toast.makeText(this, "Вы уже здесь", Toast.LENGTH_SHORT);
            toast.show();
        } else if (item.getItemId() == R.id.action_share) {
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String shareBody = "Узнайте больше о Французском иностранном легионе!\nhttps://yandex.by/video/preview/10866085358551954355";
            String shareSub = "Your subject";
            myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
            myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(myIntent, "Share using"));
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.toolbar_setting);

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
        } else if (temp == R.id.b_youtube) {
            link = "https://www.youtube.com/user/LegionEtrangereCOMLE";
        } else if (temp == R.id.b_instagram) {
            link = "https://www.instagram.com/legionetrangereofficiel/";
        } else if (temp == R.id.b_recruiting) {
            link = "https://www.legion-recrute.com/fr";
        }
        Intent intent = new Intent(ACTION_VIEW, Uri.parse(link));
        startActivity(intent);
    }
}