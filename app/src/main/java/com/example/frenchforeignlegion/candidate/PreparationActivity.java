package com.example.frenchforeignlegion.candidate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.frenchforeignlegion.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class PreparationActivity extends AppCompatActivity implements TabLayoutMediator.TabConfigurationStrategy{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparation);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.toolbar_preparation);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        //шаг 3 создаем ссылку на табы
        TabLayout tabLayout2 = findViewById(R.id.tabs2);

        // шаг 4 обновленный FragmentStateAdapter для swip страниц, соединяем ViewPager  с кодом
        FragmentStateAdapter pageAdapter2 = new SelectionsPagerAdapter2(this);
        ViewPager2 viewPager2 = findViewById(R.id.pager2);
        viewPager2.setAdapter(pageAdapter2);
        new TabLayoutMediator(tabLayout2, viewPager2, (TabLayoutMediator.TabConfigurationStrategy) this).attach();
    }


    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        switch (position) {
            case 0:
                tab.setText(R.string.info_tab);
                return;
            case 1:
                tab.setText(R.string.medicine_tab);
                return;
            case 2:
                tab.setText(R.string.sport_tab);
                return;
            case 3:
                tab.setText(R.string.tests_tab);
                return;
            case 4:
                tab.setText(R.string.language_tab);
        }
    }
    public  static class SelectionsPagerAdapter2 extends FragmentStateAdapter{

        public SelectionsPagerAdapter2(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return new InfoFragment();
                case 1:
                    return new MedicFragment();
                case 2:
                    return new SportFragment();
                case 3:
                    return new TestsFragment();
                case 4:
                    return new LanguageFragment();
            }
            return null;
        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }
}