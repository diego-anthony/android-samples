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

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
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

        List<Observable<?>> requests = new ArrayList<>();

        RetrofitApi retrofitApi = RetrofitApi.getInstance();

        Observable<Country[]> countriesObservable = retrofitApi.getCountryByName("united");
        Observable<Country[]> countries2Observable = retrofitApi.getCountryByName("Quechua");

//        requests.add(countries1Observable);
        requests.add(countries2Observable);

//        Observable.zip(requests,
//                new Function<Object[], Object>() {
//                    @Override
//                    public Object apply(Object[] objects) throws Exception {
//                        return new Object();
//                    }
//                })
//                .subscribe(new Consumer<Object>() {
//                    @Override
//                    public void accept(Object o) throws Exception {
//                        Log.d("accept: o", "accept: o");
//                    }
//                });

        countriesObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Country[]>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Toast.makeText(mContext,"Subscribe",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(Country[] value) {
                        Toast.makeText(mContext,"onNext",Toast.LENGTH_SHORT).show();
                        if(value != null && value.length > 0){
                            for (Country country : value) {
                                String name = country.getName();
                                Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext,"onError",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(mContext,"onComplete",Toast.LENGTH_SHORT).show();
                    }
                });

//        retrofitApi.getCountryByName("united").enqueue(new Callback<Country[]>() {
//            @Override
//            public void onResponse(Call<Country[]> call, Response<Country[]> response) {
//                if (response.isSuccessful()) {
//                    for (Country country : response.body()) {
//                        String name = country.getName();
//                        Toast.makeText(mContext, name, Toast.LENGTH_LONG).show();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Country[]> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });


    }
}