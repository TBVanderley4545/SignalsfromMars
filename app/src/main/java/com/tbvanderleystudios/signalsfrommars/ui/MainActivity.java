package com.tbvanderleystudios.signalsfrommars.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tbvanderleystudios.signalsfrommars.R;

public class MainActivity extends AppCompatActivity {

    // Fields
    private Button mStartButton;
    private EditText mNameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the mStartButton field and mNameField to the Button on our layout
        mStartButton = (Button) findViewById(R.id.startButton);
        mNameField = (EditText) findViewById(R.id.nameEditText);

        // This is the OnClickListener created for mStartButton
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameField.getText().toString();
                startStory(name);
            }
        };

        mStartButton.setOnClickListener(listener);
    }

    private void startStory(String name) {
        // In this method, we are doing three things.
        // 1. Creating a new Intent from MainActivity to StoryActivity
        // 2. Putting the name entered in the EditText into the Intent
        // 3. Starting the activity with the Intent that we created
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra(getString(R.string.key_name), name);
        startActivity(intent);
    }
}
