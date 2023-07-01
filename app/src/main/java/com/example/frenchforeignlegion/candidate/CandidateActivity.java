package com.example.frenchforeignlegion.candidate;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.frenchforeignlegion.ButtonsAnimation;
import com.example.frenchforeignlegion.MainActivity;
import com.example.frenchforeignlegion.R;
import com.example.frenchforeignlegion.SettingsActivity;

public class CandidateActivity extends AppCompatActivity implements ButtonsAnimation {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.action_back) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.action_info) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.action_share) {
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

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.toolbar_legion_candidate);

        Button b_officially = findViewById(R.id.b_officially);
        Button b_preparation = findViewById(R.id.b_preparation);
        Button b_question_answer = findViewById(R.id.b_question_answer);

        showAnimationButton(b_officially);
        showAnimationButton(b_preparation);
        showAnimationButton(b_question_answer);
    }

    public void showButtonAction(View view) {
        Class destination = null;
        int idButton = view.getId();

        if (idButton == R.id.b_question_answer) {
            destination = QuestionAnswerActivity.class;
        } else if (idButton == R.id.b_officially) {
            destination = OfficiallyActivity.class;
        } else if (idButton == R.id.b_preparation) {
            destination = PreparationActivity.class;
        }
        Intent intent = new Intent(this, destination);
        startActivity(intent);
    }
}