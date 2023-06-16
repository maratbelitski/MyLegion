package com.example.frenchforeignlegion.candidate;

import static android.content.Intent.ACTION_VIEW;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.frenchforeignlegion.R;

public class PreparationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparation);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.toolbar_preparation);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button b_preparation = findViewById(R.id.b_preparation);
        Button b_preparation2 = findViewById(R.id.b_preparation2);
        Button b_preparation3 = findViewById(R.id.b_preparation3);
        b_preparation.setOnClickListener(this);
        b_preparation2.setOnClickListener(this);
        b_preparation3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String id = "";
        int temp = v.getId();

        if (temp == R.id.b_preparation) {
            id = "https://www.youtube.com/watch?v=DFcorrzmcEE&t=233s&ab_channel=InvestigationsetEnqu%C3%AAtes";
        } else if (temp == R.id.b_preparation2) {
            id = "https://www.youtube.com/watch?v=riTvwqoJR2s&list=PLXWwK0BIfm23hMEdqko036s-zDr6lZeKz&ab_channel=L%C3%A9gion%C3%A9trang%C3%A8re";
        } else if (temp == R.id.b_preparation3) {
            id = "https://yandex.by/video/preview/7176945764766152846";
        }
        Intent intent = new Intent(ACTION_VIEW, Uri.parse(id));
        startActivity(intent);
    }
}