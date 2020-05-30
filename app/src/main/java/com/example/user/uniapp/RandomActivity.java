package com.example.user.uniapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.uniapp.Common.Common;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RandomActivity extends AppCompatActivity {

    @BindView(R.id.toolRandom) android.support.v7.widget.Toolbar toolbarRandom;

    //RadioGroups
    @BindView(R.id.randomRadioAns1) RadioGroup radioGroup1;
    @BindView(R.id.randomRadioAns2) RadioGroup radioGroup2;
    @BindView(R.id.randomRadioAns3) RadioGroup radioGroup3;
    @BindView(R.id.randomRadioAns4) RadioGroup radioGroup4;
    @BindView(R.id.randomRadioAns5) RadioGroup radioGroup5;
    @BindView(R.id.randomRadioAns6) RadioGroup radioGroup6;
    @BindView(R.id.randomRadioAns7) RadioGroup radioGroup7;
    @BindView(R.id.randomRadioAns8) RadioGroup radioGroup8;
    @BindView(R.id.randomRadioAns9) RadioGroup radioGroup9;
    @BindView(R.id.randomRadioAns10) RadioGroup radioGroup10;

    //RadioButtonsAns
    @BindView(R.id.rRadionButtonAns1) RadioButton radioButton1;
    @BindView(R.id.rRadionButtonAns2) RadioButton radioButton2;
    @BindView(R.id.rRadionButtonAns3) RadioButton radioButton3;
    @BindView(R.id.rRadionButtonAns4) RadioButton radioButton4;
    @BindView(R.id.rRadionButtonAns5) RadioButton radioButton5;
    @BindView(R.id.rRadionButtonAns6) RadioButton radioButton6;
    @BindView(R.id.rRadionButtonAns7) RadioButton radioButton7;
    @BindView(R.id.rRadionButtonAns8) RadioButton radioButton8;
    @BindView(R.id.rRadionButtonAns9) RadioButton radioButton9;
    @BindView(R.id.rRadionButtonAns10) RadioButton radioButton10;

    //SubmitButton
    @BindView(R.id.submitButtonRandom) Button submitButton;

    //TextView
    @BindView(R.id.randomResult1) TextView textView1;
    @BindView(R.id.randomResult2) TextView textView2;
    @BindView(R.id.randomResult3) TextView textView3;
    @BindView(R.id.randomResult4) TextView textView4;
    @BindView(R.id.randomResult5) TextView textView5;
    @BindView(R.id.randomResult6) TextView textView6;
    @BindView(R.id.randomResult7) TextView textView7;
    @BindView(R.id.randomResult8) TextView textView8;
    @BindView(R.id.randomResult9) TextView textView9;
    @BindView(R.id.randomResult10) TextView textView10;
    private int finalScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        ButterKnife.bind(this);
        setSupportActionBar(toolbarRandom);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        submitButton.setOnClickListener(checkTheAnswers);
    }

    private View.OnClickListener checkTheAnswers = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(radioButton1.isChecked())
            {
                finalScore += 1;
                textView1.setText("Σωστή Απάντηση");
                textView1.setTextColor(getResources().getColor(R.color.correctFood));

            }
            else if(radioGroup1.getCheckedRadioButtonId() == -1){
                //Please select Answer
                textView1.setText("Ξέχασες να το συμπληρώσεις");
                textView1.setTextColor(getResources().getColor(R.color.foodWrong));

            }
            else {
                //wrong Answer
                textView1.setText("Ήσουν Άτυχος");
                textView1.setTextColor(getResources().getColor(R.color.foodWrong));

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
                textView3.setTextColor(getResources().getColor(R.color.correctFood));

            }
            else if(radioGroup3.getCheckedRadioButtonId() == -1){
                //Please select Answer
                textView3.setText("Ξέχασες να το συμπληρώσεις");
                textView3.setTextColor(getResources().getColor(R.color.foodWrong));

            }
            else {
                //wrong Answer
                textView3.setText("Ήσουν Άτυχος");
                textView3.setTextColor(getResources().getColor(R.color.foodWrong));

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
                textView5.setTextColor(getResources().getColor(R.color.correctFood));

            }
            else if(radioGroup5.getCheckedRadioButtonId() == -1){
                //Please select Answer
                textView5.setText("Ξέχασες να το συμπληρώσεις");
                textView5.setTextColor(getResources().getColor(R.color.foodWrong));

            }
            else {
                //wrong Answer
                textView5.setText("Ήσουν Άτυχος");
                textView5.setTextColor(getResources().getColor(R.color.foodWrong));

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
                textView7.setTextColor(getResources().getColor(R.color.correctFood));

            }
            else if(radioGroup7.getCheckedRadioButtonId() == -1){
                //Please select Answer
                textView7.setText("Ξέχασες να το συμπληρώσεις");
                textView7.setTextColor(getResources().getColor(R.color.foodWrong));

            }
            else {
                //wrong Answer
                textView7.setText("Ήσουν Άτυχος");
                textView7.setTextColor(getResources().getColor(R.color.foodWrong));

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
                textView9.setTextColor(getResources().getColor(R.color.correctFood));

            }
            else if(radioGroup9.getCheckedRadioButtonId() == -1){
                //Please select Answer
                textView9.setText("Ξέχασες να το συμπληρώσεις");
                textView9.setTextColor(getResources().getColor(R.color.foodWrong));

            }
            else {
                //wrong Answer
                textView9.setText("Ήσουν Άτυχος");
                textView9.setTextColor(getResources().getColor(R.color.foodWrong));

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
                Toast.makeText(RandomActivity.this,"Το Σκορ σε αυτή την κατηγορία είναι: 0/10", Toast.LENGTH_SHORT).show();
                finalScore = -1;
            } else {
                Toast.makeText(RandomActivity.this,"Το Σκορ σε αυτή την κατηγορία είναι: " + finalScore + "/10", Toast.LENGTH_SHORT).show();
            }

            //Create the object gor the update
            Map<String, Object> scoreUpdate = new HashMap<>();
            scoreUpdate.put("Random", finalScore);

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
                            Toast.makeText(RandomActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });

            //Reset the score for the next try
            finalScore = 0;
        }
    };
}
