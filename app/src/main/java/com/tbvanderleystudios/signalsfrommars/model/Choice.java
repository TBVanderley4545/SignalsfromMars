package com.tbvanderleystudios.signalsfrommars.model;

public class Choice {
    // Fields
    private int mStringResourceId;
    private int mNextPage;

    // // Create a custom constructor for each Choice object
    public Choice(int stringResourceID, int nextPage) {
        mStringResourceId = stringResourceID;
        mNextPage = nextPage;
    }

    public int getStringResourceId() {
        return mStringResourceId;
    }

    public void setStringResourceId(int stringResourceId) {
        mStringResourceId = stringResourceId;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }
}
