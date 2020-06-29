package com.example.basit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        TextView col = (TextView)findViewById(R.id.colors);
        TextView fam = (TextView)findViewById(R.id.family);
        TextView num = (TextView)findViewById(R.id.numbers);
        TextView phr = (TextView)findViewById(R.id.phrases);


        //Adding event listeners
        //for each of the buttons

        col.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                // To go to another screen

                Intent intent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(intent);
            }
        });


        fam.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(intent);
            }
        });

        num.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(intent);
            }
        });

        phr.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(intent);
            }
        });


    }





}
