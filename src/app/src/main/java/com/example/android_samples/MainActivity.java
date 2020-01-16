package com.example.android_samples;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        t("onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        t("onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        t("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        t("onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        t("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        t("onDestroy");
    }

    private void t(String message){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }
}
