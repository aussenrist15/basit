package com.example.basit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        ArrayList<item> words = new ArrayList<item>();
        words.add(new item("әpә",  "father"));
        words.add(new item("әṭa",  "mother"));
        words.add(new item("angsi",  "son"));
        words.add(new item("tune",  "daughter"));
        words.add(new item("taachi",  "older brother"));
        words.add(new item("chalitti",  "younger brother"));
        words.add(new item("teṭe",  "older sister"));
        words.add(new item("kolliti",  "younger sister"));
        words.add(new item("ama",  "grandmother"));
        words.add(new item("paapa",  "grandfather"));



        myAdapter items = new myAdapter(this, R.layout.custom_layout_double_text_view, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(items);
    }
}