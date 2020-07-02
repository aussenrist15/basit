package com.example.basit;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class NumbersFragment extends Fragment {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    public NumbersFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_numbers, container, false);
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


        myAdapter items = new myAdapter(getActivity(), R.layout.custom_layout_double_text_view, words, R.color.categoryNumbers);
        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(items);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                releaseMediaPlayer();
                item current = (item) listView.getAdapter().getItem(i);
                mMediaPlayer = MediaPlayer.create(getActivity(), current.getMusicSource());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);


            }
        });



        return rootView;

    }
    @Override
    public void onStop() {
        super.onStop();

        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {

        if (mMediaPlayer != null) {

            mMediaPlayer.release();

            mMediaPlayer = null;

        }
    }
}