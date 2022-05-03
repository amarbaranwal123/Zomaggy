package com.example.zomaggyapiseroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Gami extends AppCompatActivity {
    TextView t1,t2;
    String OrderCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy3 = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy3);
        setContentView(R.layout.activity_gami);

        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        getSupportActionBar().setTitle("Rewards Panel");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String UserId=getIntent().getStringExtra("useridne");
        int u=Integer.valueOf(UserId);
        if(u==47166442 || u==50384286 || u==8271225 || u==585709)
        {
            t1.setText("Congrats Sir, You are our precious Customer You won a Coupon for free purchase of one food item from zomato,your CouponID is: "+UserId+"@347&");
        }
        else
        {
            t1.setText("Sorry you didn't won any Coupon for free food items delivery due to your less order count from zomato");
        }

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
        String url = "jdbc:snowflake://up39310.ap-southeast-1.snowflakecomputing.com/?user=AMAR&warehouse=COMPUTE_WH&db=APPDB&schema=PUBLIC&CLIENT_SESSION_KEEP_ALIVE=true";

        try {
            Connection con = DriverManager.getConnection(url,properties);
            Log.i("-------------------------","---------1111111111111111---------");

            // i=stmt.executeUpdate("insert into JAVA_DB1.public.java_tb1 values('Nipun','12345','Nipun@gmail.com','kanpur')");
            //st.setString(1,z.getPassword());
            //st.setString(2,z.getEmail());   //
            //  st.setString(2,ze.getPassword());
            PreparedStatement st=con.prepareStatement("select NUMBER from APPDB.PUBLIC.gamification where USER_ID=?");
            st.setString(1,UserId);

            st.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                OrderCount=rs.getString(1);
            }

            int i=Integer.valueOf(OrderCount);
            t2.setText("Your Total Order Count is :"+(i-3));
        } catch (SQLException sqlException) {
            Log.i("----------------------","Connection Failed---------");
            sqlException.printStackTrace();
        }
    }
}