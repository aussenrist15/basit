package com.example.basit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/*
* This is a custom adapter to display two TextViews in the ListView.
* This was coded by @aussenrist15 (Abdul Basit)
 */

public class myAdapter extends ArrayAdapter<item> {
    ArrayList<item> List = new ArrayList<>();

    public myAdapter(Context context, int textViewResourceId, ArrayList<item> objects) {
        super(context, textViewResourceId, objects);
        List = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        // Inflating the view because {@ custom_layout_double_text_view} is not in the @View v
        // variable yet. We have to add it in order to work with it by inflating it using
        // the built in inflater class.

        // After inflating the custom layout, we use the TextViews or whatsoever to
        // fill in the data. See the {@ custom_layout_double_text_view.xml} file to
        // check how I built a custom layout to go with the adapter according to my needs.

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.custom_layout_double_text_view, null);
        TextView textView1 = (TextView)v.findViewById(R.id.textView1);
        TextView textView2 = (TextView)v.findViewById(R.id.textView2);
        textView1.setText(List.get(position).getText1());
        textView2.setText(List.get(position).getText2());
        return v;

    }

}
