package com.tbvanderleystudios.signalsfrommars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra("NAME_VALUE", name);
        startActivity(intent);
    }
}
