package com.example.zomaggyapiseroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

public class ConfirmChangePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_change_password);

        EditText et1=findViewById(R.id.et1);
        TextView ss=findViewById(R.id.ss);

        Intent intent=getIntent();

        String name;
        String password;
        String email=intent.getStringExtra("mm");
        String address;
        ss.setText(email);

        getSupportActionBar().setTitle("Confirm Your Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password;
                password =et1.getText().toString();
                String email=intent.getStringExtra("mm");
                String address;

                ZomaggyEntity ze3=new ZomaggyEntity();

                ze3.setPassword(password);
                ze3.setEmail(email);

                ZomaggyDAOUpdateInterface fd= DAOUpdateFactory.createDAOObject();
                int i= 0;
                try {
                    i = fd.updateDAOProfile(ze3);
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                if(i!=0)
                {
                    Toast.makeText(ConfirmChangePassword.this,"Password Edited Succesfully",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(ConfirmChangePassword.this,LoginActivity.class);
                    startActivity(intent);
                }

                else
                {
                    Toast.makeText(ConfirmChangePassword.this,"Password Edition Failed",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}