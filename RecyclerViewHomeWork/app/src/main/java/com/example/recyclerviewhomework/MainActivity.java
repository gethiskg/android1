package com.example.recyclerviewhomework;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String INSTATE_POSITION = "keyPosition";
    private RecyclerView recyclerView;
    private ArrayList<UserInfo> list;/* just changed from List to ArrayList it works with the implantation of Parcelable method */
    private MyAdapter myAdapter;
    Button btnSave;
    EditText editText;
    private static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editInput);
        btnSave = findViewById(R.id.btnSave);
        getReady();

    }

    private void getReady() {
        recyclerView = findViewById(R.id.parentRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(list, this);
        recyclerView.setAdapter(myAdapter);
        buttonAction();
    }

    private void buttonAction() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(new UserInfo(editText.getText().toString()));
                myAdapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(INSTATE_POSITION,list);
        Log.d(TAG, "onSaveInstanceState: " + list.toString());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        list.addAll(savedInstanceState.getParcelableArrayList(INSTATE_POSITION));
        Log.d(TAG, "onRestoreInstanceState: "+ savedInstanceState.getParcelableArrayList(INSTATE_POSITION));
    }
}