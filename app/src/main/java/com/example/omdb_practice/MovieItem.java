package com.example.omdb_practice;

public class MovieItem {

    private int mImageResource;
    private String mTextView1;
    private String mTextView2;

    public MovieItem(int imageResource, String textView1, String textView2) {

        mImageResource =  imageResource;
        mTextView1 = textView1;
        mTextView2 = textView2;

    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getmTextView1() {
        return mTextView1;
    }

    public void setmTextView1(String mTextView1) {
        this.mTextView1 = mTextView1;
    }

    public String getmTextView2() {
        return mTextView2;
    }

    public void setmTextView2(String mTextView2) {
        this.mTextView2 = mTextView2;
    }
}
