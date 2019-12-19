package com.example.android_samples;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private FragmentPagerAdapter mFragmentPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.viewPager);

        List<Fragment> fragments = getFragments();
        mFragmentPagerAdapter = new ItemFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(mFragmentPagerAdapter);
    }

    private List<Fragment> getFragments(){
        List<Fragment> fragments = new ArrayList<>();
        ItemFragment fragment = new ItemFragment();
        ItemFragment fragment2 = new ItemFragment();
        fragments.add(fragment);
        fragments.add(fragment2);
        return fragments;
    }
}
