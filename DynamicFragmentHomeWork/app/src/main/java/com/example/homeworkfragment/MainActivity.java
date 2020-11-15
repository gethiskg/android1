package com.example.homeworkfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FragmentClicker {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment fragment;
    private FragmentRecycler fragmentRecycler;
    private Button openWindow;
    private MyAdapter myAdapter;
    private MessageCarrier listener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    initialization();
    onClickOperations();

    }

    private void initialization() {
        fragmentRecycler = (FragmentRecycler) getSupportFragmentManager().findFragmentById(R.id.recyclerFrag);
        openWindow = findViewById(R.id.toGetDynamicFragment);
        listener = fragmentRecycler;
    }


    private void onClickOperations() {
        openWindow.setOnClickListener(v -> {
            fragmentManager = getSupportFragmentManager();
            DynamicFragment dynamicFragment = new DynamicFragment();
            transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.frameFrag, dynamicFragment);
            transaction.commit();
            transaction.addToBackStack(null);
            openWindow.setVisibility(View.INVISIBLE);
        });

    }

    @Override
    public void clickTextTransporter(String message) {
        listener.getMessage(message);
    }

    @Override
    public void clickShowFragment() {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.show(fragmentRecycler);
        transaction.commit();
    }

    @Override
    public void clickHideFragment() {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.hide(fragmentRecycler);
        transaction.commit();
    }
}