package com.example.bdregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DDNotificationActivity extends AppCompatActivity {

    DatabaseReference db1 = FirebaseDatabase.getInstance().getReference();
    DatabaseReference db2 = db1.child("user").getRef();
    ListView l1;
    List<userlogin> list1;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_d_notification);

        b1=(Button)findViewById(R.id.disp);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                l1 = findViewById(R.id.ddlist);
                list1 = new ArrayList<>();
                db2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        list1.clear();
                        for (DataSnapshot as1 : dataSnapshot.getChildren()) {
                            userlogin e = as1.getValue(userlogin.class);
                            if (e.getDflg()) {
                                list1.add(e);
                                l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        userlogin u = list1.get(i);
                                        String username = Demo.uUsername=u.getuUsername();
                                        String phone= Demo.uPhone=u.getuPhone();
                                        String uname= Demo.uName=u.getuName();
                                        String adhar= Demo.uAdharCard=u.getuAdharCard();
                                        String addr= Demo.uAddress=u.getuAddress();
                                        String mail=Demo.uEmail=u.getuEmail();
                                        String repass=Demo.uRepassword=u.getuRepassword();
                                        String pass=Demo.uPassword=u.getuPassword();
                                        String s=Demo.uAddress=u.getuAddress();

                                        String id1=u.getId();
                                        boolean dflg=u.getDflg();
                                        boolean dflg1=true;
                                        boolean flag1=u.getFlg1();
                                        boolean flag=u.getFlg();

                                        update(id1,username,pass,repass,uname,addr,phone,mail,adhar,flag1,flag,dflg,dflg1);
                                    }
                                });
                            }
                        }
                        EntryList e1 = new EntryList(DDNotificationActivity.this, list1);
                        l1.setAdapter(e1);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
    public  void update(String id1,String username,String pass,String repass,String uname,String addr,String phone,String mail,String adhar,boolean flag1,boolean flag,boolean dflg,boolean dflg1)
    {
        DatabaseReference d=FirebaseDatabase.getInstance().getReference("user").child(id1);
        userlogin ul=new userlogin(id1,username,pass,repass,uname,addr,phone,mail,adhar,flag1,flag,dflg,dflg1);
        d.setValue(ul);
        Toast.makeText(DDNotificationActivity.this,"updated",Toast.LENGTH_SHORT).show();
    }}
