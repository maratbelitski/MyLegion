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
public class TestsFragment extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tests, container, false);
        Button b_preparation4 = view.findViewById(R.id.b_preparation4);
        Button b_preparation5 = view.findViewById(R.id.b_preparation5);
        Button b_preparation6 = view.findViewById(R.id.b_preparation6);
        b_preparation4.setOnClickListener(this);
        b_preparation5.setOnClickListener(this);
        b_preparation6.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        String id = "";
        int temp = v.getId();

        if (temp == R.id.b_preparation4) {
            id = "https://yandex.by/video/preview/17914772488282979200";
        } else if (temp == R.id.b_preparation5) {
            id = "https://www.assessmentday.co.uk/aptitudetests_logical.htm";
        }else if (temp == R.id.b_preparation6) {
            id = "https://www.123test.com/spatial-reasoning-test/ ";
        }
        Intent intent = new Intent(ACTION_VIEW, Uri.parse(id));
        startActivity(intent);
    }
}