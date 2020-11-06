package com.example.practicerecyclerview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    public static final int PICKED_IMAGE_CODE = 2;
    private static final String DATA_KEY = "keyData";
    private RecyclerView recyclerView;
    private ArrayList<PersonInfo> listInf;
    private MyAdapter myAdapter;

    Button btnSave;
    EditText textInputName,textInputAge;
    ImageView iconAdd;

    /*field to save the retrieved data from activity*/
    String uriSting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReadyAll();
    }

    private void getReadyAll() {
        /*used your hint to initialize all id in one method down here . Thanks for wise advise ✊*/
        recyclerView = findViewById(R.id.recyclerView);
        btnSave = findViewById(R.id.btnGreen);
        textInputName = findViewById(R.id.editName);
        textInputAge = findViewById(R.id.editAge);
        iconAdd = findViewById(R.id.iconId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listInf = new ArrayList<>();
        myAdapter = new MyAdapter(listInf,this);
        recyclerView.setAdapter(myAdapter);

        actionsOnClick();

    }

    private void actionsOnClick() {
        /*was setOnClick to icon that can get image from gallery to add into recyclerview */
        iconAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,PICKED_IMAGE_CODE);
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*i know this if else  a lot but it prevents from the crush , if the field is empty shows the toast ))) */
                if (textInputName.getText().toString().equals("") || textInputAge.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"please provide inputs",Toast.LENGTH_SHORT).show();
                }else {
                    listInf.add(new PersonInfo(textInputName.getText().toString(), Integer.parseInt(textInputAge.getText().toString()), uriSting));
                    myAdapter.notifyDataSetChanged();
                    textInputAge.setText("");//setting the edit text to null
                    textInputName.setText("");
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICKED_IMAGE_CODE && resultCode == RESULT_OK){
            uriSting = data.getDataString();
            Log.d(TAG, "onActivityResult: "+ uriSting);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(DATA_KEY,listInf);
        Log.d(TAG, "onSaveInstanceState: "+ listInf.toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        listInf.addAll(savedInstanceState.getParcelableArrayList(DATA_KEY));
        Log.d(TAG, "onRestoreInstanceState: "+listInf.toString());
    }
}