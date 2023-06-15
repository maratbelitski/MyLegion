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
public class ConditionsFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conditions, container, false);
        Button b_conditions = view.findViewById(R.id.b_conditions);
        Button b_conditions2 = view.findViewById(R.id.b_conditions2);
        Button b_conditions3 = view.findViewById(R.id.b_conditions3);
        b_conditions.setOnClickListener(this);
        b_conditions2.setOnClickListener(this);
        b_conditions3.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        String id = "";
        int temp = v.getId();

        if(temp==R.id.b_conditions){
            id = "https://www.youtube.com/watch?v=DFcorrzmcEE&t=233s&ab_channel=InvestigationsetEnqu%C3%AAtes";
        }else if(temp==R.id.b_conditions2){
            id = "https://www.youtube.com/watch?v=riTvwqoJR2s&list=PLXWwK0BIfm23hMEdqko036s-zDr6lZeKz&ab_channel=L%C3%A9gion%C3%A9trang%C3%A8re";
        }else if(temp==R.id.b_conditions3){
            id = "https://www.youtube.com/watch?v=8eHukSbYa6U&list=PLXWwK0BIfm23hMEdqko036s-zDr6lZeKz&index=2&ab_channel=L%C3%A9gion%C3%A9trang%C3%A8re";
        }
        Intent intent = new Intent(ACTION_VIEW, Uri.parse(id));
        startActivity(intent);
    }
}