package com.example.user.uniapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.uniapp.Adapters.AnimalTabAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PetsActivity extends AppCompatActivity {

    @BindView(R.id.toolPets) Toolbar toolbarPets;
    @BindView(R.id.tabsAnimals) TabLayout tabLayoutAnimals;
    @BindView(R.id.viewpagerAnimals) ViewPager viewPagerAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);
        ButterKnife.bind(this);
        setSupportActionBar(toolbarPets);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AnimalTabAdapter adapter = new AnimalTabAdapter(this, getSupportFragmentManager());
        viewPagerAnimal.setAdapter(adapter);
        tabLayoutAnimals.setupWithViewPager(viewPagerAnimal);
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
                Intent popUp = new Intent(PetsActivity.this, popUpQuiz.class);
                startActivity(popUp);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
