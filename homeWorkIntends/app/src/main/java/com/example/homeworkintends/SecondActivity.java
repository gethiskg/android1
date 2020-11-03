package com.example.homeworkintends;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class SecondActivity extends AppCompatActivity {
    public static final String KEY_FOR_INPUT = "key";
    public static final String KEY_FOR_IMAGE = "image";
    ImageView imageView;
    Button buttonSave;
    EditText textToMail;
    String  selectedImage;

    private static final int PICTURE_SELECTED = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        iconListener();
        buttonSand();


    }


    private void iconListener() {
        buttonSave = findViewById(R.id.buttonSecond);
        ImageView addIcon = findViewById(R.id.addIcon);
        imageView = findViewById(R.id.imageSecondActivity);


        addIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent.createChooser(intent, "select an image"), PICTURE_SELECTED);
            }
        });
    }


    private void buttonSand() {
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSender = new Intent(SecondActivity.this,MainActivity.class);
                textToMail = findViewById(R.id.editTextSecondPage);
                String valueOfEditText = textToMail.getText().toString();
                intentSender.putExtra(KEY_FOR_INPUT, valueOfEditText);
                intentSender.putExtra(KEY_FOR_IMAGE, selectedImage);
                startActivity(intentSender);
                finish();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICTURE_SELECTED && resultCode == RESULT_OK && null != data) {
                selectedImage = data.getDataString();
                imageView.setImageURI(Uri.parse(selectedImage));
        }else if (resultCode == RESULT_CANCELED && requestCode == PICTURE_SELECTED){
            Toast.makeText(SecondActivity.this,"you haven't picked any image",Toast.LENGTH_SHORT).show();
        }


    }


}