package com.example.zomaggyapiseroproject;

import android.graphics.Bitmap;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ZomaggyDAO implements ZomaggyDAOInterface {




    @Override
    public int createDAOProfile(ZomaggyEntity ze) throws SQLException {

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

        String url = "jdbc:snowflake://up39310.ap-southeast-1.snowflakecomputing.com/?user=AMAR&warehouse=COMPUTE_WH&db=APPDB&schema=PUBLIC&CLIENT_SESSION_KEEP_ALIVE=true";

        Connection con= null;
        try {
            con = DriverManager.getConnection(url,properties);
            Statement stmt = con.createStatement();
            Log.i("-------------------------","---------1111111111111111---------");

           // i=stmt.executeUpdate("insert into JAVA_DB1.public.java_tb1 values('Nipun','12345','Nipun@gmail.com','kanpur')");

            PreparedStatement st=con.prepareStatement("insert into APPDB.PUBLIC.APPTB values(seq_1.nextval,?,?,?,?,?)");
            st.setString(1,ze.getName());
            st.setString(2,ze.getEmail());
            st.setString(3,ze.getMobile());
            st.setString(4,ze.getPassword());
            st.setString(5,ze.getAddress());

            i=st.executeUpdate();

        } catch (SQLException sqlException) {

            Log.i("----------------------","Connection Failed---------");
            sqlException.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean loginDAOProfile(ZomaggyEntity ze) throws SQLException {

        StrictMode.ThreadPolicy policy2 = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy2);

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

        String url = "jdbc:snowflake://up39310.ap-southeast-1.snowflakecomputing.com/?user=AMAR&warehouse=COMPUTE_WH&db=JAVA_DB1&schema=public";

        Connection con= null;

        try {
            con = DriverManager.getConnection(url,properties);
            Log.i("-------------------------","---------1111111111111111---------");

            // i=stmt.executeUpdate("insert into JAVA_DB1.public.java_tb1 values('Nipun','12345','Nipun@gmail.com','kanpur')");

            PreparedStatement st=con.prepareStatement("select * from JAVA_DB1.public.java_tb1 where name=? and password=?");
            st.setString(1,ze.getEmail());
            st.setString(2,ze.getPassword());

            ResultSet rs=st.executeQuery();

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

    @Override
    public ZomaggyEntity viewDAOProfile(ZomaggyEntity ze) {
        return null;
    }

    @Override
    public int deleteDAOProfile(ZomaggyEntity ze) {
        return 0;
    }

    @Override
    public int updateDAOProfile(ZomaggyEntity ze) throws SQLException{
        StrictMode.ThreadPolicy policy3 = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy3);

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
        String url = "jdbc:snowflake://up39310.ap-southeast-1.snowflakecomputing.com/?user=AMAR&warehouse=COMPUTE_WH&db=JAVA_DB1&schema=public";

                Connection con= null;
                try {
                    con = DriverManager.getConnection(url,properties);

                    Statement stmt = con.createStatement();

                    Log.i("-------------------------","---------1111111111111111---------");

                    // i=stmt.executeUpdate("insert into JAVA_DB1.public.java_tb1 values('Nipun','12345','Nipun@gmail.com','kanpur')");

                    PreparedStatement st=con.prepareStatement("update JAVA_DB1.public.java_tb1 set password=? where email=?");

                    st.setString(1,ze.getPassword());
                    st.setString(2,ze.getEmail());


                    i =st.executeUpdate();

                } catch (SQLException sqlException) {

                    Log.i("----------------------","Connection Failed---------");
                    sqlException.printStackTrace();
                }

        return  i;
    }
}
