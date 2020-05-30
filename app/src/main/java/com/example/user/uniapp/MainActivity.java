package com.example.user.uniapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
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

public class MainActivity extends AppCompatActivity {

    //CarsViews
    @BindView(R.id.colorsCard) CardView colorsCard;
    @BindView(R.id.numbersCard) CardView numbersCard;
    @BindView(R.id.familyCard) CardView familyCard;
    @BindView(R.id.petsCard) CardView petsCard;
    @BindView(R.id.randomCard) CardView randomCard;

    //LinearLayout
    @BindView(R.id.circleColors) LinearLayout circleColors;
    @BindView(R.id.circleAnimals) LinearLayout circleAnimals;
    @BindView(R.id.circleFood) LinearLayout circleFood;
    @BindView(R.id.circleNumbers) LinearLayout circleNumbers;
    @BindView(R.id.circleRandom) LinearLayout circleRandom;

    @BindView(R.id.titleText) TextView title;
    //ToolBar
    @BindView(R.id.toolMain) Toolbar toolbarMain;
    @BindView(R.id.webView) WebView webView;

    FirebaseDatabase database;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbarMain.setTitle("");
        setSupportActionBar(toolbarMain);

        //Firebase
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("User");

        //Buttons
        colorsCard.setOnClickListener(onClickChange);
        numbersCard.setOnClickListener(onClickChange);
        familyCard.setOnClickListener(onClickChange);
        petsCard.setOnClickListener(onClickChange);
        randomCard.setOnClickListener(onClickChange);

        getDetails(Common.currentUser.getStudentId());
    }

    private void getDetails(final String studentId)
    {
        databaseReference.child(studentId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);


                int foodLinear = changeColor(user.getFood());
                int animalLinear = changeColor(user.getAnimals());
                int numberLinear = changeColor(user.getNumbers());
                int colorLinear = changeColor(user.getColors());
                int randomLinear = changeColor(user.getRandom());

                circleColors.setBackgroundResource(colorLinear);
                circleFood.setBackgroundResource(foodLinear);
                circleAnimals.setBackgroundResource(animalLinear);
                circleNumbers.setBackgroundResource(numberLinear);
                circleRandom.setBackgroundResource(randomLinear);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private View.OnClickListener onClickChange = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.colorsCard:
                    Intent colorsList = new Intent(MainActivity.this, ColorsActivity.class);
                    startActivity(colorsList);
                    break;
                case R.id.familyCard:
                    Intent familyList = new Intent(MainActivity.this, FoodActivity.class);
                    startActivity(familyList);
                    break;
                case R.id.numbersCard:
                    Intent numbersList = new Intent(MainActivity.this, NumbersActivity.class);
                    startActivity(numbersList);
                    break;
                case R.id.petsCard:
                    Intent petsList = new Intent(MainActivity.this, PetsActivity.class);
                    startActivity(petsList);
                    break;
                case R.id.randomCard:
                    if (Common.random == 0){
                        Intent randomList = new Intent(MainActivity.this, RandomActivity.class);
                        startActivity(randomList);
                        Common.random = 1;
                        break;
                    }else {
                        Intent randomList = new Intent(MainActivity.this, RandomSecond.class);
                        startActivity(randomList);
                        Common.random = 0;
                        break;
                    }

            }

        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.info:
                WebSettings settings = webView.getSettings();
                //settings.setJavaScriptEnabled(true);

                webView.loadUrl("https://drive.google.com/open?id=1nDEmMSBkz3l27JiXShGPJuWrpwQmSiko");
                break;
            case R.id.account:
                Intent account = new Intent(MainActivity.this, AccountActivity.class);
                startActivity(account);
        }
        return super.onOptionsItemSelected(item);
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
