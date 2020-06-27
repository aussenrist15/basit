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
        words.add(new item("әpә",  "father", R.drawable.family_father));
        words.add(new item("әṭa",  "mother", R.drawable.family_mother));
        words.add(new item("angsi",  "son" , R.drawable.family_son));
        words.add(new item("tune",  "daughter", R.drawable.family_daughter));
        words.add(new item("taachi",  "older brother", R.drawable.family_older_brother));
        words.add(new item("chalitti",  "younger brother", R.drawable.family_younger_brother));
        words.add(new item("teṭe",  "older sister" , R.drawable.family_older_sister));
        words.add(new item("kolliti",  "younger sister", R.drawable.family_younger_sister));
        words.add(new item("ama",  "grandmother" , R.drawable.family_grandmother));
        words.add(new item("paapa",  "grandfather" , R.drawable.family_grandfather));



        myAdapter items = new myAdapter(this, R.layout.custom_layout_double_text_view, words, R.color.categoryFamily);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(items);
    }
}