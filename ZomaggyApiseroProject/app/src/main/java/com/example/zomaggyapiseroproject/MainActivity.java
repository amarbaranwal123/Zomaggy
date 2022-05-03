package com.example.zomaggyapiseroproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zomaggyapiseroproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,WebViewActivity.class);
                startActivity(intent);
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        Intent intent=new Intent(MainActivity.this,AboutUs.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_gallery:
                        Intent intenta=new Intent(MainActivity.this,LoginActivity.class);
                        intenta.putExtra("web",1);
                        startActivity(intenta);
                        break;

                    case  R.id.nav_slideshow:
                        intent=new Intent(MainActivity.this,SignUpActivity.class);
                        startActivity(intent);
                        break;
                    case  R.id.recommendation:
                        Intent intentb=new Intent(MainActivity.this,LoginActivity.class);
                        intentb.putExtra("rec",2);
                        startActivity(intentb);
                        break;

                    case  R.id.gamification:
                        Intent intentc=new Intent(MainActivity.this,LoginActivity.class);
                        intentc.putExtra("gami",3);
                        startActivity(intentc);
                        break;

                    case  R.id.logout:
                        intent=new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intent);
                        break;

                    case  R.id.remove:
                        intent=new Intent(MainActivity.this,DeleteActivity.class);
                        startActivity(intent);
                        break;


                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.action_settings:
                Intent intent=new Intent(MainActivity.this,DeleteActivity.class);
                startActivity(intent);
                break;
        }

        return true;
    }
}