package com.example.frenchforeignlegion;
import static android.content.Intent.ACTION_VIEW;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
            Toast toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
            toast.setText(R.string.toast_setting);
            toast.show();
        } else if (item.getItemId() == R.id.action_share) {
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String shareBody = "Learn more about the French foreign legion!\n\n" + "MyLegion" +
            "\n\nhttps://yandex.by/video/preview/10866085358551954355";
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

        showAnimation(b_youtube);
        showAnimation(b_website);
        showAnimation(b_instagram);
        showAnimation(b_recruiting);
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
    @SuppressLint("ClickableViewAccessibility")
    public void showAnimation(ImageButton button){
        //создаем обьект анимации для кнопок
        Animation scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        Animation scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);
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
}