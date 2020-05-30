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


public class ColorsTheoryFragment extends Fragment {


    public ColorsTheoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.afc_list, container, false);

        final ArrayList<Word> colorsList = new ArrayList<Word>();
        colorsList.add(new Word(getString(R.string.red),"Κόκκινο", R.mipmap.ic_red));
        colorsList.add(new Word(getString(R.string.green),"Πράσινο", R.mipmap.ic_green));
        colorsList.add(new Word(getString(R.string.blue),"Μπλέ", R.mipmap.ic_blue));
        colorsList.add(new Word(getString(R.string.orange),"Πορτοκαλί", R.mipmap.ic_orange));
        colorsList.add(new Word(getString(R.string.brown),"Καφέ", R.mipmap.ic_brown));
        colorsList.add(new Word(getString(R.string.yellow),"Κίτρινο", R.mipmap.ic_yellow));
        colorsList.add(new Word(getString(R.string.pink),"Ρόζ", R.mipmap.ic_pink));
        colorsList.add(new Word(getString(R.string.purple),"Μώβ", R.mipmap.ic_pur));
        colorsList.add(new Word(getString(R.string.black),"Μαύρο",R.mipmap.ic_black));
        colorsList.add(new Word(getString(R.string.white),"Άσπρο", R.mipmap.ic_white));


        AFCAdapter adapter = new AFCAdapter(getActivity(), colorsList, R.color.colors);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }


}
