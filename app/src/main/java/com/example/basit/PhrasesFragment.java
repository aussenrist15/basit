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


public class PhrasesFragment extends Fragment {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    public PhrasesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_numbers, container, false);
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







        myAdapter items = new myAdapter(getActivity(), R.layout.custom_layout_double_text_view, words, R.color.catgoryPhrases);
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