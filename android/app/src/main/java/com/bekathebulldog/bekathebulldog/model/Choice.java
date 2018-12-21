package com.bekathebulldog.bekathebulldog.model;

public class Choice {
    private int mImageButton;
    private int mNextPage;

    public Choice(int buttonId, int nextPage) {
        mImageButton = buttonId;
        mNextPage = nextPage;
    }

    public int getImageButton() {
        return mImageButton;
    }

    public void setImageButton(int buttonId) {
        mImageButton = buttonId;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }
}
