package com.example.zomaggyapiseroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    ZomaggyEntity ze;

    // defining our own password pattern
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{8,}" +                // at least 4 characters
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText et1=findViewById(R.id.et1);
        EditText et2=findViewById(R.id.et2);
        EditText et3=findViewById(R.id.et3);
        EditText et4=findViewById(R.id.et4);
        EditText et5=findViewById(R.id.et5);

        String name;
        String password;
        String email;
        String address;


        getSupportActionBar().setTitle("Sign Up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Button signbutton=findViewById(R.id.signupbutton);
        signbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name;
                String password;
                String email;
                String address;
                String mobile;
                name =et1.getText().toString();
                password =et2.getText().toString();
                email =et3.getText().toString();
                address =et4.getText().toString();
                mobile=et5.getText().toString();

                ze=new ZomaggyEntity();
                ze.setName(name);
                ze.setPassword(password);
                ze.setEmail(email);
                ze.setAddress(address);
                ze.setMobile(mobile);

                    // if the email input field is empty
                    if (email.isEmpty()) {
                        et3.setError("Field can not be empty");
                    }

                    // Matching the input email to a predefined email pattern
                    else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        et3.setError("Please enter a valid email address");

                    } else {

                        if (password.isEmpty()) {
                            et2.setError("Field can not be empty");

                        }

                        // if password does not matches to the pattern
                        // it will display an error message "Password is too weak"
                        else if (!PASSWORD_PATTERN.matcher(password).matches()) {
                            et2.setError("Password is too weak");

                        } else {
                        call();
                        }

                    }




                 }

           /*     ZomaggyDAOInterface fd= DAOFactory.createDAOObject();
                int i= 0;
                try {
                    i = fd.createDAOProfile(ze);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                if(i!=0)
                {
                    Toast.makeText(SignUpActivity.this,"Profile Created Succesfully",Toast.LENGTH_LONG).show();
                }

                else
                {
                    Toast.makeText(SignUpActivity.this,"Profile Creation Failed",Toast.LENGTH_LONG).show();
                }

                */


        });
    }

    private void call() {

        ZomaggyDAOInterface fd= DAOFactory.createDAOObject();
        int i= 0;
        try {
            i = fd.createDAOProfile(ze);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(i!=0)
        {
            Toast.makeText(SignUpActivity.this,"Profile Created Succesfully",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(SignUpActivity.this,AvailableItem.class);
            startActivity(intent);
        }

        else
        {
            Toast.makeText(SignUpActivity.this,"Profile Creation Failed",Toast.LENGTH_LONG).show();
        }
    }
}