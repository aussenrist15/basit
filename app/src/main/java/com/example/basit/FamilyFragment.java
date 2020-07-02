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


public class FamilyFragment extends Fragment {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    public FamilyFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_numbers, container, false);
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




        myAdapter items = new myAdapter(getActivity(), R.layout.custom_layout_double_text_view, words, R.color.categoryFamily);
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