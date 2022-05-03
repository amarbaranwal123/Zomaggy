package com.example.zomaggyapiseroproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class TopRestaurant extends AppCompatActivity {

    ArrayList<Model2> Quants2=new ArrayList<>();
    ArrayList<String> restaurantname=new ArrayList<>();
    ArrayList<String> city=new ArrayList<>();
    ArrayList<String> rating=new ArrayList<>();
    ArrayList<String> id=new ArrayList<>();
    int count=0;
    String city1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy3 = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy3);
        setContentView(R.layout.activity_top_restaurant);

        getSupportActionBar().setTitle("Top Restaurant in your city");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        city1=getIntent().getStringExtra("city");

        try
        {
            Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
        }
        catch (ClassNotFoundException ex)
        {
            System.err.println("Driver not found");
        }

        Properties properties = new Properties();
        // properties.put("user", "AMAR");     // replace "" with your username
        properties.put("password", "amarAITI49@"); // replace "" with your password
        properties.put("account", "up39310.ap-southeast-1");


        String url = "jdbc:snowflake://up39310.ap-southeast-1.snowflakecomputing.com/?user=AMAR&warehouse=COMPUTE_WH&db=ZOMAGGY_STRUCTURED_DB&schema=ZOMAGGY_STRUCTURED_SCHEMA&CLIENT_SESSION_KEEP_ALIVE=true";

        try {
            Connection con = DriverManager.getConnection(url,properties);
            PreparedStatement st=con.prepareStatement("select o.RESTAURANT_ID, min(r.RESTAURANT_NAME), avg(o.rating), min(r.RESTAURANT_CITY_NAME) from ZOMAGGY_STRUCTURED_DB.ZOMAGGY_STRUCTURED_SCHEMA.RESTAURANT_DETAILS o join RESTAURANT_DETAILS r on o.RESTAURANT_ID=r.RESTAURANT_ID where r.RESTAURANT_CITY_NAME=? group by o.RESTAURANT_ID order by avg(o.rating) desc limit 5");

            st.setString(1,city1);
            st.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                id.add(rs.getString(1));
                restaurantname.add(rs.getString(2));
                rating.add(rs.getString(3));
                city.add(rs.getString(4));
                count++;
            }
        } catch (SQLException sqlException) {
            Log.i("----------------------","Connection Failed---------");
            sqlException.printStackTrace();
        }
        populate();
        quantAdapter2 Adapter=new quantAdapter2(this,Quants2,Quants2.size());
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setAdapter(Adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void populate() {
        for(int i=0;i<count;i++)
        {
            Quants2.add(new Model2("Restaurant ID:"+id.get(i),"Restaurant Name:"+restaurantname.get(i),"Rating:"+rating.get(i),"City:"+city.get(i)));
        }
    }
}