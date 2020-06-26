package com.example.basit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.custom_layout_double_text_view, null);
        TextView textView1 = (TextView)v.findViewById(R.id.textView1);
        TextView textView2 = (TextView)v.findViewById(R.id.textView2);
        textView1.setText(List.get(position).getText1());
        textView2.setText(List.get(position).getText2());
        return v;

    }

}
