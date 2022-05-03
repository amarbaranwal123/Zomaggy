package com.example.zomaggyapiseroproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class TopPicks extends AppCompatActivity {

    String userID;

    ArrayList<Model4> Quants4=new ArrayList<>();
    ArrayList<String> resname=new ArrayList<>();
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_picks);


        getSupportActionBar().setTitle("Top Picked Restaurant");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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


        String url = "jdbc:snowflake://up39310.ap-southeast-1.snowflakecomputing.com/?user=AMAR&warehouse=COMPUTE_WH&db=DATAIKU_DATABASE&schema=DATAIKU_SCHEMA&CLIENT_SESSION_KEEP_ALIVE=true";



        userID=getIntent().getStringExtra("useridnew");

        try {


            Connection con = DriverManager.getConnection(url,properties);



            Log.i("-------------------------","---------1111111111111111---------");


            // i=stmt.executeUpdate("insert into JAVA_DB1.public.java_tb1 values('Nipun','12345','Nipun@gmail.com','kanpur')");


            //st.setString(1,z.getPassword());
            //st.setString(2,z.getEmail());   //
            //  st.setString(2,ze.getPassword());
            PreparedStatement st=con.prepareStatement("select distinct user_id,user_name,Restaurant_name from  ZOMAGGY_ANALYST_DB.ZOMAGGY_ANALYST_SCHEMA.ZOMAGGY10_PREDICTION where user_id=? limit 10");

            st.setString(1,userID);
            st.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                resname.add(rs.getString(3));
                Log.i("Restaurant Name",rs.getString(3));
                count++;
            }
        } catch (SQLException sqlException) {

            Log.i("----------------------","Connection Failed---------");
            sqlException.printStackTrace();
        }
        populate();
        quantsAdapter4 Adapter=new quantsAdapter4(this,Quants4,Quants4.size());

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setAdapter(Adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void populate() {
        for(int i=1;i<count;i++)
        {
            Quants4.add(new Model4("Restaurant Name: "+resname.get(i)));
        }
    }
}