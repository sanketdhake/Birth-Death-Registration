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

public class AboutActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView=(NavigationView)findViewById(R.id.nview5);
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

        if(id==R.id.profile)
        {
            Intent intent=new Intent(AboutActivity.this,ProfileActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.home)
        {
            Intent intent=new Intent(AboutActivity.this,HomeActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.birthC)
        {
            Intent intent=new Intent(AboutActivity.this,BirthCActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.deathC)
        {
            Intent intent=new Intent(AboutActivity.this,DeathCActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.about)
        {
            Intent intent=new Intent(AboutActivity.this,AboutActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.help)
        {
            Intent intent=new Intent(AboutActivity.this,HelpActivity.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

