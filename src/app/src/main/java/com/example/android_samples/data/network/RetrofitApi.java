package com.example.android_samples.data.network;

import androidx.annotation.NonNull;

import com.example.android_samples.models.Country;
import com.example.android_samples.services.ICountryService;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {
    private static final String BASE_URL = "https://restcountries.eu/rest/v2/";

    private static RetrofitApi instance = new RetrofitApi();
    private final ICountryService mCountryService;

    private RetrofitApi() {
        mCountryService = createAdapter().create(ICountryService.class);
    }

    public static RetrofitApi getInstance() {
        return instance;
    }

    @NonNull
    private Retrofit createAdapter() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public Call<Country[]> getCountryByName(String name) {
        return mCountryService.getCountryByName(name);
    }
}