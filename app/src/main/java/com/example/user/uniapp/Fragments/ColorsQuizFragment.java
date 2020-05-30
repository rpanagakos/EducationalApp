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


public class ColorsQuizFragment extends Fragment {

    //EditText
    @BindView(R.id.colorsEditAns1) EditText colorsEditAns1;
    @BindView(R.id.colorsEditAns2) EditText colorsEditAns2;
    @BindView(R.id.colorsEditAns3) EditText colorsEditAns3;
    @BindView(R.id.colorsEditAns4) EditText colorsEditAns4;
    @BindView(R.id.colorsEditAns5) EditText colorsEditAns5;
    @BindView(R.id.colorsEditAns6) EditText colorsEditAns6;
    @BindView(R.id.colorsEditAns7) EditText colorsEditAns7;
    @BindView(R.id.colorsEditAns8) EditText colorsEditAns8;
    @BindView(R.id.colorsEditAns9) EditText colorsEditAns9;
    @BindView(R.id.colorsEditAns10) EditText colorsEditAns10;

    //TextView
    @BindView(R.id.colordAns1) TextView colorsAns1;
    @BindView(R.id.colordAns2) TextView colorsAns2;
    @BindView(R.id.colordAns3) TextView colorsAns3;
    @BindView(R.id.colordAns4) TextView colorsAns4;
    @BindView(R.id.colordAns5) TextView colorsAns5;
    @BindView(R.id.colordAns6) TextView colorsAns6;
    @BindView(R.id.colordAns7) TextView colorsAns7;
    @BindView(R.id.colordAns8) TextView colorsAns8;
    @BindView(R.id.colordAns9) TextView colorsAns9;
    @BindView(R.id.colordAns10) TextView colorsAns10;

    @BindView(R.id.submitButtonColors) Button submitButtonColors;

    private int finalScore;

