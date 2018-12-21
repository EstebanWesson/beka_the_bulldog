package com.bekathebulldog.bekathebulldog.ui;

import android.app.ActionBar;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bekathebulldog.bekathebulldog.R;
import com.bekathebulldog.bekathebulldog.model.Page;
import com.bekathebulldog.bekathebulldog.model.Story;

public class StoryActivity extends AppCompatActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();

    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private ImageButton mChoice1;
    private ImageButton mChoice2;
    private String mName;
    private Page mCurrentPage;
    private int mImageId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));

        if (mName == null){
            mName = "Friend";
        }
        Log.d(TAG, mName);

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (ImageButton) findViewById(R.id.choiceButton1);
        mChoice2 = (ImageButton) findViewById(R.id.choiceButton2);

        loadPage(0);

    }

    private void loadPage(int choice) {
        mCurrentPage = mStory.getPage(choice);

        mImageId = mCurrentPage.getImageId();
        Drawable drawable = ResourcesCompat.getDrawable(getResources(),mImageId,null);
        mImageView.setImageDrawable(drawable);

        String pageText = mCurrentPage.getText();

        if (pageText == null) {
            mTextView.setVisibility(View.INVISIBLE);
        } else {
            // Add the name if placeholder included. Won't add if no placeholder is found.
            pageText = String.format(pageText, mName);
            mTextView.setText(pageText);
        }


        if (mCurrentPage.isFinal()) {
            mChoice2.setVisibility(View.INVISIBLE);
            mChoice1.setImageResource(R.drawable.play_again);
            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } else {

            mChoice1.setImageResource(mCurrentPage.getChoice1().getImageButton());
            mChoice2.setImageResource(mCurrentPage.getChoice2().getImageButton());

            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    loadPage(nextPage);

                }
            });

            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    loadPage(nextPage);

                }
            });

        }
    }

}
