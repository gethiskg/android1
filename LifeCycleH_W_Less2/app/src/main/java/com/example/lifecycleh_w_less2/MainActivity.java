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
    TextView headerText;

    /*variables to assign values from the user input */
    private int firstInputValue;
    private int firstInputValueB;//to put restored value
    private int secondInputValue;
    private int secondInputValueB;//to put restored value
    private int thirdInputValue;
    private int thirdInputValueB;//to put restored value


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNumber = findViewById(R.id.editFirst_Text);
        secondNumber = findViewById(R.id.editSecond_Text);
        thirdNumber = findViewById(R.id.editThird_Text);
        btnToCalculate = findViewById(R.id.btn_calculate);
        headerText = findViewById(R.id.headerMain);

        /*method to save and restore the inputs of users*/
        initRestore();
        onClickBtn();
    }
/*  methods onClick the buttons and will calculate the numbers in following order plus and divide*/
    private void onClickBtn() {
        btnToCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                    if (firstInputValue != 0 && secondInputValueB != 0 && thirdInputValueB != 0 ) {
                        int result = firstInputValueB + (secondInputValueB / thirdInputValueB);
                        headerText.setText("your numbers result " + result);
                        headerText.setTextColor(Color.BLUE);
                    }else {
                        Toast.makeText(MainActivity.this,"Please type number ", Toast.LENGTH_SHORT).show();
                    }
                }else {
//                answerText.setText("the result of your inputs : " +firstInputValueB+ " + "+ " ( "+ secondInputValueB+" / "+ thirdInputValueB + " ) = "+ result);
                    Toast.makeText(MainActivity.this, "Turn out your phone to see the answer", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void initRestore() {
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (firstNumber.getEditableText() == s) {
                        firstInputValue = Integer.parseInt(s.toString());
                        Log.d("sasa", Integer.toString(firstInputValue));
                    } else if (secondNumber.getEditableText() == s) {
                        secondInputValue = Integer.parseInt(s.toString());
                        Log.d("sasa", Integer.toString(secondInputValue));
                    } else if (thirdNumber.getEditableText() == s) {
                        thirdInputValue = Integer.parseInt(s.toString());
                        Log.d("sasa", Integer.toString(thirdInputValue));
                    }
                }catch (Exception ae){
                    System.out.println(ae.getMessage());
                }
            }
        };
        firstNumber.addTextChangedListener(textWatcher);
        secondNumber.addTextChangedListener(textWatcher);
        thirdNumber.addTextChangedListener(textWatcher);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("inputValue",firstInputValue);
        Log.d("sasa"," onSaved "+Integer.toString(firstInputValue));
        outState.putInt("inputValue2",secondInputValue);
        Log.d("sasa"," onSaved "+Integer.toString(secondInputValue));
        outState.putInt("inputValue3",thirdInputValue);
        Log.d("sasa", " onSaved "+Integer.toString(thirdInputValue));
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        firstInputValueB = savedInstanceState.getInt("inputValue");
        Log.d("sasa","onRestore "+Integer.toString(firstInputValueB));
        secondInputValueB = savedInstanceState.getInt("inputValue2");
        Log.d("sasa","onRestore "+Integer.toString(secondInputValueB));
        thirdInputValueB = savedInstanceState.getInt("inputValue3");
        Log.d("sasa","onRestore "+Integer.toString(thirdInputValueB));
    }
}