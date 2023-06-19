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

public class SportFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sport, container, false);
        Button b_preparation = view.findViewById(R.id.b_preparation);
        Button b_preparation2 = view.findViewById(R.id.b_preparation2);
        Button b_preparation3 = view.findViewById(R.id.b_preparation3);
        b_preparation.setOnClickListener(this);
        b_preparation2.setOnClickListener(this);
        b_preparation3.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        String id = "";
        int temp = v.getId();

        if (temp == R.id.b_preparation) {
            id = "https://www.youtube.com/watch?v=8eHukSbYa6U&list=PLXWwK0BIfm23hMEdqko036s-zDr6lZeKz&index=2&ab_channel=L%C3%A9gion%C3%A9trang%C3%A8re";
        } else if (temp == R.id.b_preparation2) {
            id = "https://www.youtube.com/watch?v=riTvwqoJR2s&list=PLXWwK0BIfm23hMEdqko036s-zDr6lZeKz&ab_channel=L%C3%A9gion%C3%A9trang%C3%A8re";
        } else if (temp == R.id.b_preparation3) {
            id = "https://yandex.by/video/preview/7176945764766152846";
        }
        Intent intent = new Intent(ACTION_VIEW, Uri.parse(id));
        startActivity(intent);
    }
}