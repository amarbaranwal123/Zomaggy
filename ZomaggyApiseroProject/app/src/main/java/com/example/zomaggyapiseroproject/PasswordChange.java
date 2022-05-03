package com.example.zomaggyapiseroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PasswordChange extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);
        getSupportActionBar().setTitle("Confirm Your Identity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        EditText et1=findViewById(R.id.et1);

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ConfirmChangePassword.class);
                String email=et1.getText().toString();
                intent.putExtra("mm",email);
                startActivity(intent);
            }
        });
    }
}