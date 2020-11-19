package com.example.fragment;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    public static final String KEY_GET = "key";
    public static final String KEY_DESC = "keyDesc";

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private TextFragment fragment;
    private CarrierData clicker;
    private boolean isVisible;
    private View fragmentView;


    private String title;
    private String description;
    private int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentView = findViewById(R.id.textFragment);
        if (fragmentView != null) {
            isVisible = true;
        }
        Intent intent = getIntent();
        if (intent != null) {
            title = intent.getStringExtra(ApplicationActivity.KEY);
            description = intent.getStringExtra(ApplicationActivity.KEY2);
            image = intent.getIntExtra(ApplicationActivity.KEY3, 0);


            fragmentManager = getSupportFragmentManager();
            transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.changeFragment, ChangeFragment.newInstance(title, description, image));
            transaction.commit();

        }
    }


    public void displayDeteils(String title, String description) {
        if (isVisible) {
//(getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE to get size of the screen to figure out if its a tablet;
            transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.textFragment, TextFragment.newInstance(title, description));
            transaction.commit();
        } else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(KEY_GET, title);
            intent.putExtra(KEY_DESC, description);
            startActivity(intent);
        }
    }
}