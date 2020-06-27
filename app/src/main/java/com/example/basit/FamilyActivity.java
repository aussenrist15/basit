package com.example.basit;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        ArrayList<item> words = new ArrayList<item>();
        words.add(new item("әpә",  "father", R.drawable.family_father , R.raw.family_father));
        words.add(new item("әṭa",  "mother", R.drawable.family_mother , R.raw.family_mother));
        words.add(new item("angsi",  "son" , R.drawable.family_son , R.raw.family_son));
        words.add(new item("tune",  "daughter", R.drawable.family_daughter , R.raw.family_daughter));
        words.add(new item("taachi",  "older brother", R.drawable.family_older_brother , R.raw.family_older_brother));
        words.add(new item("chalitti",  "younger brother", R.drawable.family_younger_brother , R.raw.family_younger_brother));
        words.add(new item("teṭe",  "older sister" , R.drawable.family_older_sister , R.raw.family_older_sister));
        words.add(new item("kolliti",  "younger sister", R.drawable.family_younger_sister , R.raw.family_younger_sister));
        words.add(new item("ama",  "grandmother" , R.drawable.family_grandmother , R.raw.family_grandmother));
        words.add(new item("paapa",  "grandfather" , R.drawable.family_grandfather, R.raw.family_grandfather));




        myAdapter items = new myAdapter(this, R.layout.custom_layout_double_text_view, words, R.color.categoryFamily);
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