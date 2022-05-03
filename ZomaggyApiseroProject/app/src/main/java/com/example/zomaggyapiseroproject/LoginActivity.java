package com.example.zomaggyapiseroproject;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

public class LoginActivity extends AppCompatActivity {

    private ImageView bookIconImageView;
    private TextView bookITextView;
    private ProgressBar loadingProgressBar;
    private RelativeLayout rootView, afterAnimationView;

    EditText emailEditText;
    EditText passwordEditText;
    TextView forgetpassword;
    Button loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        emailEditText=findViewById(R.id.emailEditText);
        passwordEditText=findViewById(R.id.passwordEditText);

        forgetpassword=findViewById(R.id.forgetpassword);
        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,PasswordChange.class);
                startActivity(intent);
            }
        });

        loginbutton=findViewById(R.id.loginButton);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name;
                String password;
                String email;
                String address;

                password =passwordEditText.getText().toString();
                email =emailEditText.getText().toString();


                ZomaggyEntity ze5=new ZomaggyEntity();


                ze5.setPassword(password);
                ze5.setEmail(email);



                ZomaggyDAOLoginInterface fd= DAOLoginFactory.createDAOObject();
                boolean b=false;
                try {
                    b = fd.loginDAOProfile1(ze5);
                } catch (SQLException throwables) {

                    Log.i("first","------------------------");
                    throwables.printStackTrace();
                }

                if(b)
                {
                    Toast.makeText(LoginActivity.this,"Profile found Login succesfull",Toast.LENGTH_LONG).show();

                        Intent intent=new Intent(LoginActivity.this,FirstActivity.class);
                        intent.putExtra("user_id", email);
                        startActivity(intent);
                    }

                else
                {
                    Toast.makeText(LoginActivity.this,"Profile not Found Login unsuccesfull",Toast.LENGTH_LONG).show();
                }
            }
        });



        TextView signup=findViewById(R.id.signup);
        TextView forgetpassword=findViewById(R.id.forgetpassword);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        initViews();
        new CountDownTimer(5000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                bookITextView.setVisibility(GONE);
                loadingProgressBar.setVisibility(GONE);
                rootView.setBackgroundColor(ContextCompat.getColor(LoginActivity.this, R.color.colorSplashText));
                bookIconImageView.setImageResource(R.drawable.logo);
                startAnimation();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        TextView skipTextView=findViewById(R.id.skipTextView);

        skipTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void startAnimation() {

        ViewPropertyAnimator viewPropertyAnimator = bookIconImageView.animate();
        viewPropertyAnimator.x(50f);
        viewPropertyAnimator.y(100f);
        viewPropertyAnimator.setDuration(1000);
        viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                afterAnimationView.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void initViews() {

        bookIconImageView = findViewById(R.id.bookIconImageView);
        bookITextView = findViewById(R.id.bookITextView);
        loadingProgressBar = findViewById(R.id.loadingProgressBar);
        rootView = findViewById(R.id.rootView);
        afterAnimationView = findViewById(R.id.afterAnimationView);
    }
}