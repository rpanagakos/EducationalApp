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


public class AnimalTheoryFragment extends Fragment {


    public AnimalTheoryFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.afc_list, container, false);

        final ArrayList<Word> animalList = new ArrayList<Word>();
        animalList.add(new Word(getString(R.string.cat),"Γάτα", R.drawable.cat));
        animalList.add(new Word(getString(R.string.dog),"Σκύλος", R.drawable.dog));
        animalList.add(new Word(getString(R.string.chicken),"Κότα", R.drawable.chicken));
        animalList.add(new Word(getString(R.string.cow),"Αγελάδα", R.drawable.cow));
        animalList.add(new Word(getString(R.string.pig),"Γουρουνάκι", R.drawable.pig));
        animalList.add(new Word(getString(R.string.rabbit),"Κουνελάκι", R.drawable.rabbit));
        animalList.add(new Word(getString(R.string.turtle),"Χελώνα", R.drawable.turtle));
        animalList.add(new Word(getString(R.string.insect),"Έντομο",R.drawable.insect));
        animalList.add(new Word(getString(R.string.sheep),"Πρόβατο", R.drawable.sheep));
        animalList.add(new Word(getString(R.string.monkey),"Μαϊμού", R.drawable.monkey));


        AFCAdapter adapter = new AFCAdapter(getActivity(), animalList, R.color.animals);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }


}
