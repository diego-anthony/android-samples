package com.example.android_samples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent  intent = new Intent()
                        .setClass(mContext, MainActivity.class);
                startActivity(intent);
                
                finish();
            }
        };
    }
}
