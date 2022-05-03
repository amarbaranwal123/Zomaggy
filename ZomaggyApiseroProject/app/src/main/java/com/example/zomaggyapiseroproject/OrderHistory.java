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

public class OrderHistory extends AppCompatActivity {

    ArrayList<Model1> Quants1=new ArrayList<>();
    ArrayList<String> fooditems1=new ArrayList<>();
    ArrayList<String> price=new ArrayList<>();
    int count=0;
    String useridnew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy3 = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy3);
        setContentView(R.layout.activity_order_history);

        getSupportActionBar().setTitle("Order History");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        useridnew=getIntent().getStringExtra("useridnew");

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
            Log.i("-------------------------","---------1111111111111111---------");

            // i=stmt.executeUpdate("insert into JAVA_DB1.public.java_tb1 values('Nipun','12345','Nipun@gmail.com','kanpur')");
            //st.setString(1,z.getPassword());
            //st.setString(2,z.getEmail());   //
            //  st.setString(2,ze.getPassword());

            PreparedStatement st=con.prepareStatement("select order_items,order_total from ZOMAGGY_STRUCTURED_DB.ZOMAGGY_STRUCTURED_SCHEMA.ORDER_DETAILS where USER_ID=?  order by ORDER_TIME DESC");
            st.setString(1,useridnew);

            st.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                fooditems1.add(rs.getString(1));
                price.add(rs.getString(2));
                count++;
            }
        } catch (SQLException sqlException) {
            Log.i("----------------------","Connection Failed---------");
            sqlException.printStackTrace();
        }

        populate();

        quantsAdapter1 Adapter=new quantsAdapter1(this,Quants1,Quants1.size());
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setAdapter(Adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void populate() {
        for(int i=0;i<count;i++)
        {
            Quants1.add(new Model1(fooditems1.get(i),String.valueOf(i+1),"Rs. "+price.get(i)));
        }
    }
}