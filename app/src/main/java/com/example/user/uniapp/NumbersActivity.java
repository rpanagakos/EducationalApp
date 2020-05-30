package com.example.user.uniapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.uniapp.Adapters.NumbersTabAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NumbersActivity extends AppCompatActivity {


    //ActionBar
    @BindView(R.id.toolNumber) Toolbar toolbarNumber;
    //ViewPager
    @BindView(R.id.viewpagerNumbers) ViewPager viewPager;
    @BindView(R.id.tabsNumbers) TabLayout tabLayoutNumbers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ButterKnife.bind(this);
        setSupportActionBar(toolbarNumber);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NumbersTabAdapter adapter = new NumbersTabAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayoutNumbers.setupWithViewPager(viewPager);
    }


    //Creating the menu for the ActionBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawermenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.info:
                Intent popUp = new Intent(NumbersActivity.this, popUpQuiz.class);
                startActivity(popUp);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
