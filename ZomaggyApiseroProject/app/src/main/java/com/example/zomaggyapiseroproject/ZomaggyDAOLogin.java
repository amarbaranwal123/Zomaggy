package com.example.zomaggyapiseroproject;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ZomaggyDAOLogin implements ZomaggyDAOLoginInterface{

    ResultSet rs=null;
    int i=0;


    @Override
    public boolean loginDAOProfile1(ZomaggyEntity z) throws SQLException {
        StrictMode.ThreadPolicy policy3 = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy3);

        boolean b=false;

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

        String url = "jdbc:snowflake://up39310.ap-southeast-1.snowflakecomputing.com/?user=AMAR&warehouse=COMPUTE_WH&&db=APPDB&schema=PUBLIC&CLIENT_SESSION_KEEP_ALIVE=true";

        try {
            Connection con = DriverManager.getConnection(url,properties);

            Log.i("-------------------------","---------1111111111111111---------");

            // i=stmt.executeUpdate("insert into JAVA_DB1.public.java_tb1 values('Nipun','12345','Nipun@gmail.com','kanpur')");
            //st.setString(1,z.getPassword());
            //st.setString(2,z.getEmail());   //
          //  st.setString(2,ze.getPassword());

           PreparedStatement st=con.prepareStatement("select * from APPDB.PUBLIC.APPTB where USER_ID=? and password=?");

            st.setString(1,z.getEmail());
            st.setString(2,z.getPassword());
            st.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");

            Log.i("------------------------------",z.getEmail());
            rs=st.executeQuery();

       if(rs.next())
            {
                b=true;
            }
            else
            {
                b=false;
            }
        } catch (SQLException sqlException) {

            Log.i("----------------------","Connection Failed---------");
            sqlException.printStackTrace();
        }
        return b;
    }
}
