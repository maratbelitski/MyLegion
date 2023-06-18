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

public class PossibilityFragment extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_possibility, container, false);

        Button b_centers = view.findViewById(R.id.b_possibility);
        b_centers.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=IN9rYoongMY&ab_channel=L%C3%A9gion%C3%A9trang%C3%A8re"));
        startActivity(intent);
    }
}