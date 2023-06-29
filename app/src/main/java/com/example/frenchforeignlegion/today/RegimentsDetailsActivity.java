package com.example.frenchforeignlegion.today;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.frenchforeignlegion.R;
import com.example.frenchforeignlegion.SettingsActivity;

public class RegimentsDetailsActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.action_back){
            Intent intent=new Intent(this, RegimentsActivity.class);
            startActivity(intent);
        } else if (item.getItemId()==R.id.action_info) {
            Intent intent=new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
        else if (item.getItemId()==R.id.action_share) {
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String shareBody = "Learn more about the French foreign legion!\n\n" + "MyLegion" +
            "\n\nhttps://play.google.com/store/apps/details?id=com.frenchforeignlegion";
            String shareSub = "Your subject";
            myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
            myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(myIntent, "Share using"));
        }
        return super.onOptionsItemSelected(item);
    }

    public static final String EXTRA_REGIMENT = "ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiments_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.toolbar_legion_regiments);

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