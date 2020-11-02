package com.example.lifecycleh_w_less2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.file.Watchable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText firstNumber;
    EditText secondNumber;
    EditText thirdNumber;
    Button btnToCalculate;
    TextView headerText,textResult;
    /*to restore values*/
    int firstValue;
    int secondValue;
    int thirdValue;
    int result;
    private String KEY_PUT = "finally";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNumber = findViewById(R.id.editFirst_Text);
        secondNumber = findViewById(R.id.editSecond_Text);
        thirdNumber = findViewById(R.id.editThird_Text);
        btnToCalculate = findViewById(R.id.btn_calculate);
        headerText = findViewById(R.id.headerMain);
        textResult = findViewById(R.id.result_text);


        buttonClick();


    }

    private void buttonClick() {
        btnToCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstValue = Integer.parseInt(firstNumber.getText().toString());
                secondValue = Integer.parseInt(secondNumber.getText().toString());
                thirdValue = Integer.parseInt(thirdNumber.getText().toString());
                result = firstValue+ (secondValue/thirdValue);
                textResult.setText(""+result);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_PUT,result);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textResult.setText(""+savedInstanceState.getInt(KEY_PUT));

    }
}