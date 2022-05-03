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

public class AvailableItem extends AppCompatActivity {
    int count=0;

    ArrayList<Model> Quants=new ArrayList<>();
    ArrayList<String> fooditems=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy3 = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy3);
        setContentView(R.layout.activity_available_item);


        getSupportActionBar().setTitle("Item Available in Zomaggy");
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

        String url = "jdbc:snowflake://up39310.ap-southeast-1.snowflakecomputing.com/?user=AMAR&warehouse=COMPUTE_WH&db=JAVA_DB1&schema=public&CLIENT_SESSION_KEEP_ALIVE=true";

        try {
            Connection con = DriverManager.getConnection(url,properties);
            Log.i("-------------------------","---------1111111111111111---------");
            // i=stmt.executeUpdate("insert into JAVA_DB1.public.java_tb1 values('Nipun','12345','Nipun@gmail.com','kanpur')");
            //st.setString(1,z.getPassword());
            //st.setString(2,z.getEmail());   //
            //  st.setString(2,ze.getPassword());
            PreparedStatement st=con.prepareStatement("select * from JAVA_DB1.public.food");

            st.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");

            ResultSet rs=st.executeQuery();

            while (rs.next()) {

                fooditems.add(rs.getString(1));
                Log.i("---------------------------",rs.getString(1));
                count++;
            }
        } catch (SQLException sqlException) {

            Log.i("----------------------","Connection Failed---------");
            sqlException.printStackTrace();
        }
        populate();

        quantsAdapter Adapter=new quantsAdapter(this,Quants,Quants.size());

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setAdapter(Adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void populate() {

        for(int i=1;i<count;i++)
        {
            Quants.add(new Model(fooditems.get(i),String.valueOf(i+1),""));
        }
     /*   Quants.add(new Model(fooditems.get(2),"2",""));
        Quants.add(new Model(fooditems.get(3),"3",""));
        Quants.add(new Model(fooditems.get(4),"4",""));
        Quants.add(new Model(fooditems.get(5),"5",""));
        Quants.add(new Model(fooditems.get(6),"6",""));

*/

    }
}