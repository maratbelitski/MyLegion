package com.example.frenchforeignlegion.candidate;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.example.frenchforeignlegion.R;
import com.example.frenchforeignlegion.SettingsActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

//шаг 1 имплементируем от TabLayoutMediator.TabConfigurationStrategy для табов
public class OfficiallyActivity extends AppCompatActivity implements TabLayoutMediator.TabConfigurationStrategy {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.action_back){
            Intent intent=new Intent(this, CandidateActivity.class);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officially);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.toolbar_officially);

        //шаг 3 создаем ссылку на табы
        TabLayout tabLayout = findViewById(R.id.tabs);

        // шаг 4 обновленный FragmentStateAdapter для swip страниц, соединяем ViewPager  с кодом
        FragmentStateAdapter pageAdapter = new SelectionsPagerAdapter(this);
        ViewPager2 viewPager2 = findViewById(R.id.pager);
        viewPager2.setAdapter(pageAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, (TabLayoutMediator.TabConfigurationStrategy) this).attach();
    }

    //задаем имена табов
    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        switch (position) {
            case 0:
                tab.setText(R.string.possibility_tab);
                return;
            case 1:
                tab.setText(R.string.conditions_tab);
                return;
            case 2:
                tab.setText(R.string.centers_tab);
        }
    }

    // шаг 2 вспомогательный класс для внесения фрагментов
    public  static class SelectionsPagerAdapter extends FragmentStateAdapter{

        public SelectionsPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
            case 0:
            return new PossibilityFragment();
            case 1:
            return new ConditionsFragment();
            case 2:
            return new CentersFragment();
        }
            return null;
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}