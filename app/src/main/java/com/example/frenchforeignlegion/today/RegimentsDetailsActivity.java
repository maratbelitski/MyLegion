package com.example.frenchforeignlegion.today;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.frenchforeignlegion.R;
public class RegimentsDetailsActivity extends AppCompatActivity {
    public static final String EXTRA_REGIMENT = "ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiments_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.toolbar_legion_regiments);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        //ссылки на необходимые элементы для макета выводятся сразу с активностью
        int regimentId = (int) getIntent().getExtras().get(EXTRA_REGIMENT);
        Regiments regimentNew = Regiments.regiments[regimentId];

        TextView name = findViewById(R.id.regiment_title);
        name.setText(regimentNew.getNameID());

        TextView description = findViewById(R.id.regiment_description);
        description.setText(regimentNew.getDescriptionID());

        ImageView logo = findViewById(R.id.regiment_logo);
        logo.setImageResource(regimentNew.getImageID());

        ImageView header = findViewById(R.id.regiment_header);
        header.setImageResource(regimentNew.getImageHeader());
    }
}