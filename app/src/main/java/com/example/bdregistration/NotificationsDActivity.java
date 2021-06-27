package com.example.bdregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class NotificationsDActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;

    private Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications_d);

        b1=(Button)findViewById(R.id.bn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Intent intent=new Intent(NotificationsDActivity.this,DBNotificationActivity.class);
                // startActivity(intent);
                startActivity(new Intent(NotificationsDActivity.this,DBNotificationActivity.class));
            }
        });

        b2=(Button)findViewById(R.id.bn2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NotificationsDActivity.this,DDNotificationActivity.class);
                startActivity(intent);
            }
        });

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView=(NavigationView)findViewById(R.id.nview23);
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

        if(id==R.id.profiled)
        {
            Intent intent=new Intent(NotificationsDActivity.this,ProfileDActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.homed)
        {
            Intent intent=new Intent(NotificationsDActivity.this,DcHomeActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.notificationsd)
        {
            Intent intent=new Intent(NotificationsDActivity.this,NotificationsDActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.aboutd)
        {
            Intent intent=new Intent(NotificationsDActivity.this,AboutDActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.helpd)
        {
            Intent intent=new Intent(NotificationsDActivity.this,HelpDActivity.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
