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
import com.example.frenchforeignlegion.R;
import com.example.frenchforeignlegion.SettingsActivity;

public class RegimentsActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.action_back){
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (item.getItemId()==R.id.action_info) {
            Intent intent=new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
        else if (item.getItemId()==R.id.action_share) {
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String shareBody = String.valueOf(R.string.link_text);
            String shareSub = "Your subject";
            myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
            myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(myIntent, "Share using"));
        }
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

        //выводит список обьектов по именам из класса Regiments
        //можно использовать array strings для хранения списка названий и вставлять напрямую в макет
        //А можно забирать названия из массива, здесь список добавлен напрямую в макет.

        //создаем список из значений в строковом ресурсе и применяем свой адаптер и макет
//        List<String> regiments = Arrays.asList(getResources().getStringArray(R.array.names_regiments));
//
//        ArrayAdapter<String> mAdapter = new ArrayAdapter<>(this, R.layout.layout_list, R.id.list_text, regiments);
//        ListView listView = findViewById(R.id.list_regiments);
//        listView.setAdapter(mAdapter);

        //открываем нажатием другую активность
//        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {
//                Intent intent = new Intent(RegimentsActivity.this, RegimentsDetailsActivity.class);
//                intent.putExtra(RegimentsDetailsActivity.EXTRA_REGIMENT, (int) id);
//                startActivity(intent);
//            }
//        };
//        listView.setOnItemClickListener(itemClickListener);
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