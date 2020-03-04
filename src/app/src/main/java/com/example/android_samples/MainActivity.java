package com.example.android_samples;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.example.android_samples.data.network.RetrofitApi;
import com.example.android_samples.models.Country;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private Context mContext = this;

    public void showCountries(View view) {
        RetrofitApi retrofitApi = RetrofitApi.getInstance();

        retrofitApi.getCountryByName("united").enqueue(new Callback<Country[]>() {
            @Override
            public void onResponse(Call<Country[]> call, Response<Country[]> response) {
                if (response.isSuccessful()) {
                    for (Country country : response.body()) {
                        String name = country.getName();
                        Toast.makeText(mContext, name, Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Country[]> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}