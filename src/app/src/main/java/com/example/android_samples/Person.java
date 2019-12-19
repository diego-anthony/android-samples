package com.example.android_samples;

public class Person {
    private String mCode;
    private String mName;

    public Person(String code, String name) {
        this.mCode = code;
        this.mName = name;
    }

    public String getCode(){
        return mCode;
    }

    public String getName(){
        return mName;
    }
}
