package com.example.frenchforeignlegion;
import static android.content.Intent.ACTION_VIEW;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.frenchforeignlegion.candidate.CandidateActivity;
import com.example.frenchforeignlegion.history.HistoryActivity;
import com.example.frenchforeignlegion.today.Regiments;
import com.example.frenchforeignlegion.today.RegimentsActivity;
import com.example.frenchforeignlegion.today.RegimentsDetailsActivity;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
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

//        ImageButton b_youtube = findViewById(R.id.b_youtube);
//        ImageButton b_website = findViewById(R.id.b_website);
//        ImageButton b_instagram = findViewById(R.id.b_instagram);

        //создаем обьект анимации для кнопок
        Animation scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        Animation scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        List<String> languages = Arrays.asList(getResources().getStringArray(R.array.languages));
        ArrayAdapter<String> mAdapter = new ArrayAdapter<>(this, R.layout.layout_spinner, R.id.spinner_text,languages);
        spinner.setAdapter(mAdapter);

        //элемент спиннера меняет язык
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = spinner.getSelectedItem().toString();
                if (selectedItem.equalsIgnoreCase("анг")) {
                    changeLanguage("en");
                } else if (selectedItem.equalsIgnoreCase("rus")) {
                    changeLanguage("ru");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        //обрабатываем щелчек для анимации
        b_settings.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    b_settings.startAnimation(scaleUp);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    b_settings.startAnimation(scaleDown);
                }
                //если будет true onClick не сработает
                return false;
            }
        });

        b_history.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    b_history.startAnimation(scaleUp);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    b_history.startAnimation(scaleDown);
                }
                //если будет true onClick не сработает
                return false;
            }
        });

        b_regiment_today.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    b_regiment_today.startAnimation(scaleUp);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    b_regiment_today.startAnimation(scaleDown);
                }
                return false;
            }
        });

        b_candidate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    b_candidate.startAnimation(scaleUp);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    b_candidate.startAnimation(scaleDown);
                }
                return false;
            }
        });
//
//        b_youtube.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    b_youtube.startAnimation(scaleUp);
//                } else if (event.getAction() == MotionEvent.ACTION_UP) {
//                    b_youtube.startAnimation(scaleDown);
//                }
//                return false;
//            }
//        });
//
//        b_website.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    b_website.startAnimation(scaleUp);
//                } else if (event.getAction() == MotionEvent.ACTION_UP) {
//                    b_website.startAnimation(scaleDown);
//                }
//                return false;
//            }
//        });
//
//        b_instagram.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    b_instagram.startAnimation(scaleUp);
//                } else if (event.getAction() == MotionEvent.ACTION_UP) {
//                    b_instagram.startAnimation(scaleDown);
//                }
//                return false;
//            }
//        });
    }


//    public void showHistory(View view) {
//        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
//        startActivity(intent);
//    }
//
//    public void showRegiments(View view) {
//        Intent intent = new Intent(MainActivity.this, RegimentsActivity.class);
//        startActivity(intent);
//    }
//
//    public void showCandidate(View view) {
//        Intent intent = new Intent(MainActivity.this, CandidateActivity.class);
//        startActivity(intent);
//    }

    //открываем сайт и соцсети
//    public void showWebsite(View view) {
//        Intent intent = new Intent(ACTION_VIEW, Uri.parse("https://www.legion-etrangere.com/"));
//        startActivity(intent);
//    }
//
//    public void showInstagram(View view) {
//        Intent intent = new Intent(ACTION_VIEW, Uri.parse("https://www.instagram.com/legionetrangereofficiel/"));
//        startActivity(intent);
//    }
//
//    public void showYouTube(View view) {
//        Intent intent = new Intent(ACTION_VIEW, Uri.parse("https://www.youtube.com/user/LegionEtrangereCOMLE"));
//        startActivity(intent);
//    }

   /**
    * метод для смены языка
    * */
    public void changeLanguage(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        this.setContentView(R.layout.activity_main);
        recreate();
    }

    public void showButtonAction(View view) {
       Class destinations = null;
        int temp = view.getId();
        if(temp==R.id.b_settings){
            destinations= SettingsActivity.class;
        }else if (temp == R.id.b_history){
            destinations = HistoryActivity.class;
        }else if (temp == R.id.b_regiment_today){
            destinations = RegimentsActivity.class;
        }else if (temp == R.id.b_candidate){
            destinations = CandidateActivity.class;
        }
        Intent intent = new Intent(this, destinations);
        startActivity(intent);
    }
}