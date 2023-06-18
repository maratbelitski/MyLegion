package com.example.frenchforeignlegion.candidate;

import static android.content.Intent.ACTION_VIEW;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.frenchforeignlegion.R;

public class InfoFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        Button b_preparation7 = view.findViewById(R.id.b_preparation7);
        Button b_preparation8 = view.findViewById(R.id.b_preparation8);
        Button b_preparation9 = view.findViewById(R.id.b_preparation9);
        Button b_preparation10 = view.findViewById(R.id.b_preparation10);
        b_preparation7.setOnClickListener(this);
        b_preparation8.setOnClickListener(this);
        b_preparation9.setOnClickListener(this);
        b_preparation10.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        String id = "";
        int temp = v.getId();

        if (temp == R.id.b_preparation7) {
            id = "https://yandex.by/video/preview/9499861491050030565 ";
        } else if (temp == R.id.b_preparation8) {
            id = "https://www.youtube.com/watch?v=BiTJPArBY4g&list=PLEF03FB2C2C122A9E&index=7&ab_channel=L%C3%A9gion%C3%A9trang%C3%A8re";
        } else if (temp == R.id.b_preparation9) {
            id = "https://www.youtube.com/watch?v=9H-YzwU0TvM&list=PLEF03FB2C2C122A9E&index=11&ab_channel=L%C3%A9gion%C3%A9trang%C3%A8re ";
        } else if (temp == R.id.b_preparation10) {
            id = "https://yandex.by/video/preview/10866085358551954355";
        }
        Intent intent = new Intent(ACTION_VIEW, Uri.parse(id));
        startActivity(intent);
    }
}