package com.tbvanderleystudios.signalsfrommars.model;

public class Page {
    // Fields
    private int mImageId;
    private int mTextId;
    private Choice mChoice1;
    private Choice mChoice2;
    private boolean mIsFinal = false;

    // Create a custom constructor for each Page object
    public Page(int imageId, int textId, Choice choice1, Choice choice2) {
        mImageId = imageId;
        mTextId = textId;
        mChoice1 = choice1;
        mChoice2 = choice2;
    }

    public Page(int imageId, int textId) {
        mImageId = imageId;
        mTextId = textId;
        mChoice1 = null;
        mChoice2 = null;
        mIsFinal = true;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int id) {
        mImageId = id;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }

    public int getTextId() {
        return mTextId;
    }

    public void setTextId(int textId) {
        mTextId = textId;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public boolean isFinal() {
        return mIsFinal;
    }

    public void setIsFinal(boolean isFinal) {
        mIsFinal = isFinal;
    }
}
