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
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DeathCActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button b1;
    DatabaseReference db1 = FirebaseDatabase.getInstance().getReference();
    DatabaseReference db2 = db1.child("user").getRef();

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_c);

        b1=(Button)findViewById(R.id.deatcerbtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot as1 : dataSnapshot.getChildren()) {
                            userlogin e = as1.getValue(userlogin.class);
                            String ml1=userBirth.birthmail;
                            if (e.getuEmail().equals(ml1)) {

                                String username =e.getuUsername();
                                String phone= e.getuPhone();
                                String uname= e.getuName();
                                String adhar= e.getuAdharCard();
                                String addr= e.getuAddress();
                                String mail=e.getuEmail();
                                Toast.makeText(DeathCActivity.this,mail,Toast.LENGTH_SHORT).show();
                                String repass=e.getuRepassword();
                                String pass=e.getuPassword();
                                String id1=e.getId();
                                boolean flag1=e.getFlg1();
                                boolean flag=e.getFlg(),dflg1=e.getDflg1(),dflg=true;

                                update2(id1,username,pass,repass,uname,addr,phone,mail,adhar,flag1,flag,dflg,dflg1);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView=(NavigationView)findViewById(R.id.nview4);
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
            Intent intent=new Intent(DeathCActivity.this,ProfileActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.home)
        {
            Intent intent=new Intent(DeathCActivity.this,HomeActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.birthC)
        {
            Intent intent=new Intent(DeathCActivity.this,BirthCActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.deathC)
        {
            Intent intent=new Intent(DeathCActivity.this,DeathCActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.about)
        {
            Intent intent=new Intent(DeathCActivity.this,AboutActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.help)
        {
            Intent intent=new Intent(DeathCActivity.this,HelpActivity.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    public  void update2(String id1,String username,String pass,String repass,String uname,String addr,String phone,String mail,String adhar,boolean flag1,boolean flag,boolean dflg,boolean dflg1)
    {
        DatabaseReference d=FirebaseDatabase.getInstance().getReference("user").child(id1);
        userlogin ul=new userlogin(id1,username,pass,repass,uname,addr,phone,mail,adhar,flag1,flag,dflg,dflg1);
        d.setValue(ul);
        Toast.makeText(DeathCActivity.this,"updated",Toast.LENGTH_SHORT).show();
    }
}

