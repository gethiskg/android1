package com.example.rcyclerinotherway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class EditActivity extends AppCompatActivity {
    public static final String KEY_EDITED = "editedKey";
    ImageView imageChange;
    EditText editName;
    EditText editPhone;
    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        imageChange = findViewById(R.id.picEdit);
        editName = findViewById(R.id.nameEdit);
        editPhone = findViewById(R.id.phoneEdit);
        btnEdit = findViewById(R.id.btnEdit);
        getToEdit();
    }

    private void getToEdit() {
        Intent intent = getIntent();
        String forImage = intent.getStringExtra(MainActivity.IMAGE_EDIT);
        editName.setText(intent.getStringExtra(MainActivity.KEY_TO_EDIT_NAME));
        editPhone.setText(intent.getStringExtra(MainActivity.KEY_EDIT_PHONE));
        Glide.with(this)
                .load(forImage)
                .apply(RequestOptions.circleCropTransform())
                .into(imageChange);
        TitleModel myModel = new TitleModel();
        /*btn action to send changed values*/
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editNameValue = editName.getText().toString();
                String editPhoneValue = editPhone.getText().toString();
                myModel.setName(editNameValue);
                myModel.setPhoneNumber(editPhoneValue);
                myModel.setImage(forImage);
                intent.putExtra(KEY_EDITED,myModel);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}