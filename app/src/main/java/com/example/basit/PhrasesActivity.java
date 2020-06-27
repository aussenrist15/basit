package com.example.basit;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        ArrayList<item> words = new ArrayList<item>();
        words.add(new item("minto wuksus",  "Where are you going?" , R.raw.phrase_where_are_you_going));
        words.add(new item("tinnә oyaase'nә", "What is your name?" , R.raw.phrase_what_is_your_name));
        words.add(new item("oyaaset",  "My name is" , R.raw.phrase_my_name_is));
        words.add(new item("michәksәs?",  "How are you feeling?" , R.raw.phrase_how_are_you_feeling));
        words.add(new item("kuchi achit",  "I’m feeling good" , R.raw.phrase_im_feeling_good));
        words.add(new item("әәnәs'aa?",  "Are you coming?" , R.raw.phrase_are_you_coming));
        words.add(new item("hәә’ әәnәm",  "Yes, I’m coming" , R.raw.phrase_yes_im_coming));
        words.add(new item("әәnәm",  "I’m coming." , R.raw.phrase_im_coming));
        words.add(new item("yoowutis",  "Let’s go" , R.raw.phrase_lets_go));
        words.add(new item("әnni'nem",  "Come here" , R.raw.phrase_come_here));



        /*
        * For the explanation of the lines below, see { NumbersActivity.java }  file. Everything
        * used below is there well commented.
         */



        myAdapter items = new myAdapter(this, R.layout.custom_layout_double_text_view, words, R.color.catgoryPhrases);
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