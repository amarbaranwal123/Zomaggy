package com.example.zomaggyapiseroproject;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ZomaggyDAODelete implements ZomaggyDAODeeleteInterface{
    @Override
    public boolean deleteDAOProfile(ZomaggyEntity ze) throws SQLException {
        StrictMode.ThreadPolicy policy1 = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy1);


        int i=0;

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

        Connection con= null;
        try {
            con = DriverManager.getConnection(url,properties);
            Statement stmt = con.createStatement();

            Log.i("-------------------------","---------1111111111111111---------");

            // i=stmt.executeUpdate("insert into JAVA_DB1.public.java_tb1 values('Nipun','12345','Nipun@gmail.com','kanpur')");

            PreparedStatement st=con.prepareStatement("delete from APPDB.PUBLIC.APPTB where email_id=?");

            st.setString(1,ze.getEmail());
            i=st.executeUpdate();
        } catch (SQLException sqlException) {

            Log.i("----------------------","Connection Failed---------");
            sqlException.printStackTrace();
        }

        if(i!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
