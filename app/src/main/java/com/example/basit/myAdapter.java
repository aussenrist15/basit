package com.example.basit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

/*
*
* This is a custom adapter to display two TextViews and an ImageView in
* the list.
*
*/


    // The ArrayAdapter class is a default class that is provided by Java to display the items of
    // an Array or an ArrayList on the screen in form of a List that can scroll down.

    /******************************

        How ArrayAdapter Works

     *****************************/

    // The array adapter uses a layout and a ListView to display item.
    //  ArrayAdapter<T> obj = new ArrayAdapter <T> (context , layout , Obj[] )
    // @param ::
    // context : The context of application. Usually we pass "this" as the context
    // layout : The layout in which we want to present data. The default layout provided by
    //android contains only one single text view.
    // Obj[] : The array of objects we want to print. In case of default layout we can only use String
    //because default layout has only single text view and cant print more than one item per list-item


    // So below is the creation of a custom adapter. We have created a custom layout XML file
    // to check the custom layout, see { custom_layout_double_text_view.xml } file. It contains 2 text views
    // and 1 image views
    // We need to give each view an Id so that we can refer to them here


public class myAdapter extends ArrayAdapter<item> {
    ArrayList<item> List = new ArrayList<>();
    private int mColorResourceId;

    public myAdapter(Context context, int textViewResourceId, ArrayList<item> objects, int colrRsrc) {
        super(context, textViewResourceId, objects);
        List = objects;
        mColorResourceId = colrRsrc;
    }

    @Override
    public int getCount() {
        return super.getCount(); // This code is auto generated. No need to remember this
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
        item current = getItem(position);
        TextView textView1 = (TextView)v.findViewById(R.id.textView1);
        TextView textView2 = (TextView)v.findViewById(R.id.textView2);
        textView1.setText(List.get(position).getText1());
        textView2.setText(List.get(position).getText2());
        ImageView img = (ImageView)v.findViewById(R.id.imgView);
        if(current.hasImg()){
            img.setImageResource(current.getImgRes());
            img.setVisibility(View.VISIBLE);

        }
        else {
            img.setVisibility(View.GONE);
        }
        View textConnt = v.findViewById(R.id.textContainer);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textConnt.setBackgroundColor(color);

        return v;

    }

}
