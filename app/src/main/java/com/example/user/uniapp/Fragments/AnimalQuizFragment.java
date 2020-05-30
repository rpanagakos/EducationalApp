package com.example.user.uniapp.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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


public class AnimalQuizFragment extends Fragment {

    //RadioGroups
    @BindView(R.id.animalRadioAns1) RadioGroup radioGroup1;
    @BindView(R.id.animalRadioAns2) RadioGroup radioGroup2;
    @BindView(R.id.animalRadioAns3) RadioGroup radioGroup3;
    @BindView(R.id.animalRadioAns4) RadioGroup radioGroup4;
    @BindView(R.id.animalRadioAns5) RadioGroup radioGroup5;
    @BindView(R.id.animalRadioAns6) RadioGroup radioGroup6;
    @BindView(R.id.animalRadioAns7) RadioGroup radioGroup7;
    @BindView(R.id.animalRadioAns8) RadioGroup radioGroup8;
    @BindView(R.id.animalRadioAns9) RadioGroup radioGroup9;
    @BindView(R.id.animalRadioAns10) RadioGroup radioGroup10;

    //RadioButtonsAns
    @BindView(R.id.aRadionButtonAns1) RadioButton radioButton1;
    @BindView(R.id.aRadionButtonAns2) RadioButton radioButton2;
    @BindView(R.id.aRadionButtonAns3) RadioButton radioButton3;
    @BindView(R.id.aRadionButtonAns4) RadioButton radioButton4;
    @BindView(R.id.aRadionButtonAns5) RadioButton radioButton5;
    @BindView(R.id.aRadionButtonAns6) RadioButton radioButton6;
    @BindView(R.id.aRadionButtonAns7) RadioButton radioButton7;
    @BindView(R.id.aRadionButtonAns8) RadioButton radioButton8;
    @BindView(R.id.aRadionButtonAns9) RadioButton radioButton9;
    @BindView(R.id.aRadionButtonAns10) RadioButton radioButton10;

    //SubmitButton
    @BindView(R.id.submitButtonAnimals) Button submitButton;

    //TextView
    @BindView(R.id.animalResult1) TextView textView1;
    @BindView(R.id.animalResult2) TextView textView2;
    @BindView(R.id.animalResult3) TextView textView3;
    @BindView(R.id.animalResult4) TextView textView4;
    @BindView(R.id.animalResult5) TextView textView5;
    @BindView(R.id.animalResult6) TextView textView6;
    @BindView(R.id.animalResult7) TextView textView7;
    @BindView(R.id.animalResult8) TextView textView8;
    @BindView(R.id.animalResult9) TextView textView9;
    @BindView(R.id.animalResult10) TextView textView10;


    private int finalScore;

