package com.example.frenchforeignlegion;
import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatCallback;

/**
 * @author Belitski Marat
 * @date 02.07.2023
 */
public interface MenuMethods extends AppCompatCallback {
    default void showMenu(MenuItem item, Activity activityThis,Class activityTo){

        if (item.getItemId() == R.id.action_back) {
            Intent intent = new Intent(activityThis, activityTo);
            activityThis.startActivity(intent);
        } else if (item.getItemId() == R.id.action_info) {
            Intent intent = new Intent(activityThis, SettingsActivity.class);
            activityThis.startActivity(intent);
        } else if (item.getItemId() == R.id.action_share) {
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String shareBody = "Learn more about the French foreign legion!\n\n" + "MyLegion" +
                    "\n\nhttps://play.google.com/store/apps/details?id=com.frenchforeignlegion";
            String shareSub = "Your subject";
            myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
            myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            activityThis.startActivity(Intent.createChooser(myIntent, "Share using"));
        }
    }
}
