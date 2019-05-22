package com.victor.andriod.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class CrimeActivity extends SingleFragment {
    public static final String EXTRA_CRIME_ID="com.victor.android.criminalintent.crimeid";


    @Override
    public Fragment createFragment() {
        return new CrimeFragment();
    }
    public static Intent newIntent(Context packageContext, UUID crimeId){
        Intent intent=new Intent(packageContext,CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID,crimeId);
        return intent;
    }
}
