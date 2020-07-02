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


public class ColorsFragment extends Fragment {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    public ColorsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_numbers, container, false);
        ArrayList<item> words = new ArrayList<item>();
        words.add(new item("weṭeṭṭi",  "red" , R.drawable.color_red , R.raw.color_red));
        words.add(new item("chokokki",  "green", R.drawable.color_green , R.raw.color_green));
        words.add(new item("ṭakaakki",  "brown" , R.drawable.color_brown, R.raw.color_brown));
        words.add(new item("ṭopoppi",  "grey" , R.drawable.color_gray , R.raw.color_gray));
        words.add(new item("kululli",  "black", R.drawable.color_black ,R.raw.color_black));
        words.add(new item("kelelli",  "white" , R.drawable.color_white, R.raw.color_white));
        words.add(new item("ṭopiisә",  "dusty yellow", R.drawable.color_dusty_yellow , R.raw.color_dusty_yellow));
        words.add(new item("chiwiiṭә",  "mustard yellow" , R.drawable.color_mustard_yellow , R.raw.color_mustard_yellow));


        myAdapter items = new myAdapter(getActivity(), R.layout.custom_layout_double_text_view, words, R.color.categoryColors);
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