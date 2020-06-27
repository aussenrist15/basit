package com.example.basit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<item> words = new ArrayList<item>();
        words.add(new item("lutti",  "one", R.drawable.number_one));
        words.add(new item("attiko",  "two" , R.drawable.number_two));
        words.add(new item("tolookosu",  "three", R.drawable.number_three));
        words.add(new item("ayyisa",  "four", R.drawable.number_four));
        words.add(new item("massoka",  "five", R.drawable.number_five));
        words.add(new item("temmokka",  "six", R.drawable.number_six));
        words.add(new item("kenekaku",  "seven" , R.drawable.number_seven));
        words.add(new item("kawinta",  "eight", R.drawable.number_eight));
        words.add(new item("wo'e",  "nine", R.drawable.number_nine));
        words.add(new item("na'aacha",  "ten", R.drawable.number_ten));



        myAdapter items = new myAdapter(this, R.layout.custom_layout_double_text_view, words, R.color.categoryNumbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(items);

    }
}