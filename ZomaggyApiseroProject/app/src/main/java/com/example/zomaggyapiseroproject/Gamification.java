package com.example.zomaggyapiseroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Gamification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamification);

        getSupportActionBar().setTitle("Gamification Panel");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }
}