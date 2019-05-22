package com.victor.andriod.criminalintent;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.victor.andriod.criminalintent.model.Crime;
import com.victor.andriod.criminalintent.model.CrimeLab;

import org.w3c.dom.Text;

import java.util.List;

public class CrimeListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private CrimeAdapter mAdapter;

    public void updateUI(){
        CrimeLab crimeLab=CrimeLab.get(getActivity());
        List<Crime> crimes=crimeLab.getCrimes();
        mAdapter= new CrimeAdapter(crimes);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_crime_list,container,false);
        mRecyclerView=view.findViewById(R.id.crime_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;


    }

    private class CrimeHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private Crime mCrime;
        public TextView mDateTextView;
        public TextView mTitleTextView;
        public CheckBox mSolvedCheckBox;

        public CrimeHolder(View itemView) {
            super(itemView);
            mTitleTextView=(TextView) itemView.findViewById(R.id.list_item_crime_title_text_view);
            mDateTextView=(TextView) itemView.findViewById(R.id.list_item_crime_date_text_view);
            mSolvedCheckBox=(CheckBox) itemView.findViewById(R.id.list_item_crime_solved_check_box);
        }
        public void bindCrime(Crime crime){
            mCrime=crime;
            itemView.setOnClickListener(this);
            mTitleTextView.setText(mCrime.getTitle());
            mDateTextView.setText(mCrime.getDate().toString());
            mSolvedCheckBox.setChecked(mCrime.isSolved());
        }

        @Override
        public void onClick(View view) {
            Intent intent=CrimeActivity.newIntent(getActivity(),mCrime.getCrimeId());
            startActivity(intent);
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes){
            mCrimes=crimes;

        }
        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            LayoutInflater layoutInflater= LayoutInflater.from(getActivity());
            //View view=layoutInflater.inflate(android.R.layout.simple_list_item_1,parent,false);
            View view=layoutInflater.inflate(R.layout.list_item_crime,parent,false);

            return new CrimeHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
            Crime crime=mCrimes.get(position);
            holder.bindCrime(crime);
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }
}
