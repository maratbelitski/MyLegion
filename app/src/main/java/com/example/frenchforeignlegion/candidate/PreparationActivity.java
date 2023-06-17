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

public class PreparationActivity extends AppCompatActivity {

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
    }


    public void showLink(View v) {
        String id = "";
        int temp = v.getId();

        if (temp == R.id.b_preparation) {
            id = "https://www.youtube.com/watch?v=DFcorrzmcEE&t=233s&ab_channel=InvestigationsetEnqu%C3%AAtes";
        } else if (temp == R.id.b_preparation2) {
            id = "https://www.youtube.com/watch?v=riTvwqoJR2s&list=PLXWwK0BIfm23hMEdqko036s-zDr6lZeKz&ab_channel=L%C3%A9gion%C3%A9trang%C3%A8re";
        } else if (temp == R.id.b_preparation3) {
            id = "https://yandex.by/video/preview/7176945764766152846";
        }else if (temp == R.id.b_preparation4) {
            id = "https://yandex.by/video/preview/17914772488282979200";
        } else if (temp == R.id.b_preparation5) {
            id = "https://www.assessmentday.co.uk/aptitudetests_logical.htm";
        }else if (temp == R.id.b_preparation6) {
            id = "https://www.123test.com/spatial-reasoning-test/ ";
        }else if (temp == R.id.b_preparation7) {
            id = "https://yandex.by/video/preview/9499861491050030565 ";
        }else if (temp == R.id.b_preparation8) {
            id = "https://www.youtube.com/watch?v=BiTJPArBY4g&list=PLEF03FB2C2C122A9E&index=7&ab_channel=L%C3%A9gion%C3%A9trang%C3%A8re";
        } else if (temp == R.id.b_preparation9) {
            id = "https://www.youtube.com/watch?v=9H-YzwU0TvM&list=PLEF03FB2C2C122A9E&index=11&ab_channel=L%C3%A9gion%C3%A9trang%C3%A8re ";
        }else if (temp == R.id.b_preparation10) {
            id = "https://yandex.by/video/preview/10866085358551954355";
        }
        Intent intent = new Intent(ACTION_VIEW, Uri.parse(id));
        startActivity(intent);
    }
}