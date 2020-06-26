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
        for (int i=0 ; i<100; i++) {
            words.add(new item("text1" , "text2"));
        }
        myAdapter items = new myAdapter(this, R.layout.custom_layout_double_text_view, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(items);

    }
}