package com.victor.andriod.criminalintent.model;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mCrimeId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime(){
        mCrimeId=UUID.randomUUID();
        mDate= new Date();
    }


    public UUID getCrimeId() {
        return mCrimeId;
    }
    public Date getDate() { return mDate; }
    public boolean isSolved() {
        return mSolved;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
    public void setDate(Date mDate) { this.mDate = mDate; }
    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public String getTitle() {
        return mTitle;
    }
}
