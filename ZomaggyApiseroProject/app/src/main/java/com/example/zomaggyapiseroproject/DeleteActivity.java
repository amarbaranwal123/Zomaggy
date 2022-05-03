package com.example.zomaggyapiseroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class DeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        EditText st=findViewById(R.id.st);


        getSupportActionBar().setTitle("Delete Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Button button=findViewById(R.id.st1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=st.getText().toString();
                ZomaggyEntity ze4=new ZomaggyEntity();
                ze4.setEmail(email);

                ZomaggyDAODeeleteInterface fd= DAODeleteFactory.createDAOObject();
                boolean b= false;
                try {
                    b = fd.deleteDAOProfile(ze4);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                if(b)
                {
                    Toast.makeText(DeleteActivity.this,"Profile Deleted Succesfully",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(DeleteActivity.this,LoginActivity.class);
                    startActivity(intent);
                }

                else
                {
                    Toast.makeText(DeleteActivity.this,"Profile Deletion Failed",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}