package com.example.user.uniapp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.uniapp.R;

public class StudentViewHolder extends RecyclerView.ViewHolder{

    public TextView studentName, studentGrade;
    public LinearLayout circleBackground;

    public StudentViewHolder(View itemView) {
        super(itemView);

        studentName = (TextView) itemView.findViewById(R.id.studentName);
        studentGrade = (TextView) itemView.findViewById(R.id.studentGrade);
        circleBackground = (LinearLayout) itemView.findViewById(R.id.circleBackgroundProfessor);

    }
}
