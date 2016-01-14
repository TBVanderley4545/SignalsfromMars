package com.tbvanderleystudios.signalsfrommars.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tbvanderleystudios.signalsfrommars.R;

public class StoryActivity extends AppCompatActivity {

    // This is used for our TAG during log calls.
    public static final String TAG = StoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // We are currently doing two things with this intent.
        // 1. We are getting the Intent that was passed to this activity from MainActivity
        // 2. We are setting a String variable called name equal to the value passed in the Intent.
        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.key_name));

        // This is a null check to prevent hard crashes.
        if(name == null) {
            name = "Friend";
        }

        Log.d(TAG, "The name entered is " + name + ".");
    }

}
