package com.example.user.uniapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.uniapp.Adapters.ColorsTabAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ColorsActivity extends AppCompatActivity {

    @BindView(R.id.toolColor) android.support.v7.widget.Toolbar toolbarColor;
    @BindView(R.id.tabsColors) TabLayout tabLayoutColors;
    @BindView(R.id.viewpagerColors) ViewPager viewPagerColors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        ButterKnife.bind(this);
        setSupportActionBar(toolbarColor);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ColorsTabAdapter adapter = new ColorsTabAdapter(this, getSupportFragmentManager());
        viewPagerColors.setAdapter(adapter);
        tabLayoutColors.setupWithViewPager(viewPagerColors);
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
                Intent popUp = new Intent(ColorsActivity.this, popUpQuiz.class);
                startActivity(popUp);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
