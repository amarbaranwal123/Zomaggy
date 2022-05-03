package com.example.zomaggyapiseroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Recommendation extends AppCompatActivity {

    ImageView i1,i2;
    String userID;
    String city="Varanasi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy3 = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy3);
        setContentView(R.layout.activity_recommendation);

        getSupportActionBar().setTitle("Recommended Panel");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        i1=findViewById(R.id.i1);
       i2=findViewById(R.id.i2);
        //i3=findViewById(R.id.i3);

        i1.setAlpha(90);
        i2.setAlpha(90);
        //i3.setAlpha(60);

        userID=getIntent().getStringExtra("user_id");
        Log.i("In Recommendation Activity",userID);





        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Recommendation.this,CityActivity.class);
                intent1.putExtra("useridnew",userID);
                startActivity(intent1);
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Recommendation.this,TopPicks.class);
                intent.putExtra("useridnew",userID);
                startActivity(intent);
            }
        });

       /* i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Recommendation.this,OrderHistory.class);
                intent.putExtra("useridnew",userID);
                startActivity(intent);
            }
        });

        */
    }
}