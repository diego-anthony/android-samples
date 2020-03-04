package com.example.android_samples.services;

import com.example.android_samples.models.Country;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ICountryService {
    @GET("name/{name}")
    Observable<Country[]> getCountryByName(@Path("name") String name);
}