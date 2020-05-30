package com.example.user.uniapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.uniapp.Class.User;
import com.example.user.uniapp.R;
import com.example.user.uniapp.ViewHolder.StudentViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AnimalsFragment extends Fragment {

    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView recyclerView;

    FirebaseRecyclerAdapter<User, StudentViewHolder> adapter;
    FirebaseDatabase database;
    DatabaseReference student;

    public AnimalsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_animals, container, false);

        //Firebase
        database = FirebaseDatabase.getInstance();
        student = database.getReference("User");

        recyclerView = (RecyclerView) root.findViewById(R.id.animalsList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        loadStudents();

        return root;
    }

    private void loadStudents(){
        adapter = new FirebaseRecyclerAdapter<User, StudentViewHolder>(User.class, R.layout.list_professor, StudentViewHolder.class,student) {
            @Override
            protected void populateViewHolder(StudentViewHolder viewHolder, User model, int position) {
                viewHolder.studentName.setText(model.getName());

                int grade = changeColor(model.getAnimals());
                viewHolder.circleBackground.setBackgroundResource(grade);

                if (model.getAnimals() == -1){
                    viewHolder.studentGrade.setText("0%");
                }else{
                    viewHolder.studentGrade.setText(String.valueOf(model.getAnimals()) + "0%");
                }


                final User user = model;

            }
        };
        recyclerView.setAdapter(adapter);
    }


    private int changeColor(int value){
        int colorForCircleBackground;

        if (value == 0)
        {
            colorForCircleBackground = R.drawable.lightcircle;
        }
        else if (value < 5 && value > 0 || value == -1)
        {
            colorForCircleBackground = R.drawable.redcircle;
        }
        else if(value >= 5 && value <=8)
        {
            colorForCircleBackground = R.drawable.lighgreencircle;
        }
        else
        {
            colorForCircleBackground = R.drawable.circle;
        }
        return colorForCircleBackground;
    }



}
