package com.example.dayonehomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView successImage;
    EditText editEmail;
    EditText editPassword;
    TextView textQuestion;
    Button logBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSing();
    }

    private void initSing() {
        imageView = findViewById(R.id.faceIcon);
        successImage= findViewById(R.id.successImage);
        editEmail = findViewById(R.id.username);
        editPassword = findViewById(R.id.userPassword);
        textQuestion = findViewById(R.id.lastText);
        logBtn = findViewById(R.id.logInBtn);
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editEmail.getText() != null && editPassword.length() > 6){
                    successImage.setImageResource(R.drawable.images);
                    textQuestion.setText("Welcome to IT");
                    successImage.setVisibility(View.VISIBLE);
                }else{
                    textQuestion.setText("please ensure that your username and password are correct !");
                    successImage.setVisibility(View.GONE);
                }
            }
        });
    }
}