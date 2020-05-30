package com.example.user.uniapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.uniapp.Adapters.FoodTabAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodActivity extends AppCompatActivity {

    @BindView(R.id.toolFamily) Toolbar toolbarFamily;
    @BindView(R.id.tabsFood) TabLayout tabLayoutFood;
    @BindView(R.id.viewpagerFood) ViewPager viewPagerFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        ButterKnife.bind(this);
        setSupportActionBar(toolbarFamily);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FoodTabAdapter adapter = new FoodTabAdapter(this, getSupportFragmentManager());
        viewPagerFood.setAdapter(adapter);
        tabLayoutFood.setupWithViewPager(viewPagerFood);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawermenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.info:
                Intent popUp = new Intent(FoodActivity.this, popUpQuiz.class);
                startActivity(popUp);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
