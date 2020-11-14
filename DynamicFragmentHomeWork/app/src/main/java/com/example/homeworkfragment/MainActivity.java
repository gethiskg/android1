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

    /*all for recycler view*/
    private RecyclerView recyclerView;
    private ArrayList<String > list;
    private MyAdapter myAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    initialization();
    onClickOperations();

    }

    private void initialization() {
        openWindow = findViewById(R.id.toGetDynamicFragment);
        recyclerView = findViewById(R.id.recyclerInFragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(list,this);
        recyclerView.setAdapter(myAdapter);

    }

    private void onClickOperations() {
        openWindow.setOnClickListener(v -> {
            fragmentManager = getSupportFragmentManager();
            DynamicFragment dynamicFragment = new DynamicFragment();
            transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.frameFrag, dynamicFragment);
            transaction.commit();
            openWindow.setVisibility(View.INVISIBLE);

        });
    }

    @Override
    public void clickTextTransporter(String message) {
        myAdapter.addOn(message);
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
        fragmentRecycler = (FragmentRecycler) getSupportFragmentManager().findFragmentById(R.id.recyclerFrag);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.hide(fragmentRecycler);
        transaction.commit();
    }
}