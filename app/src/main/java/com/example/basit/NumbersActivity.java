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
        words.add(new item("lutti",  "one"));
        words.add(new item("attiko",  "two"));
        words.add(new item("tolookosu",  "three"));
        words.add(new item("ayyisa",  "four"));
        words.add(new item("massoka",  "five"));
        words.add(new item("temmokka",  "six"));
        words.add(new item("kenekaku",  "seven"));
        words.add(new item("kawinta",  "eight"));
        words.add(new item("wo'e",  "nine"));
        words.add(new item("na'aacha",  "ten"));



        myAdapter items = new myAdapter(this, R.layout.custom_layout_double_text_view, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(items);

    }
}