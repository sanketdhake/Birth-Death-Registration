package com.example.bdregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileMActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DatabaseReference db1 = FirebaseDatabase.getInstance().getReference();
    DatabaseReference db2 = db1.child("Municipal_Office_Logins").getRef();

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;
    TextView name,ph,email,region,regno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_m);
        name=(TextView)findViewById(R.id.mname);
        ph=(TextView)findViewById(R.id.muno);
        email=(TextView)findViewById(R.id.munmail);

        region=(TextView)findViewById(R.id.reg);
        regno=(TextView)findViewById(R.id.regno);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView=(NavigationView)findViewById(R.id.nviewm);
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
            Intent intent=new Intent(ProfileMActivity.this,ProfileMActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.homem)
        {
            Intent intent=new Intent(ProfileMActivity.this,MoHomeActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.notificationsm)
        {
            Intent intent=new Intent(ProfileMActivity.this,NotificationMActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.aboutm)
        {
            Intent intent=new Intent(ProfileMActivity.this,AboutMActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.helpm)
        {
            Intent intent=new Intent(ProfileMActivity.this,HelpMActivity.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        db2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot as1 : dataSnapshot.getChildren()) {
                    mosignup e = as1.getValue(mosignup.class);
                    if (e.getSremail().equals(userBirth.momail)) {

                        name.setText(e.getSrname());
                        region.setText(e.getSrreg());
                        regno.setText(e.getSrregno());
                        ph.setText(e.getSrphnno());
                        email.setText(e.getSremail());


                    }
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}