    public ColorsQuizFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_colors_quiz, container, false);
        ButterKnife.bind(this, root);

        submitButtonColors.setOnClickListener(checkTheAnswers);
        return root;
    }

    private View.OnClickListener checkTheAnswers = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (colorsEditAns1.getText().toString().toLowerCase().equals("black")){
                      finalScore +=1;
                      colorsAns1.setText("Σωστή Απάντηση");
                      colorsAns1.setTextColor(getResources().getColor(R.color.correctFood));
            } else if (colorsEditAns1.getText().toString().toLowerCase().equals("")){
                      colorsAns1.setText("Ξέχασες να το συμπληρώσεις");
                      colorsAns1.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                      colorsAns1.setText(R.string.syntaxError);
                      colorsAns1.setTextColor(getResources().getColor(R.color.animalWrong));
                  }

            if (colorsEditAns2.getText().toString().toLowerCase().equals("brown")){
                finalScore +=1;
                colorsAns2.setText("Σωστή Απάντηση");
                colorsAns2.setTextColor(getResources().getColor(R.color.correctFood));
            } else if (colorsEditAns2.getText().toString().toLowerCase().equals("")){
                colorsAns2.setText("Ξέχασες να το συμπληρώσεις");
                colorsAns2.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                colorsAns2.setText(R.string.syntaxError);
                colorsAns2.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (colorsEditAns3.getText().toString().toLowerCase().equals("green")){
                finalScore +=1;
                colorsAns3.setText("Σωστή Απάντηση");
                colorsAns3.setTextColor(getResources().getColor(R.color.correctFood));
            } else if (colorsEditAns3.getText().toString().toLowerCase().equals("")){
                colorsAns3.setText("Ξέχασες να το συμπληρώσεις");
                colorsAns3.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                colorsAns3.setText(R.string.syntaxError);
                colorsAns3.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (colorsEditAns4.getText().toString().toLowerCase().equals("white")){
                finalScore +=1;
                colorsAns4.setText("Σωστή Απάντηση");
                colorsAns4.setTextColor(getResources().getColor(R.color.correctFood));
            } else if (colorsEditAns4.getText().toString().toLowerCase().equals("")){
                colorsAns4.setText("Ξέχασες να το συμπληρώσεις");
                colorsAns4.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                colorsAns4.setText(R.string.syntaxError);
                colorsAns4.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (colorsEditAns5.getText().toString().toLowerCase().equals("orange")){
                finalScore +=1;
                colorsAns5.setText("Σωστή Απάντηση");
                colorsAns5.setTextColor(getResources().getColor(R.color.correctFood));
            } else if (colorsEditAns5.getText().toString().toLowerCase().equals("")){
                colorsAns5.setText("Ξέχασες να το συμπληρώσεις");
                colorsAns5.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                colorsAns5.setText(R.string.syntaxError);
                colorsAns5.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (colorsEditAns6.getText().toString().toLowerCase().equals("red")){
                finalScore +=1;
                colorsAns6.setText("Σωστή Απάντηση");
                colorsAns6.setTextColor(getResources().getColor(R.color.correctFood));
            } else if (colorsEditAns6.getText().toString().toLowerCase().equals("")){
                colorsAns6.setText("Ξέχασες να το συμπληρώσεις");
                colorsAns6.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                colorsAns6.setText(R.string.syntaxError);
                colorsAns6.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (colorsEditAns7.getText().toString().toLowerCase().equals("pink")){
                finalScore +=1;
                colorsAns7.setText("Σωστή Απάντηση");
                colorsAns7.setTextColor(getResources().getColor(R.color.correctFood));
            } else if (colorsEditAns7.getText().toString().toLowerCase().equals("")){
                colorsAns7.setText("Ξέχασες να το συμπληρώσεις");
                colorsAns7.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                colorsAns7.setText(R.string.syntaxError);
                colorsAns7.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (colorsEditAns8.getText().toString().toLowerCase().equals("purple")){
                finalScore +=1;
                colorsAns8.setText("Σωστή Απάντηση");
                colorsAns8.setTextColor(getResources().getColor(R.color.correctFood));
            } else if (colorsEditAns8.getText().toString().toLowerCase().equals("")){
                colorsAns8.setText("Ξέχασες να το συμπληρώσεις");
                colorsAns8.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                colorsAns8.setText(R.string.syntaxError);
                colorsAns8.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (colorsEditAns9.getText().toString().toLowerCase().equals("blue")){
                finalScore +=1;
                colorsAns9.setText("Σωστή Απάντηση");
                colorsAns9.setTextColor(getResources().getColor(R.color.correctFood));
            } else if (colorsEditAns9.getText().toString().toLowerCase().equals("")){
                colorsAns9.setText("Ξέχασες να το συμπληρώσεις");
                colorsAns9.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                colorsAns9.setText(R.string.syntaxError);
                colorsAns9.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (colorsEditAns10.getText().toString().toLowerCase().equals("black")){
                finalScore +=1;
                colorsAns10.setText("Σωστή Απάντηση");
                colorsAns10.setTextColor(getResources().getColor(R.color.correctFood));
            } else if (colorsEditAns10.getText().toString().toLowerCase().equals("")){
                colorsAns10.setText("Ξέχασες να το συμπληρώσεις");
                colorsAns10.setTextColor(getResources().getColor(R.color.animalWrong));
            }else {
                colorsAns10.setText(R.string.syntaxError);
                colorsAns10.setTextColor(getResources().getColor(R.color.animalWrong));
            }

            if (colorsEditAns1.getText().toString().isEmpty() && colorsEditAns2.getText().toString().isEmpty() && colorsEditAns3.getText().toString().isEmpty() && colorsEditAns4.getText().toString().isEmpty() && colorsEditAns5.getText().toString().isEmpty() && colorsEditAns6.getText().toString().isEmpty() && colorsEditAns7.getText().toString().isEmpty() && colorsEditAns8.getText().toString().isEmpty() && colorsEditAns9.getText().toString().isEmpty() && colorsEditAns10.getText().toString().isEmpty())
            {
                Toast.makeText(getActivity(),"Το Σκορ σε αυτή την κατηγορία είναι: 0/10", Toast.LENGTH_SHORT).show();
                finalScore = -1;
            } else {
                Toast.makeText(getActivity(),"Το Σκορ σε αυτή την κατηγορία είναι: " + finalScore + "/10", Toast.LENGTH_SHORT).show();
            }

            //Create the object gor the update
            Map<String, Object> scoreUpdate = new HashMap<>();
            scoreUpdate.put("Colors", finalScore);

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
