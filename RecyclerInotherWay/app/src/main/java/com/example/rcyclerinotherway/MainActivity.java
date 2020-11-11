package com.example.rcyclerinotherway;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemOnClickListener {

    private static final int REQUEST_CODE = 2;
    public static final String KEY_TO_EDIT_NAME = "keyEditN";
    public static final String KEY_EDIT_PHONE = "keyEditP";
    public static final String IMAGE_EDIT = "keyEditI";
    private static final int CODE_TO_EDIT = 1;

    private RecyclerView recyclerView;
    private ArrayList<TitleModel> list;
    private MyAdapter adapter;
    private Button buttonAdd;
    private TitleModel titleModel;

    private int itemPosition;//to give position in --replaceItem-- method!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReadyAll();
    }

    private void getReadyAll() {
        recyclerView = findViewById(R.id.recyclerView);
        buttonAdd = findViewById(R.id.btnMain);
        list = new ArrayList<>();
        adapter = new MyAdapter(list, this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ApplicationActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            titleModel = (TitleModel) data.getSerializableExtra(ApplicationActivity.KEY);
            adapter.addApplication(titleModel);
        }
        if (requestCode == CODE_TO_EDIT && resultCode == RESULT_OK) {
            titleModel = (TitleModel) data.getSerializableExtra(EditActivity.KEY_EDITED);
            adapter.replaceItem(titleModel,itemPosition);
        }
    }
    @Override
    public void clickListener(int position) {
        this.itemPosition = position;
        Intent intent = new Intent(MainActivity.this, EditActivity.class);
        intent.putExtra(KEY_TO_EDIT_NAME, titleModel.getName());
        intent.putExtra(KEY_EDIT_PHONE, titleModel.getPhoneNumber());
        intent.putExtra(IMAGE_EDIT, titleModel.getImage());
        startActivityForResult(intent, CODE_TO_EDIT);
    }
}