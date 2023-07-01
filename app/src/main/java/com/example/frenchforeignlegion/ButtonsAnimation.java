package com.example.frenchforeignlegion;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * @author Belitski Marat
 * @date 01.07.2023
 */
public interface ButtonsAnimation {
    @SuppressLint("ClickableViewAccessibility")
    default void showAnimationButton(Button button) {
        Animation scaleUp = AnimationUtils.loadAnimation((Context) this, R.anim.scale_up);
        Animation scaleDown = AnimationUtils.loadAnimation((Context) this, R.anim.scale_down);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    button.startAnimation(scaleUp);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    button.startAnimation(scaleDown);
                }
                return false;
            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    default void showAnimationImageButton(ImageButton button) {
        Animation scaleUp = AnimationUtils.loadAnimation((Context) this, R.anim.scale_up);
        Animation scaleDown = AnimationUtils.loadAnimation((Context) this, R.anim.scale_down);
        button.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    button.startAnimation(scaleUp);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    button.startAnimation(scaleDown);
                }
                return false;
            }
        });
    }
}
