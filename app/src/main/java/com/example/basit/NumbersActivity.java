package com.example.basit;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<item> words = new ArrayList<item>();
        words.add(new item("lutti",  "one", R.drawable.number_one , R.raw.number_one));
        words.add(new item("attiko",  "two" , R.drawable.number_two , R.raw.number_two));
        words.add(new item("tolookosu",  "three", R.drawable.number_three , R.raw.number_three));
        words.add(new item("ayyisa",  "four", R.drawable.number_four, R.raw.number_four));
        words.add(new item("massoka",  "five", R.drawable.number_five, R.raw.number_five));
        words.add(new item("temmokka",  "six", R.drawable.number_six , R.raw.number_six));
        words.add(new item("kenekaku",  "seven" , R.drawable.number_seven , R.raw.number_seven));
        words.add(new item("kawinta",  "eight", R.drawable.number_eight , R.raw.number_eight));
        words.add(new item("wo'e",  "nine", R.drawable.number_nine , R.raw.number_nine));
        words.add(new item("na'aacha",  "ten", R.drawable.number_ten , R.raw.number_ten));


        // Connecting the Custom Adapter Class to out List view
        // and passing in the @ words parameter that is our item list which contains
        // the data that we want out adapter to display in the list view

        myAdapter items = new myAdapter(this, R.layout.custom_layout_double_text_view, words, R.color.categoryNumbers);
         final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(items);

        //  Adding click Listener to the list view so that whenever an item is clicked
        // in the list view, we can know exactly which item is clicked and perform
        // certain actions according to our needs

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