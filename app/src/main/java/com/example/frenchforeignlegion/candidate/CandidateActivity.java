package com.example.frenchforeignlegion.candidate;

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
import com.example.frenchforeignlegion.history.TraditionActivity;

public class CandidateActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.toolbar_legion_candidate);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        Animation scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        Animation scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        Button b_officially = findViewById(R.id.b_officially);
        Button b_preparation = findViewById(R.id.b_preparation);
        Button b_question_answer = findViewById(R.id.b_question_answer);

        b_officially.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    b_officially.startAnimation(scaleUp);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    b_officially.startAnimation(scaleDown);
                }
                return false;
            }
        });

        b_preparation.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    b_preparation.startAnimation(scaleUp);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    b_preparation.startAnimation(scaleDown);
                }
                return false;
            }
        });

        b_question_answer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    b_question_answer.startAnimation(scaleUp);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    b_question_answer.startAnimation(scaleDown);
                }
                return false;
            }
        });

    }

    public void showTradition(View view) {
        Intent intent = new Intent(this, TraditionActivity.class);
        startActivity(intent);
    }


    public void showButtonAction(View view) {
        Class destination = null;
        int idButton = view.getId();

        if (idButton == R.id.b_question_answer) {
            destination = QuestionAnswerActivity.class;
        } else if (idButton == R.id.b_officially) {
            destination = OfficiallyActivity.class;
        } else if (idButton == R.id.b_preparation) {
            destination = PreparationActivity.class;
        }
        Intent intent = new Intent(this, destination);
        startActivity(intent);
    }
}