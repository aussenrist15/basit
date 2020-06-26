package com.example.basit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        ArrayList<item> words = new ArrayList<item>();
        words.add(new item("minto wuksus",  "Where are you going?"));
        words.add(new item("tinnә oyaase'nә", "What is your name?"));
        words.add(new item("oyaaset",  "My name is"));
        words.add(new item("michәksәs?",  "How are you feeling?"));
        words.add(new item("kuchi achit",  "I’m feeling good"));
        words.add(new item("әәnәs'aa?",  "Are you coming?"));
        words.add(new item("hәә’ әәnәm",  "Yes, I’m coming"));
        words.add(new item("әәnәm",  "I’m coming."));
        words.add(new item("yoowutis",  "Let’s go"));
        words.add(new item("әnni'nem",  "Come here"));


        myAdapter items = new myAdapter(this, R.layout.custom_layout_double_text_view, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(items);

    }
}