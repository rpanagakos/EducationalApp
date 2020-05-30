package com.example.user.uniapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.uniapp.Class.User;
import com.example.user.uniapp.Common.Common;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountActivity extends AppCompatActivity {

    @BindView(R.id.toolAccount) android.support.v7.widget.Toolbar toolbarColor;

    @BindView(R.id.colorsScore) TextView colorsScore;
    @BindView(R.id.numbersScore) TextView numbersScore;
    @BindView(R.id.foodScore) TextView foodScore;
    @BindView(R.id.animalsScore) TextView animalsScore;
    @BindView(R.id.nameTextView) TextView nameText;
    @BindView(R.id.randomScore) TextView randomScore;

    @BindView(R.id.buttonLogOut) Button button;

    FirebaseDatabase database;
    DatabaseReference user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ButterKnife.bind(this);
        setSupportActionBar(toolbarColor);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        database = FirebaseDatabase.getInstance();
        user = database.getReference("User");

        button.setOnClickListener(logOut);

        getDetails(Common.currentUser.getStudentId());

    }

    private void getDetails(final String studentId)
    {
        user.child(studentId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);

                if (user.getAnimals() == -1){
                    animalsScore.setText("0");
                }else{
                    animalsScore.setText(String.valueOf(user.getAnimals()));
                }
                if (user.getColors() == -1){
                    colorsScore.setText("0");
                }else{
                    colorsScore.setText(String.valueOf(user.getColors()));
                }
                if (user.getNumbers() == -1){
                    numbersScore.setText("0");
                }else {
                    numbersScore.setText(String.valueOf(user.getNumbers()));
                }
                if (user.getFood() == -1){
                    foodScore.setText("0");
                }else {
                    foodScore.setText(String.valueOf(user.getFood()));
                }
                if (user.getRandom() == -1){
                    randomScore.setText("0");
                } else {
                    randomScore.setText(String.valueOf(user.getRandom()));

                }
                nameText.setText(user.getName());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private final View.OnClickListener logOut = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent signIn = new Intent(AccountActivity.this, LogIn.class);
            signIn.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(signIn);
        }
    };
}
