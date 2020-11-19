package com.example.fragment;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ApplicationActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    public static final String KEY = "key";
    public static final String KEY2 = "key2";
    public static final String KEY3 = "key3";
    private ImageView imageView;
    private EditText etName, etPhone;
    private Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        init();
    }

    private void init() {
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        btnSave = findViewById(R.id.button1);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ApplicationActivity.this,MainActivity.class);
                intent.putExtra(KEY,etName.getText().toString());
                intent.putExtra(KEY2,etPhone.getText().toString());
                intent.putExtra(KEY3,R.drawable.ic_account);
                startActivity(intent);


            }
        });
    }

}