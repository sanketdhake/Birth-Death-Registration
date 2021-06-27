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

public class AboutMActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_m);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView=(NavigationView)findViewById(R.id.nview35);
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.profilem)
        {
            Intent intent=new Intent(AboutMActivity.this,ProfileMActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.homem)
        {
            Intent intent=new Intent(AboutMActivity.this,MoHomeActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.notificationsm)
        {
            Intent intent=new Intent(AboutMActivity.this,NotificationMActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.aboutm)
        {
            Intent intent=new Intent(AboutMActivity.this,AboutMActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.helpm)
        {
            Intent intent=new Intent(AboutMActivity.this,HelpMActivity.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

