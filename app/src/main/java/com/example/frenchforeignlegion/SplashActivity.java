package com.example.frenchforeignlegion;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //создаем сплашскрин
        Intent intent = new Intent(this, MainActivity.class);
        Thread thread = new Thread() {

            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }
}