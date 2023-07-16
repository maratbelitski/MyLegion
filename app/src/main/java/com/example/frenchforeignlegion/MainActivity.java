package com.example.frenchforeignlegion;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

import com.example.frenchforeignlegion.candidate.CandidateActivity;
import com.example.frenchforeignlegion.history.HistoryActivity;
import com.example.frenchforeignlegion.practice.PracticeActivity;
import com.example.frenchforeignlegion.supporting.Languages;
import com.example.frenchforeignlegion.supporting.SpinnerAdapter;
import com.example.frenchforeignlegion.today.RegimentsActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ButtonsAnimation {

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
        Button b_practice = findViewById(R.id.b_practice);
        Button b_candidate = findViewById(R.id.b_candidate);

        showAnimationButton(b_history);
        showAnimationButton(b_regiment_today);
        showAnimationButton(b_practice);
        showAnimationButton(b_candidate);
        showAnimationButton(b_settings);

        List<Languages> languagesList = new ArrayList<>();
        String rus = getResources().getString(R.string.spinner_ru);
        String eng = getResources().getString(R.string.spinner_en);
        String def = getResources().getString(R.string.spinner_default);

        languagesList.add(new Languages(def, R.drawable.ic_language));
        languagesList.add(new Languages(eng, R.drawable.ic_usa));
        languagesList.add(new Languages(rus, R.drawable.ic_russia));
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(this, R.layout.layout_spinner, languagesList);
        spinner.setAdapter(spinnerAdapter);

        Toast toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    Languages selectedItem = (Languages) spinner.getSelectedItem();
                    String s = selectedItem.getNameLanguage();

                    if (s.equalsIgnoreCase("английский")) {
                        changeLanguage("en");
                        toast.setText("English is selected");
                        toast.show();
                    } else if (s.equalsIgnoreCase("russian")) {
                        changeLanguage("ru");
                        toast.setText("Выбран русский язык");
                        toast.show();
                    }
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
        LocaleListCompat localeListCompat = androidx.core.os.LocaleListCompat.forLanguageTags(lang);
        AppCompatDelegate.setApplicationLocales(localeListCompat);
        recreate();
    }

    /**
     * action for buttons
     */
    public void showButtonAction(View view) {
        Class<?> destinations = null;
        int temp = view.getId();
        if (temp == R.id.b_settings) {
            destinations = SettingsActivity.class;
        } else if (temp == R.id.b_history) {
            destinations = HistoryActivity.class;
        } else if (temp == R.id.b_regiment_today) {
            destinations = RegimentsActivity.class;
        } else if (temp == R.id.b_practice) {
            destinations = PracticeActivity.class;
        } else if (temp == R.id.b_candidate) {
            destinations = CandidateActivity.class;
        }
        Intent intent = new Intent(this, destinations);
        startActivity(intent);
    }
}
