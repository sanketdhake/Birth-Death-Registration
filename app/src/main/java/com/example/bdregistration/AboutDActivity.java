package com.example.bdregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class AboutDActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_d);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView=(NavigationView)findViewById(R.id.nview25);
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.profiled)
        {
            Intent intent=new Intent(AboutDActivity.this,ProfileDActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.homed)
        {
            Intent intent=new Intent(AboutDActivity.this,DcHomeActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.notificationsd)
        {
            Intent intent=new Intent(AboutDActivity.this,NotificationsDActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.aboutd)
        {
            Intent intent=new Intent(AboutDActivity.this,AboutDActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.helpd)
        {
            Intent intent=new Intent(AboutDActivity.this,HelpDActivity.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

