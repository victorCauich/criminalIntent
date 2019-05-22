package com.victor.andriod.criminalintent.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;

    public static CrimeLab get(Context context){
        if(sCrimeLab==null){
            sCrimeLab=new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context){
        mCrimes=new ArrayList<Crime>();
        for (int i=1; i<=100;i++){
            Crime crime=new Crime();
            crime.setTitle("Crimen # "+i);
            crime.setSolved(i%2==0);
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID crimeId){
        for(Crime crime: mCrimes)
        {
            if(crime.getCrimeId().equals(crimeId)){
                return crime;
            }

        }
        return null;
    }
}
