package com.example.android_samples.services;

import com.example.android_samples.models.Country;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ICountryService {
    @GET("name/{name}")
    Obser<Country[]> getCountryByName(@Path("name") String name);
}
