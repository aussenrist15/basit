package com.example.basit;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        ArrayList<item> words = new ArrayList<item>();
        words.add(new item("weṭeṭṭi",  "red" , R.drawable.color_red , R.raw.color_red));
        words.add(new item("chokokki",  "green", R.drawable.color_green , R.raw.color_green));
        words.add(new item("ṭakaakki",  "brown" , R.drawable.color_brown, R.raw.color_brown));
        words.add(new item("ṭopoppi",  "grey" , R.drawable.color_gray , R.raw.color_gray));
        words.add(new item("kululli",  "black", R.drawable.color_black ,R.raw.color_black));
        words.add(new item("kelelli",  "white" , R.drawable.color_white, R.raw.color_white));
        words.add(new item("ṭopiisә",  "dusty yellow", R.drawable.color_dusty_yellow , R.raw.color_dusty_yellow));
        words.add(new item("chiwiiṭә",  "mustard yellow" , R.drawable.color_mustard_yellow , R.raw.color_mustard_yellow));


        myAdapter items = new myAdapter(this, R.layout.custom_layout_double_text_view, words, R.color.categoryColors);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(items);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item current = (item) listView.getAdapter().getItem(i);
                MediaPlayer mMediaPlayer = MediaPlayer.create(getApplicationContext(), current.getMusicSource());
                mMediaPlayer.start();
            }
        });
    }
}