package com.example.frenchforeignlegion;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.frenchforeignlegion.candidate.CandidateActivity;
import com.example.frenchforeignlegion.history.HistoryActivity;
import com.example.frenchforeignlegion.today.RegimentsActivity;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements ButtonsAnimation{
    @SuppressLint({"ClickableViewAccessibility", "ResourceAsColor", "ResourceType", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //создаем обьект кнопки
        Spinner spinner = findViewById(R.id.s_spinner);
        Button b_settings = findViewById(R.id.b_settings);
        Button b_history = findViewById(R.id.b_history);
        Button b_regiment_today = findViewById(R.id.b_regiment_today);
        Button b_candidate = findViewById(R.id.b_candidate);

        showAnimationButton(b_history);
        showAnimationButton(b_regiment_today);
        showAnimationButton(b_candidate);
        showAnimationButton(b_settings);

        List<String> languages = Arrays.asList(getResources().getStringArray(R.array.languages));
        ArrayAdapter<String> mAdapter = new ArrayAdapter<>(this, R.layout.layout_spinner, R.id.spinner_text, languages);
        spinner.setAdapter(mAdapter);


        //добовляем тост с уведомлением о смене языка
        Toast toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = spinner.getSelectedItem().toString();

                if (selectedItem.equalsIgnoreCase("анг")) {
                    changeLanguage("en");
                    toast.setText(R.string.toast_spinner);
                    toast.show();

                } else if (selectedItem.equalsIgnoreCase("rus")) {
                    changeLanguage("ru");
                    toast.setText(R.string.toast_spinner);
                    toast.show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    /**
     * change language
     */
    public void changeLanguage(String lang) {
        Locale locale = new Locale(lang);
        Configuration config = new Configuration();
        Locale.setDefault(locale);
        config.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        this.setContentView(R.layout.activity_main);
        recreate();
    }

    /**
     * action for buttons
     */
    public void showButtonAction(View view) {
        Class destinations = null;
        int temp = view.getId();
        if (temp == R.id.b_settings) {
            destinations = SettingsActivity.class;
        } else if (temp == R.id.b_history) {
            destinations = HistoryActivity.class;
        } else if (temp == R.id.b_regiment_today) {
            destinations = RegimentsActivity.class;
        } else if (temp == R.id.b_candidate) {
            destinations = CandidateActivity.class;
        }
        Intent intent = new Intent(this, destinations);
        startActivity(intent);
    }
}

