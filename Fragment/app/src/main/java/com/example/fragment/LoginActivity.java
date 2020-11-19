package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnSend;


    private static final Pattern PATTERN_PASSWORD = Pattern.compile( "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$" );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);
        btnSend = findViewById(R.id.loginBtn);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidEmail(etEmail.getText().toString()) && PATTERN_PASSWORD.matcher(etPassword.getText().toString()).matches()){
                    Intent intent = new Intent(LoginActivity.this,ApplicationActivity.class);
                    startActivity(intent);
                    finish();
                } if (!PATTERN_PASSWORD.matcher(etPassword.getText().toString()).matches()){

                    Toast.makeText(LoginActivity.this,"Wrong password ", Toast.LENGTH_LONG).show();

                }if (!isValidEmail(etEmail.getText().toString())){

                    Toast.makeText(LoginActivity.this,"Wrong email ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public static boolean isValidEmail(String email) {

        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}