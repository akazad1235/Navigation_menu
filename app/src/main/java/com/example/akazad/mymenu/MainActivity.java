package com.example.akazad.mymenu;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView=findViewById(R.id.navigationId);
        navigationView.setNavigationItemSelectedListener(this);



        drawerLayout=findViewById(R.id.drawerId);
        toggle=new ActionBarDrawerToggle(this,drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.homeMenuId){
            Intent intent=new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
        }
         else if(item.getItemId()==R.id.chatMenuId){
            Intent intent=new Intent(MainActivity.this, ChatActivity.class);
            startActivity(intent);
        }
        return false;
    }
}
