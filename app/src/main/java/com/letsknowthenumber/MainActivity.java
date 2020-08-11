package com.letsknowthenumber;

import Manager.PreferencesManager;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    public PreferencesManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        prefManager = new PreferencesManager(getApplicationContext());

        //region AdView
        MobileAds.initialize(this, "ca-app-pub-1077976104717606/1453906727");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //endregion

    }

    public void catchUp(View v) {
        EditText edtUserName = (EditText) findViewById(R.id.textInputUserName);
        prefManager.setUserName(edtUserName.getText().toString());

        Log.d("PrefMan-UserName", prefManager.getUserName());
        startActivity(new Intent(MainActivity.this, GuessActivity.class));
    }
}