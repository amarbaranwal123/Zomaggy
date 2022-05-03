package com.example.zomaggyapiseroproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {


    ArrayList<Model3> Quants3=new ArrayList<>();
    ArrayList<String> func=new ArrayList<>();

    String UserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        getSupportActionBar().setTitle("Zomaggy");


        populate();
        UserID=getIntent().getStringExtra("user_id");
        quantsAdapter3 Adapter=new quantsAdapter3(this,Quants3,Quants3.size(),UserID);

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setAdapter(Adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
       // recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Log.i("In First Activity---------------------",UserID);

    }

    private void populate() {


        Quants3.add(new Model3("About Us",R.id.aboutus,UserID));
        Quants3.add(new Model3("User Details",R.drawable.user,UserID));
        Quants3.add(new Model3("Dashboard",R.drawable.graph,UserID));
        Quants3.add(new Model3("Recommendation",R.drawable.recommendation,UserID));
        Quants3.add(new Model3("Rewards",R.drawable.gamification,UserID));
        Quants3.add(new Model3("Delivery",R.drawable.item,UserID));
        Quants3.add(new Model3("Your Order History",R.drawable.orderhistoryimage,UserID));
        Quants3.add(new Model3("Fitness info.",R.drawable.fitnessimage,UserID));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.action_settings:
                Intent intent=new Intent(FirstActivity.this,DeleteActivity.class);
                startActivity(intent);
                break;

            case R.id.logout:
                Intent intent1=new Intent(FirstActivity.this,LoginActivity.class);
                startActivity(intent1);
                finish();
                break;
        }

        return true;
    }
}