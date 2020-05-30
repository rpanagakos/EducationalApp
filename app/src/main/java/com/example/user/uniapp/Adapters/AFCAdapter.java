package com.example.user.uniapp.Adapters;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.uniapp.Class.Word;
import com.example.user.uniapp.R;

import java.util.ArrayList;

public class AFCAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public AFCAdapter(Activity context, ArrayList<Word> Words, int colorResourceId){
        super(context,0, Words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_afc, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID eng_text_view.
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.eng_text_view_afc);
        englishTextView.setText(currentWord.getEnWord());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view_afc);
        defaultTextView.setText(currentWord.getGrWord());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.imageAFC);
        imageView.setImageResource(currentWord.getImage());

        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.linear_container_afc);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        linearLayout.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
