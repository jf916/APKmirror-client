package com.j.apkmirror_client;

import static java.security.AccessController.getContext;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "https://apkmirror.com"; // Replace with your desired URL
        CustomTabsIntent intent = new CustomTabsIntent.Builder()
                .build();
        try {
            intent.launchUrl(MainActivity.this, Uri.parse(url));
        } catch (ActivityNotFoundException e) {
            // Define what your app should do if no activity can handle the intent.
            CharSequence text = "No Web Browser is installed";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this /* MyActivity */, text, duration);
            toast.show();
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        }
    }
}