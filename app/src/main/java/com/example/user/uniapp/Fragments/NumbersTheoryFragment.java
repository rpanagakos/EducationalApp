package com.example.user.uniapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.user.uniapp.Adapters.WordAdapter;
import com.example.user.uniapp.Class.Word;
import com.example.user.uniapp.R;

import java.util.ArrayList;


public class NumbersTheoryFragment extends Fragment {

    public NumbersTheoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_numbers_theory, container, false);

        final ArrayList<Word> numbersList = new ArrayList<Word>();
        numbersList.add(new Word(getString(R.string.one),"Ένα", R.drawable.number_one));
        numbersList.add(new Word(getString(R.string.Two),"Δύο", R.drawable.number_two));
        numbersList.add(new Word(getString(R.string.Three),"Τρία", R.drawable.number_three));
        numbersList.add(new Word(getString(R.string.four),"Τέσσερα", R.drawable.number_four));
        numbersList.add(new Word(getString(R.string.five),"Πέντε", R.drawable.number_five));
        numbersList.add(new Word(getString(R.string.six),"Έξι", R.drawable.number_six));
        numbersList.add(new Word(getString(R.string.seven),"Επτά", R.drawable.number_seven));
        numbersList.add(new Word(getString(R.string.eight),"Ωκτό", R.drawable.number_eight));
        numbersList.add(new Word(getString(R.string.nine),"Ένια",R.drawable.number_nine));
        numbersList.add(new Word(getString(R.string.ten),"Δέκα", R.drawable.number_ten));


        WordAdapter adapter = new WordAdapter(getActivity(), numbersList);

        ListView listView = (ListView) rootView.findViewById(R.id.listview_numbersTheory);

        listView.setAdapter(adapter);

        return rootView;
    }


}
