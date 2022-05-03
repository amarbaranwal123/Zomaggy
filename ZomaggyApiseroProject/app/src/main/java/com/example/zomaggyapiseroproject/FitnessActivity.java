package com.example.zomaggyapiseroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class FitnessActivity extends AppCompatActivity {

    String UserId;
    TextView f1,f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy3 = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy3);
        setContentView(R.layout.activity_fitness);

        UserId=getIntent().getStringExtra("useridnew");

        f1=findViewById(R.id.f1);
        f2=findViewById(R.id.f2);

        getSupportActionBar().setTitle("Fitness Information of User");
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

        String url = "jdbc:snowflake://up39310.ap-southeast-1.snowflakecomputing.com/?user=AMAR&warehouse=COMPUTE_WH&db=ZOMAGGY_STRUCTURED_DB&schema=ZOMAGGY_STRUCTURED_SCHEMA&CLIENT_SESSION_KEEP_ALIVE=true";

        try {
            Connection con = DriverManager.getConnection(url,properties);

            PreparedStatement st=con.prepareStatement("select o.user_id, sum(f.CALORIES), min(u.user_name) from ZOMAGGY_STRUCTURED_DB.ZOMAGGY_STRUCTURED_SCHEMA.ORDER_DETAILS o join ZOMAGGY_STRUCTURED_DB.ZOMAGGY_STRUCTURED_SCHEMA.FOOD_DETAILS f on o.ORDER_ITEMS = f.ITEMS join ZOMAGGY_STRUCTURED_DB.ZOMAGGY_STRUCTURED_SCHEMA.USER_DETAILS u on o.user_id = u.user_id where u.user_id=? group by  o.user_id order by sum(f.CALORIES) limit 5");

            st.setString(1,UserId);
            st.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");
            ResultSet rs=st.executeQuery();

            while (rs.next()) {
                Log.i("User ID",rs.getString(1));
                Log.i("Calorie Count",rs.getString(2));
                Log.i("user name",rs.getString(3));
                f1.setText("Hi,"+rs.getString(3));
                f2.setText("Great ! You have consumed "+rs.getString(2)+" calories from your past order history");

                Toast.makeText(this,"in the while loop",Toast.LENGTH_LONG).show();
            }
        } catch (SQLException sqlException) {
            Log.i("----------------------","Connection Failed---------");
            sqlException.printStackTrace();
        }
    }
}