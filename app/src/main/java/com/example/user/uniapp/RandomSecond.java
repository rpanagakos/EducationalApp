package com.example.user.uniapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class RandomSecond extends AppCompatActivity {


    //EditTexts
    @BindView(R.id.randomEditAns1) EditText randomEditAns1;
    @BindView(R.id.randomEditAns2) EditText randomEditAns2;
    @BindView(R.id.randomEditAns3) EditText randomEditAns3;
    @BindView(R.id.randomEditAns4) EditText randomEditAns4;
    @BindView(R.id.randomEditAns5) EditText randomEditAns5;
    @BindView(R.id.randomEditAns6) EditText randomEditAns6;
    @BindView(R.id.randomEditAns7) EditText randomEditAns7;
    @BindView(R.id.randomEditAns8) EditText randomEditAns8;
    @BindView(R.id.randomEditAns9) EditText randomEditAns9;
    @BindView(R.id.randomEditAns10) EditText randomEditAns10;

    //TextViews
    @BindView(R.id.randomAns1) TextView randomAns1;
    @BindView(R.id.randomAns2) TextView randomAns2;
    @BindView(R.id.randomAns3) TextView randomAns3;
    @BindView(R.id.randomAns4) TextView randomAns4;
    @BindView(R.id.randomAns5) TextView randomAns5;
    @BindView(R.id.randomAns6) TextView randomAns6;
    @BindView(R.id.randomAns7) TextView randomAns7;
    @BindView(R.id.randomAns8) TextView randomAns8;
    @BindView(R.id.randomAns9) TextView randomAns9;
    @BindView(R.id.randomAns10) TextView randomAns10;

    //Button
    @BindView(R.id.submitButtonRandom2) Button submitButton;

    @BindView(R.id.toolRandomSec) android.support.v7.widget.Toolbar toolbar;

    private int finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_second);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        submitButton.setOnClickListener(checkTheAnswers);

    }

    private View.OnClickListener checkTheAnswers = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (randomEditAns1.getText().toString().toLowerCase().equals("black")){
                finalScore +=1;
                randomAns1.setText("Σωστή Απάντηση");
                randomAns1.setTextColor(getResources().getColor(R.color.correctFood));
            } else if (randomEditAns1.getText().toString().toLowerCase().equals("")){
                randomAns1.setText("Ξέχασες να το συμπληρώσεις");
                randomAns1.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                randomAns1.setText(R.string.syntaxError);
                randomAns1.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (randomEditAns2.getText().toString().toLowerCase().equals("four")){
                finalScore +=1;
                randomAns2.setText("Σωστή Απάντηση");
                randomAns2.setTextColor(getResources().getColor(R.color.correctFood));
            }else if(randomEditAns2.getText().toString().toLowerCase().equals("")){
                randomAns2.setText("Ξέχασες να το συμπληρώσεις");
                randomAns2.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                randomAns2.setText(R.string.syntaxError);
                randomAns2.setTextColor(getResources().getColor(R.color.animalWrong));
            }


            if (randomEditAns3.getText().toString().toLowerCase().equals("green")){
                finalScore +=1;
                randomAns3.setText("Σωστή Απάντηση");
                randomAns3.setTextColor(getResources().getColor(R.color.correctFood));
            } else if (randomEditAns3.getText().toString().toLowerCase().equals("")){
                randomAns3.setText("Ξέχασες να το συμπληρώσεις");
                randomAns3.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                randomAns3.setText(R.string.syntaxError);
                randomAns3.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (randomEditAns4.getText().toString().toLowerCase().equals("five")){
                finalScore +=1;
                randomAns4.setText("Σωστή Απάντηση");
                randomAns4.setTextColor(getResources().getColor(R.color.correctFood));
            }else if(randomEditAns4.getText().toString().toLowerCase().equals("")){
                randomAns4.setText("Ξέχασες να το συμπληρώσεις");
                randomAns4.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                randomAns4.setText(R.string.syntaxError);
                randomAns4.setTextColor(getResources().getColor(R.color.animalWrong));
            }


            if (randomEditAns5.getText().toString().toLowerCase().equals("orange")){
                finalScore +=1;
                randomAns5.setText("Σωστή Απάντηση");
                randomAns5.setTextColor(getResources().getColor(R.color.correctFood));
            } else if (randomEditAns5.getText().toString().toLowerCase().equals("")){
                randomAns5.setText("Ξέχασες να το συμπληρώσεις");
                randomAns5.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                randomAns5.setText(R.string.syntaxError);
                randomAns5.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (randomEditAns6.getText().toString().toLowerCase().equals("two")){
                finalScore +=1;
                randomAns6.setText("Σωστή Απάντηση");
                randomAns6.setTextColor(getResources().getColor(R.color.correctFood));
            }else if(randomEditAns6.getText().toString().toLowerCase().equals("")){
                randomAns6.setText("Ξέχασες να το συμπληρώσεις");
                randomAns6.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                randomAns6.setText(R.string.syntaxError);
                randomAns6.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (randomEditAns7.getText().toString().toLowerCase().equals("red")){
                finalScore +=1;
                randomAns7.setText("Σωστή Απάντηση");
                randomAns7.setTextColor(getResources().getColor(R.color.correctFood));
            } else if (randomEditAns7.getText().toString().toLowerCase().equals("")){
                randomAns7.setText("Ξέχασες να το συμπληρώσεις");
                randomAns7.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                randomAns7.setText(R.string.syntaxError);
                randomAns7.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (randomEditAns8.getText().toString().toLowerCase().equals("ten")){
                finalScore +=1;
                randomAns8.setText("Σωστή Απάντηση");
                randomAns8.setTextColor(getResources().getColor(R.color.correctFood));
            }else if(randomEditAns8.getText().toString().toLowerCase().equals("")){
                randomAns8.setText("Ξέχασες να το συμπληρώσεις");
                randomAns8.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                randomAns8.setText(R.string.syntaxError);
                randomAns8.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (randomEditAns9.getText().toString().toLowerCase().equals("blue")){
                finalScore +=1;
                randomAns9.setText("Σωστή Απάντηση");
                randomAns9.setTextColor(getResources().getColor(R.color.correctFood));
            } else if (randomEditAns9.getText().toString().toLowerCase().equals("")){
                randomAns9.setText("Ξέχασες να το συμπληρώσεις");
                randomAns9.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                randomAns9.setText(R.string.syntaxError);
                randomAns9.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (randomEditAns10.getText().toString().toLowerCase().equals("six")){
                finalScore +=1;
                randomAns10.setText("Σωστή Απάντηση");
                randomAns10.setTextColor(getResources().getColor(R.color.correctFood));
            }else if(randomEditAns10.getText().toString().toLowerCase().equals("")){
                randomAns10.setText("Ξέχασες να το συμπληρώσεις");
                randomAns10.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                randomAns10.setText(R.string.syntaxError);
                randomAns10.setTextColor(getResources().getColor(R.color.animalWrong));
            }




            if (randomEditAns1.getText().toString().isEmpty() && randomEditAns2.getText().toString().isEmpty() && randomEditAns3.getText().toString().isEmpty() && randomEditAns4.getText().toString().isEmpty() && randomEditAns5.getText().toString().isEmpty() && randomEditAns6.getText().toString().isEmpty() && randomEditAns7.getText().toString().isEmpty() && randomEditAns8.getText().toString().isEmpty() && randomEditAns9.getText().toString().isEmpty() && randomEditAns10.getText().toString().isEmpty())
            {
                Toast.makeText(RandomSecond.this,"Το Σκορ σε αυτή την κατηγορία είναι: 0/10", Toast.LENGTH_SHORT).show();
                finalScore = -1;
            } else {
                Toast.makeText(RandomSecond.this,"Το Σκορ σε αυτή την κατηγορία είναι: " + finalScore + "/10", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(RandomSecond.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });

            //Reset the score for the next try
            finalScore = 0;

        }
    };

}
