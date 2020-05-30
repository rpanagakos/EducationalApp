package com.example.user.uniapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.user.uniapp.Adapters.ProfessorTabAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfessorActivity extends AppCompatActivity {

    @BindView(R.id.toolProfessor) android.support.v7.widget.Toolbar toolbarProfessor;
    @BindView(R.id.tabsProfessor) TabLayout tabLayoutProfessor;
    @BindView(R.id.viewpagerProfessor) ViewPager viewPagerProfessor;
    @BindView(R.id.webViewProf) WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);
        ButterKnife.bind(this);
        setSupportActionBar(toolbarProfessor);

        ProfessorTabAdapter adapter = new ProfessorTabAdapter(this, getSupportFragmentManager());
        viewPagerProfessor.setAdapter(adapter);
        tabLayoutProfessor.setupWithViewPager(viewPagerProfessor);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.professor_menu, menu);
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
            case R.id.logOut:
                Intent signIn = new Intent(ProfessorActivity.this, LogIn.class);
                signIn.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(signIn);
        }
        return super.onOptionsItemSelected(item);
    }
}
