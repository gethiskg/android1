package com.example.homeworkintends;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_TAG = "otherOne";
    public static final int REQUEST_CODE = 1;
    ImageView imageView;
    TextView textView;
    Button buttonImage, buttonGmail;
    String imageString, textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionsOnBtn();


    }


    private void actionsOnBtn() {
        buttonImage = findViewById(R.id.btnPickImage);
        buttonGmail = findViewById(R.id.btnGmail);
        imageView = findViewById(R.id.imageInMain);
        textView = findViewById(R.id.textView);
        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });

        buttonGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setData(Uri.parse("mailto:"));
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_EMAIL, "oneOone@gmail.com");
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, "taking a time, it's 02:10 am");
                sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
                startActivity(sendIntent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            imageString = data.getStringExtra(SecondActivity.KEY_FOR_IMAGE);
            textMessage = data.getStringExtra(SecondActivity.KEY_FOR_INPUT);
            textView.setText(textMessage);
            imageView.setImageURI(Uri.parse(imageString));
        }

    }
}