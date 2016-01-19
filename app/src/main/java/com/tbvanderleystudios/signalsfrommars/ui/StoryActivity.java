package com.tbvanderleystudios.signalsfrommars.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tbvanderleystudios.signalsfrommars.R;
import com.tbvanderleystudios.signalsfrommars.model.Page;
import com.tbvanderleystudios.signalsfrommars.model.Story;

public class StoryActivity extends AppCompatActivity {

    // This is used for our TAG during log calls.
    public static final String TAG = StoryActivity.class.getSimpleName();
    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;
    private Page mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // We are currently doing two things with this intent.
        // 1. We are getting the Intent that was passed to this activity from MainActivity
        // 2. We are setting a String variable called name equal to the value passed in the Intent.
        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));

        // This is a null check to prevent hard crashes.
        if(mName == null) {
            mName = "Friend";
        }

        Log.d(TAG, "The name entered is " + mName + ".");

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.buttonChoice1);
        mChoice2 = (Button) findViewById(R.id.buttonChoice2);

        loadPage(0);
    }


    private void loadPage(int pageIndex) {
        mCurrentPage = mStory.getPage(pageIndex);

        // This is getting our Drawable resource from the page
        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        mImageView.setImageDrawable(drawable);

        // This is getting the story text from our page, and then formatting it
        // so that the name entered and passed in the intent is carried into the story.
        String storyText = getResources().getString(mCurrentPage.getTextId());
        storyText = String.format(storyText, mName);
        mTextView.setText(storyText);


        if(mCurrentPage.isFinal()) {
            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText(R.string.play_again);

            // Create OnClickListener for play again.
            View.OnClickListener listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            };
            mChoice2.setOnClickListener(listener);
        } else {
            String choice1Text = getResources().getString(mCurrentPage.getChoice1().getStringResourceId());
            mChoice1.setText(choice1Text);

            String choice2Text = getResources().getString(mCurrentPage.getChoice2().getStringResourceId());
            mChoice2.setText(choice2Text);

            // Set onClickListeners for both buttons
            View.OnClickListener listener1 = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            };
            mChoice1.setOnClickListener(listener1);

            View.OnClickListener listener2 = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    loadPage(nextPage);
                }
            };
            mChoice2.setOnClickListener(listener2);
        }
    }
}