    public AnimalQuizFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_animal_quiz, container, false);
        ButterKnife.bind(this, rootView);
        submitButton.setOnClickListener(checkTheAnswers);

        return rootView;
    }

    private View.OnClickListener checkTheAnswers = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                    if(radioButton1.isChecked())
                    {
                        finalScore += 1;
                        textView1.setText("Σωστή Απάντηση");
                        textView1.setTextColor(getResources().getColor(R.color.numberQuiz));

                    }
                    else if(radioGroup1.getCheckedRadioButtonId() == -1){
                        //Please select Answer
                        textView1.setText("Ξέχασες να το συμπληρώσεις");
                        textView1.setTextColor(getResources().getColor(R.color.animalWrong));

                    }
                    else {
                        //wrong Answer
                        textView1.setText("Ήσουν Άτυχος");
                        textView1.setTextColor(getResources().getColor(R.color.animalWrong));

                    }

                    if(radioButton2.isChecked())
                    {
                        finalScore += 1;
                        textView2.setText("Σωστή Απάντηση");
                        textView2.setTextColor(getResources().getColor(R.color.numberQuiz));

                    }
                    else if(radioGroup2.getCheckedRadioButtonId() == -1){
                        //Please select Answer
                        textView2.setText("Ξέχασες να το συμπληρώσεις");
                        textView2.setTextColor(getResources().getColor(R.color.animalWrong));

                    }
                    else {
                        //wrong Answer
                        textView2.setText("Ήσουν Άτυχος");
                        textView2.setTextColor(getResources().getColor(R.color.animalWrong));

                    }

                    if(radioButton3.isChecked())
                    {
                        finalScore += 1;
                        textView3.setText("Σωστή Απάντηση");
                        textView3.setTextColor(getResources().getColor(R.color.numberQuiz));

                    }
                    else if(radioGroup3.getCheckedRadioButtonId() == -1){
                        //Please select Answer
                        textView3.setText("Ξέχασες να το συμπληρώσεις");
                        textView3.setTextColor(getResources().getColor(R.color.animalWrong));

                    }
                    else {
                        //wrong Answer
                        textView3.setText("Ήσουν Άτυχος");
                        textView3.setTextColor(getResources().getColor(R.color.animalWrong));

                    }

                    if(radioButton4.isChecked())
                    {
                        finalScore += 1;
                        textView4.setText("Σωστή Απάντηση");
                        textView4.setTextColor(getResources().getColor(R.color.numberQuiz));

                    }
                    else if(radioGroup4.getCheckedRadioButtonId() == -1){
                        //Please select Answer
                        textView4.setText("Ξέχασες να το συμπληρώσεις");
                        textView4.setTextColor(getResources().getColor(R.color.animalWrong));

                    }
                    else {
                        //wrong Answer
                        textView4.setText("Ήσουν Άτυχος");
                        textView4.setTextColor(getResources().getColor(R.color.animalWrong));

                    }

                    if(radioButton5.isChecked())
                    {
                        finalScore += 1;
                        textView5.setText("Σωστή Απάντηση");
                        textView5.setTextColor(getResources().getColor(R.color.numberQuiz));

                    }
                    else if(radioGroup5.getCheckedRadioButtonId() == -1){
                        //Please select Answer
                        textView5.setText("Ξέχασες να το συμπληρώσεις");
                        textView5.setTextColor(getResources().getColor(R.color.animalWrong));

                    }
                    else {
                        //wrong Answer
                        textView5.setText("Ήσουν Άτυχος");
                        textView5.setTextColor(getResources().getColor(R.color.animalWrong));

                    }

                    if(radioButton6.isChecked())
                    {
                        finalScore += 1;
                        textView6.setText("Σωστή Απάντηση");
                        textView6.setTextColor(getResources().getColor(R.color.numberQuiz));

                    }
                    else if(radioGroup6.getCheckedRadioButtonId() == -1){
                        //Please select Answer
                        textView6.setText("Ξέχασες να το συμπληρώσεις");
                        textView6.setTextColor(getResources().getColor(R.color.animalWrong));

                    }
                    else {
                        //wrong Answer
                        textView6.setText("Ήσουν Άτυχος");
                        textView6.setTextColor(getResources().getColor(R.color.animalWrong));

                    }

                    if(radioButton7.isChecked())
                    {
                        finalScore += 1;
                        textView7.setText("Σωστή Απάντηση");
                        textView7.setTextColor(getResources().getColor(R.color.numberQuiz));

                    }
                    else if(radioGroup7.getCheckedRadioButtonId() == -1){
                        //Please select Answer
                        textView7.setText("Ξέχασες να το συμπληρώσεις");
                        textView7.setTextColor(getResources().getColor(R.color.animalWrong));

                    }
                    else {
                        //wrong Answer
                        textView7.setText("Ήσουν Άτυχος");
                        textView7.setTextColor(getResources().getColor(R.color.animalWrong));

                    }

                    if(radioButton8.isChecked())
                    {
                        finalScore += 1;
                        textView8.setText("Σωστή Απάντηση");
                        textView8.setTextColor(getResources().getColor(R.color.numberQuiz));

                    }
                    else if(radioGroup8.getCheckedRadioButtonId() == -1){
                        //Please select Answer
                        textView8.setText("Ξέχασες να το συμπληρώσεις");
                        textView8.setTextColor(getResources().getColor(R.color.animalWrong));

                    }
                    else {
                        //wrong Answer
                        textView8.setText("Ήσουν Άτυχος");
                        textView8.setTextColor(getResources().getColor(R.color.animalWrong));

                    }

                    if(radioButton9.isChecked())
                    {
                        finalScore += 1;
                        textView9.setText("Σωστή Απάντηση");
                        textView9.setTextColor(getResources().getColor(R.color.numberQuiz));

                    }
                    else if(radioGroup9.getCheckedRadioButtonId() == -1){
                        //Please select Answer
                        textView9.setText("Ξέχασες να το συμπληρώσεις");
                        textView9.setTextColor(getResources().getColor(R.color.animalWrong));

                    }
                    else {
                        //wrong Answer
                        textView9.setText("Ήσουν Άτυχος");
                        textView9.setTextColor(Color.parseColor("#980000"));

                    }

                    if(radioButton10.isChecked())
                    {
                        finalScore += 1;
                        textView10.setText("Σωστή Απάντηση");
                        textView10.setTextColor(getResources().getColor(R.color.numberQuiz));

                    }
                    else if(radioGroup10.getCheckedRadioButtonId() == -1){
                        //Please select Answer
                        textView10.setText("Ξέχασες να το συμπληρώσεις");
                        textView10.setTextColor(getResources().getColor(R.color.animalWrong));

                    }
                    else {
                        //wrong Answer
                        textView10.setText("Ήσουν Άτυχος");
                        textView10.setTextColor(getResources().getColor(R.color.animalWrong));

                    }



            if (radioGroup1.getCheckedRadioButtonId() == -1 && radioGroup2.getCheckedRadioButtonId() == -1 && radioGroup3.getCheckedRadioButtonId() == -1 && radioGroup4.getCheckedRadioButtonId() == -1 && radioGroup5.getCheckedRadioButtonId() == -1 && radioGroup6.getCheckedRadioButtonId() == -1 && radioGroup7.getCheckedRadioButtonId() == -1 && radioGroup8.getCheckedRadioButtonId() == -1 && radioGroup9.getCheckedRadioButtonId() == -1 && radioGroup10.getCheckedRadioButtonId() == -1  ){
                Toast.makeText(getActivity(),"Το Σκορ σε αυτή την κατηγορία είναι: 0/10", Toast.LENGTH_SHORT).show();
                finalScore = -1;
            } else {
                Toast.makeText(getActivity(),"Το Σκορ σε αυτή την κατηγορία είναι: " + finalScore + "/10", Toast.LENGTH_SHORT).show();
            }

            //Create the object gor the update
            Map<String, Object> scoreUpdate = new HashMap<>();
            scoreUpdate.put("Animals", finalScore);

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
