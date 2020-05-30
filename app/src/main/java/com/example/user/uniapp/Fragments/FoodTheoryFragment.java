package com.example.user.uniapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.user.uniapp.Adapters.AFCAdapter;
import com.example.user.uniapp.Class.Word;
import com.example.user.uniapp.R;

import java.util.ArrayList;


public class FoodTheoryFragment extends Fragment {

    public FoodTheoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.afc_list, container, false);


        final ArrayList<Word> foodList = new ArrayList<Word>();
        foodList.add(new Word(getString(R.string.bread), "Ψωμί", R.drawable.bread));
        foodList.add(new Word(getString(R.string.cheese), "Τυρί", R.drawable.cheese));
        foodList.add(new Word(getString(R.string.tomato), "Ντομάτα", R.drawable.tomato));
        foodList.add(new Word(getString(R.string.mushroom), "Μανιτάρι", R.drawable.mushroom));
        foodList.add(new Word(getString(R.string.pumkin), "Κολοκύθα", R.drawable.pumkin));
        foodList.add(new Word(getString(R.string.carrot), "Καρότο", R.drawable.carrot));
        foodList.add(new Word(getString(R.string.fries), "Τηγανιτές Πατάτες", R.drawable.french_fries));
        foodList.add(new Word(getString(R.string.pizza), "Πίτσα", R.drawable.pizza));
        foodList.add(new Word(getString(R.string.cookies), "Μπισκότα", R.drawable.cookies));
        foodList.add(new Word(getString(R.string.honey), "Μπισκότα", R.drawable.honey));

        AFCAdapter adapter = new AFCAdapter(getActivity(), foodList, R.color.food);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }




}
