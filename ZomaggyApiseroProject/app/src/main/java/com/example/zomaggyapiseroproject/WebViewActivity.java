package com.example.zomaggyapiseroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class WebViewActivity extends AppCompatActivity {
    ImageButton backbutton;
    ImageButton backbutton1;
    String UserId;

    TextView i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView browser = (WebView) findViewById(R.id.webview);
        //WebView browser1 = (WebView) findViewById(R.id.webview1);

        UserId=getIntent().getStringExtra("useridnew");


        WebView webView=findViewById(R.id.webview);
        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        try
        {
            Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
        }
        catch (ClassNotFoundException ex)
        {
            System.err.println("Driver not found");
        }

        Properties properties = new Properties();
        // properties.put("user", "UTKARSHSMAX2");     // replace "" with your username
        properties.put("password", "Project123"); // replace "" with your password
        properties.put("account", "bw11535.ap-south-1.aws");


        String url = "jdbc:snowflake://bw11535.ap-south-1.aws.snowflakecomputing.com/?user=Utkarsh&warehouse=COMPUTE_WH&&db=APPDB&schema=PUBLIC&CLIENT_SESSION_KEEP_ALIVE=true";



        try {


            Connection con = DriverManager.getConnection(url,properties);



            Log.i("-------------------------","---------1111111111111111---------");


            // i=stmt.executeUpdate("insert into JAVA_DB1.public.java_tb1 values('Nipun','12345','Nipun@gmail.com','kanpur')");


            //st.setString(1,z.getPassword());
            //st.setString(2,z.getEmail());   //
            //  st.setString(2,ze.getPassword());
            PreparedStatement st=con.prepareStatement("select USER_NAME from APPDB.PUBLIC.APPTB where USER_ID=?");

            st.setString(1,UserId);
            st.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");


            ResultSet rs=st.executeQuery();



            while (rs.next()) {

                String UserName=rs.getString(1);

                i=findViewById(R.id.i);
                i.setText("Welcome "+UserName+"!");

            }



        } catch (SQLException sqlException) {

            Log.i("----------------------","Connection Failed---------");


            sqlException.printStackTrace();
        }




        Uri imageUri = Uri.fromFile(new File("//assets/sample.html"));
        String urll=imageUri.toString();

        backbutton=findViewById(R.id.backbutton);
        // backbutton1=findViewById(R.id.backbutton1);



        getSupportActionBar().setTitle("Tableau Dashboard");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        WebSettings webSettings=browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());

        String htmlData="";



        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(browser!=null && browser.canGoBack())
                {
                    browser.goBack();
                }
            }
        });
        //browser.loadData(htmlData,"text/html","UTF-8");
        //browser.getSettings().setUserAgentString("Android");
        //  browser.getSettings().setUseWideViewPort(false);

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        String url1 = "https://www.google.co.in";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url1);

        int u=Integer.valueOf(UserId);

        if(u==585709)
        {
            webView = (WebView) findViewById(R.id.webview);
            webView.setWebViewClient(new WebViewClient());
            String url2 = "https://www.google.co.in";
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(url2);
        }
        else if(u==14444332)
        {
            webView = (WebView) findViewById(R.id.webview);
            webView.setWebViewClient(new WebViewClient());
            String url3 = "https://www.google.co.in";
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(url3);
        }





   /*     WebSettings webSettings1=browser1.getSettings();
        webSettings1.setJavaScriptEnabled(true);
        browser1.setWebViewClient(new WebViewClient());

       backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(browser1!=null && browser1.canGoBack())
                {
                    browser1.goBack();
                }
            }
        });
        browser1.loadUrl(url1);  */

    }
}









