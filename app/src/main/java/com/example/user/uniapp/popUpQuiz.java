package com.example.user.uniapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class popUpQuiz extends AppCompatActivity {

    @BindView(R.id.okActButton) Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_quiz);
        ButterKnife.bind(this);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.65));

        okButton.setOnClickListener(closeDialog);

    }

    private final View.OnClickListener closeDialog = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

}
