package com.example.basit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        ArrayList<item> words = new ArrayList<item>();
        words.add(new item("weṭeṭṭi",  "red"));
        words.add(new item("chokokki",  "green"));
        words.add(new item("ṭakaakki",  "brown"));
        words.add(new item("ṭopoppi",  "grey"));
        words.add(new item("kululli",  "black"));
        words.add(new item("kelelli",  "white"));
        words.add(new item("ṭopiisә",  "dusty yellow"));
        words.add(new item("chiwiiṭә",  "mustard yellow"));


        myAdapter items = new myAdapter(this, R.layout.custom_layout_double_text_view, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(items);
    }
}