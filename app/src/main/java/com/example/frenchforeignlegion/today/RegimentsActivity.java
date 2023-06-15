package com.example.frenchforeignlegion.today;

import static com.example.frenchforeignlegion.R.layout.layout_list;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.frenchforeignlegion.R;

import java.util.Arrays;
import java.util.List;

public class RegimentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiments);

        //применение активностью созданного тулл бара
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.toolbar_legion_today);

        //кнопка назад в тулл баре
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
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