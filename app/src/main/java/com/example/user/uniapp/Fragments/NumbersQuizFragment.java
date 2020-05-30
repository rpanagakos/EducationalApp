package com.example.user.uniapp.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.uniapp.Common.Common;
import com.example.user.uniapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NumbersQuizFragment extends Fragment {

    //EditTexts
    @BindView(R.id.numEditAns1) EditText numWsitAns1;
    @BindView(R.id.numEditAns2) EditText numWsitAns2;
    @BindView(R.id.numEditAns3) EditText numWsitAns3;
    @BindView(R.id.numEditAns4) EditText numWsitAns4;
    @BindView(R.id.numEditAns5) EditText numWsitAns5;
    @BindView(R.id.numEditAns6) EditText numWsitAns6;
    @BindView(R.id.numEditAns7) EditText numWsitAns7;
    @BindView(R.id.numEditAns8) EditText numWsitAns8;
    @BindView(R.id.numEditAns9) EditText numWsitAns9;
    @BindView(R.id.numEditAns10) EditText numWsitAns10;

    //TextViews
    @BindView(R.id.textNumAns1) TextView textNumAns1;
    @BindView(R.id.textNumAns2) TextView textNumAns2;
    @BindView(R.id.textNumAns3) TextView textNumAns3;
    @BindView(R.id.textNumAns4) TextView textNumAns4;
    @BindView(R.id.textNumAns5) TextView textNumAns5;
    @BindView(R.id.textNumAns6) TextView textNumAns6;
    @BindView(R.id.textNumAns7) TextView textNumAns7;
    @BindView(R.id.textNumAns8) TextView textNumAns8;
    @BindView(R.id.textNumAns9) TextView textNumAns9;
    @BindView(R.id.textNumAns10) TextView textNumAns10;


    @BindView(R.id.submitButtonNum) Button submitButtonNum;

    private int finalScore;


    public NumbersQuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_numbers_quiz, container, false);
        ButterKnife.bind(this, root);

        submitButtonNum.setOnClickListener(checkTheAnswers);

        return root;
    }

    private View.OnClickListener checkTheAnswers = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (numWsitAns1.getText().toString().toLowerCase().equals("three")){
                finalScore +=1;
                textNumAns1.setText("Σωστή Απάντηση");
                textNumAns1.setTextColor(getResources().getColor(R.color.correctFood));
            }else if(numWsitAns1.getText().toString().toLowerCase().equals("")){
                textNumAns1.setText("Ξέχασες να το συμπληρώσεις");
                textNumAns1.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                textNumAns1.setText("Ήσουν Άτυχος");
                textNumAns1.setTextColor(getResources().getColor(R.color.animalWrong));

            }

            if (numWsitAns2.getText().toString().toLowerCase().equals("four")){
                finalScore +=1;
                textNumAns2.setText("Σωστή Απάντηση");
                textNumAns2.setTextColor(getResources().getColor(R.color.correctFood));
            }else if(numWsitAns2.getText().toString().toLowerCase().equals("")){
                textNumAns2.setText("Ξέχασες να το συμπληρώσεις");
                textNumAns2.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                textNumAns2.setText(R.string.syntaxError);
                textNumAns2.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (numWsitAns3.getText().toString().toLowerCase().equals("eight")){
                finalScore +=1;
                textNumAns3.setText("Σωστή Απάντηση");
                textNumAns3.setTextColor(getResources().getColor(R.color.correctFood));
            }else if(numWsitAns3.getText().toString().toLowerCase().equals("")){
                textNumAns3.setText("Ξέχασες να το συμπληρώσεις");
                textNumAns3.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                textNumAns3.setText(R.string.syntaxError);
                textNumAns3.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (numWsitAns4.getText().toString().toLowerCase().equals("five")){
                finalScore +=1;
                textNumAns4.setText("Σωστή Απάντηση");
                textNumAns4.setTextColor(getResources().getColor(R.color.correctFood));
            }else if(numWsitAns4.getText().toString().toLowerCase().equals("")){
                textNumAns4.setText("Ξέχασες να το συμπληρώσεις");
                textNumAns4.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                textNumAns4.setText(R.string.syntaxError);
                textNumAns4.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (numWsitAns5.getText().toString().toLowerCase().equals("one")){
                finalScore +=1;
                textNumAns5.setText("Σωστή Απάντηση");
                textNumAns5.setTextColor(getResources().getColor(R.color.correctFood));
            }else if(numWsitAns5.getText().toString().toLowerCase().equals("")){
                textNumAns5.setText("Ξέχασες να το συμπληρώσεις");
                textNumAns5.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                textNumAns5.setText(R.string.syntaxError);
                textNumAns5.setTextColor(getResources().getColor(R.color.animalWrong));
            }


            if (numWsitAns6.getText().toString().toLowerCase().equals("two")){
                finalScore +=1;
                textNumAns6.setText("Σωστή Απάντηση");
                textNumAns6.setTextColor(getResources().getColor(R.color.correctFood));
            }else if(numWsitAns6.getText().toString().toLowerCase().equals("")){
                textNumAns6.setText("Ξέχασες να το συμπληρώσεις");
                textNumAns6.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                textNumAns6.setText(R.string.syntaxError);
                textNumAns6.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (numWsitAns7.getText().toString().toLowerCase().equals("seven")){
                finalScore +=1;
                textNumAns7.setText("Σωστή Απάντηση");
                textNumAns7.setTextColor(getResources().getColor(R.color.correctFood));
            }else if(numWsitAns7.getText().toString().toLowerCase().equals("")){
                textNumAns7.setText("Ξέχασες να το συμπληρώσεις");
                textNumAns7.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                textNumAns7.setText(R.string.syntaxError);
                textNumAns7.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (numWsitAns8.getText().toString().toLowerCase().equals("ten")){
                finalScore +=1;
                textNumAns8.setText("Σωστή Απάντηση");
                textNumAns8.setTextColor(getResources().getColor(R.color.correctFood));
            }else if(numWsitAns8.getText().toString().toLowerCase().equals("")){
                textNumAns8.setText("Ξέχασες να το συμπληρώσεις");
                textNumAns8.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                textNumAns8.setText(R.string.syntaxError);
                textNumAns8.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (numWsitAns9.getText().toString().toLowerCase().equals("nine")){
                finalScore +=1;
                textNumAns9.setText("Σωστή Απάντηση");
                textNumAns9.setTextColor(getResources().getColor(R.color.correctFood));
            }else if(numWsitAns9.getText().toString().toLowerCase().equals("")){
                textNumAns9.setText("Ξέχασες να το συμπληρώσεις");
                textNumAns9.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                textNumAns9.setText(R.string.syntaxError);
                textNumAns9.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (numWsitAns10.getText().toString().toLowerCase().equals("six")){
                finalScore +=1;
                textNumAns10.setText("Σωστή Απάντηση");
                textNumAns10.setTextColor(getResources().getColor(R.color.correctFood));
            }else if(numWsitAns10.getText().toString().toLowerCase().equals("")){
                textNumAns10.setText("Ξέχασες να το συμπληρώσεις");
                textNumAns10.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                textNumAns10.setText(R.string.syntaxError);
                textNumAns10.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (numWsitAns1.getText().toString().isEmpty() && numWsitAns2.getText().toString().isEmpty() && numWsitAns3.getText().toString().isEmpty() && numWsitAns4.getText().toString().isEmpty() && numWsitAns5.getText().toString().isEmpty() && numWsitAns6.getText().toString().isEmpty() && numWsitAns7.getText().toString().isEmpty() && numWsitAns8.getText().toString().isEmpty() && numWsitAns9.getText().toString().isEmpty() && numWsitAns10.getText().toString().isEmpty()  ){
                Toast.makeText(getActivity(),"Το Σκορ σε αυτή την κατηγορία είναι: 0/10", Toast.LENGTH_SHORT).show();
                finalScore = -1;
            } else {
                Toast.makeText(getActivity(),"Το Σκορ σε αυτή την κατηγορία είναι: " + finalScore + "/10", Toast.LENGTH_SHORT).show();
            }

            //Create the object gor the update
            Map<String, Object> scoreUpdate = new HashMap<>();
            scoreUpdate.put("Numbers", finalScore);

            //Make the update
            DatabaseReference user = FirebaseDatabase.getInstance().getReference("User");
            user.child(Common.currentUser.getStudentId())
                    .updateChildren(scoreUpdate)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });

            //Reset the score for the next try
            finalScore = 0;
        }
    };

}
