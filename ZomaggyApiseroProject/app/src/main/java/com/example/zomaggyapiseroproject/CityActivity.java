package com.example.zomaggyapiseroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class CityActivity extends AppCompatActivity {
    String UserID;
    String city;
    TextView t1,t2,t3,t4,t5,t6,t7;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy3 = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy3);
        setContentView(R.layout.activity_city);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Users Details");

        UserID=getIntent().getStringExtra("useridnew");
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        t6=findViewById(R.id.t6);
        t7=findViewById(R.id.t7);
        b=findViewById(R.id.b);

        int i=0;
        String st[]=new String[6];

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


        String url = "jdbc:snowflake://up39310.ap-southeast-1.snowflakecomputing.com/?user=AMAR&warehouse=COMPUTE_WH&&db=EXAMPLE&schema=PUBLIC&CLIENT_SESSION_KEEP_ALIVE=true";
        try {
            Connection con = DriverManager.getConnection(url,properties);
            // i=stmt.executeUpdate("insert into JAVA_DB1.public.java_tb1 values('Nipun','12345','Nipun@gmail.com','kanpur')");
            //st.setString(1,z.getPassword());
            //st.setString(2,z.getEmail());   //
            //  st.setString(2,ze.getPassword());
            PreparedStatement st1=con.prepareStatement("select * from EXAMPLE.PUBLIC.APPTB where USER_ID=?");


            st1.setString(1,UserID);
            st1.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");
            ResultSet rs1=st1.executeQuery();

            while (rs1.next())
            {
                //st[i]=rs1.getString(i+1);
               // t2.setText("UserID: "+rs1.getString(st[i+1]));
                //i++;
               // t2.setText("UserID: "+rs1.getString(1));
                t3.setText("User Name: "+rs1.getString(2));
                t4.setText("Email ID: "+rs1.getString(3));
                t5.setText("Mobile: "+rs1.getString(4));
                t6.setText("Password: "+"*******");
                t7.setText("City: "+rs1.getString(6));
                city=rs1.getString(6);
            }

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(CityActivity.this,TopRestaurant.class);
                    intent.putExtra("city",city);
                    startActivity(intent);
                }
            });
        } catch (SQLException sqlException) {
            Log.i("----------------------","Connection Failed---------");
            sqlException.printStackTrace();
        }
    }
}