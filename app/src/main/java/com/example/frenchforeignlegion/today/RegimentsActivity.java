package com.example.frenchforeignlegion.today;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.frenchforeignlegion.MainActivity;
import com.example.frenchforeignlegion.MenuMethods;
import com.example.frenchforeignlegion.R;

public class RegimentsActivity extends AppCompatActivity implements MenuMethods {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiments);

        //применение активностью созданного тулл бара
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.toolbar_legion_today);
    }

    public void showRegimentDetails(View view) {
        int id = -1;
        int t = view.getId();

        if (t == R.id.b_list_choice_0) {
            id = 0;
        } else if (t == R.id.b_list_choice_1) {
            id = 1;
        } else if (t == R.id.b_list_choice_2) {
            id = 2;
        } else if (t == R.id.b_list_choice_3) {
            id = 3;
        } else if (t == R.id.b_list_choice_4) {
            id = 4;
        } else if (t == R.id.b_list_choice_5) {
            id = 5;
        } else if (t == R.id.b_list_choice_6) {
            id = 6;
        } else if (t == R.id.b_list_choice_7) {
            id = 7;
        } else if (t == R.id.b_list_choice_8) {
            id = 8;
        } else if (t == R.id.b_list_choice_9) {
            id = 9;
        } else if (t == R.id.b_list_choice_10) {
            id = 10;
        }
        Intent intent = new Intent(RegimentsActivity.this, RegimentsDetailsActivity.class);
        intent.putExtra(RegimentsDetailsActivity.EXTRA_REGIMENT, id);
        startActivity(intent);
    }
}