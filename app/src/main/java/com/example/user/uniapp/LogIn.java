package com.example.user.uniapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.uniapp.Class.User;
import com.example.user.uniapp.Common.Common;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogIn extends AppCompatActivity {

    @BindView(R.id.username) EditText usernameEdit;
    @BindView(R.id.password) EditText passwordEdit;
    @BindView(R.id.logIn) Button loginButton;
    @BindView(R.id.signUpButton) TextView singUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);

        //Init  Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        singUpButton.setOnClickListener(goToSignUp);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(LogIn.this);
                mDialog.setMessage("Please wait");
                mDialog.show();

                table_user.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Check if user doesnt exist in database
                        DataSnapshot data = dataSnapshot;

                        if(usernameEdit.getText().toString().isEmpty()){
                            Toast.makeText(LogIn.this, "Enter username", Toast.LENGTH_SHORT).show();
                            mDialog.dismiss();
                        }
                        else
                        {
                            if(usernameEdit.getText().toString().equals("teacher")){
                                if(passwordEdit.getText().toString().equals("12345")){
                                    Intent homeIntent = new Intent(LogIn.this, ProfessorActivity.class);
                                    startActivity(homeIntent);
                                    finish();
                                }else if(passwordEdit.getText().toString().isEmpty()){
                                    Toast.makeText(LogIn.this, "Enter password", Toast.LENGTH_SHORT).show();
                                    mDialog.dismiss();
                                }else {
                                    Toast.makeText(LogIn.this, "Log in Failed", Toast.LENGTH_SHORT).show();
                                    mDialog.dismiss();
                                }
                            }
                            else {

                                if (dataSnapshot.child(usernameEdit.getText().toString()).exists()) {

                                    //Get Users information

                                    mDialog.dismiss();
                                    User user = dataSnapshot.child(usernameEdit.getText().toString()).getValue(User.class);

                                    if (passwordEdit.getText().toString().isEmpty()) {
                                        Toast.makeText(LogIn.this, "Enter password", Toast.LENGTH_SHORT).show();
                                        mDialog.dismiss();

                                    } else {

                                        if (user.getPassword().equals(passwordEdit.getText().toString())) {
                                            Intent homeIntent = new Intent(LogIn.this, MainActivity.class);
                                            Common.currentUser = user;
                                            startActivity(homeIntent);
                                            finish();

                                            table_user.removeEventListener(this);

                                        } else {
                                            Toast.makeText(LogIn.this, "Log in Failed", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                } else {
                                    mDialog.dismiss();
                                    Toast.makeText(LogIn.this, "User doesn't exist", Toast.LENGTH_SHORT).show();

                                }
                            }
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    private View.OnClickListener goToSignUp = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent signUpIntent = new Intent(LogIn.this, SignUp.class);
            startActivity(signUpIntent);
        }
    };
}
