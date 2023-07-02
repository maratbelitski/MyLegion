package com.example.frenchforeignlegion.history;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.frenchforeignlegion.ButtonsAnimation;
import com.example.frenchforeignlegion.MainActivity;
import com.example.frenchforeignlegion.MenuMethods;
import com.example.frenchforeignlegion.R;

public class HistoryActivity extends AppCompatActivity implements ButtonsAnimation, MenuMethods {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        showMenu(item,this,MainActivity.class);

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint({"ClickableViewAccessibility", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.toolbar_history);

        Button b_history_creation=findViewById(R.id.b_history_creation);
        Button b_war=findViewById(R.id.b_war);
        Button b_tradition=findViewById(R.id.b_tradition);

       showAnimationButton(b_history_creation);
       showAnimationButton(b_war);
       showAnimationButton(b_tradition);
    }

    public void showButtonAction(View view) {
        Class destinations = null;
        int temp = view.getId();
        if (temp == R.id.b_history_creation) {
            destinations = HistoryCreateActivity.class;
        } else if (temp == R.id.b_war) {
            destinations = WarActivity.class;
        } else if (temp == R.id.b_tradition) {
            destinations = TraditionActivity.class;
        }
        Intent intent = new Intent(this, destinations);
        startActivity(intent);
    }
}