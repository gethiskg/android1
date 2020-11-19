package com.example.fragment;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;

public class DetailsActivity extends AppCompatActivity {
    private String title;
    private String desc;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        if (intent != null){
            title = intent.getStringExtra(MainActivity.KEY_GET);
            desc = intent.getStringExtra(MainActivity.KEY_DESC);
        }
        fragmentManager = getSupportFragmentManager();
        TextFragment fragment = (TextFragment) fragmentManager.findFragmentById(R.id.fragmentText);
        transaction = fragmentManager.beginTransaction();
        fragment.displayDetails(title,desc);
        transaction.commit();

//        fragmentManager = getSupportFragmentManager();
//        ChangeFragment changeFragment = (ChangeFragment) fragmentManager.findFragmentById(R.id.changeFragment);
//        changeFragment.onDisplayDetails(title,desc);
//        transaction.commit();
    }
}