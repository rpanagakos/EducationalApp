package com.example.user.uniapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class SignUp extends AppCompatActivity {

    @BindView(R.id.nameSignUp) EditText editName;
    @BindView(R.id.usernameSignUp) EditText editId;
    @BindView(R.id.passwordSignUp) EditText editPassword;
    @BindView(R.id.signUp) Button btnSignUp;
    @BindView(R.id.toolSignUp) android.support.v7.widget.Toolbar toolbarSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        setSupportActionBar(toolbarSignUp);
        toolbarSignUp.setTitleTextColor(getResources().getColor(R.color.white));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Init  Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
                mDialog.setMessage("Please wait");
                mDialog.show();

                table_user.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Check if students id exists
                        if(editId.getText().toString().isEmpty()){

                            Toast.makeText(SignUp.this, "Please enter your Username", Toast.LENGTH_SHORT).show();
                            mDialog.dismiss();

                        }
                        else {
                            if (dataSnapshot.child(editId.getText().toString()).exists()) {
                                mDialog.dismiss();
                                Toast.makeText(SignUp.this, "The Username already exists", Toast.LENGTH_SHORT).show();
                            } else {
                                if (editName.getText().toString().isEmpty()) {
                                    Toast.makeText(SignUp.this, "Please enter your Name", Toast.LENGTH_SHORT).show();
                                    mDialog.dismiss();
                                }
                                else{
                                    if(editPassword.getText().toString().isEmpty()){
                                        Toast.makeText(SignUp.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                                        mDialog.dismiss();
                                    }
                                    else{
                                        mDialog.dismiss();
                                        User user = new User(0,0 ,0 ,0,editName.getText().toString(),0,0,editId.getText().toString(),editPassword.getText().toString());
                                        table_user.child(editId.getText().toString()).setValue(user);
                                        Toast.makeText(SignUp.this, "Connected", Toast.LENGTH_SHORT).show();
                                        Intent homeIntent = new Intent(SignUp.this, MainActivity.class);
                                        Common.currentUser = user;
                                        startActivity(homeIntent);
                                        finish();
                                    }
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
}
