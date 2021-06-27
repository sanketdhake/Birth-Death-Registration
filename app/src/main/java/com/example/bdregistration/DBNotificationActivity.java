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

public class DBNotificationActivity extends AppCompatActivity {

    DatabaseReference db1 = FirebaseDatabase.getInstance().getReference();
    DatabaseReference db2 = db1.child("user").getRef();
    DatabaseReference db3 = db1.child("BirthInfo").getRef();
    String dcname;
    ListView l1;
    List<userlogin> list1;
    private Button b1;
    int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_b_notification);
        l1 = findViewById(R.id.listview);
        list1 = new ArrayList<>();
        b1 = (Button) findViewById(R.id.close1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                l1 = findViewById(R.id.listview);
                list1 = new ArrayList<>();

                db2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        list1.clear();
                        for (DataSnapshot as1 : dataSnapshot.getChildren()) {
                            userlogin e = as1.getValue(userlogin.class);

                            if (e.getFlg()) {
                                //String s1 = userBirth.dlmail;
                                //String s2 = userBirth.dfmail;
                                //                        if (s1.equals(s2))
                                int a = check();
                                if (a==1){
                                    list1.add(e);
                                    l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                            //  Toast.makeText(DBNotificationActivity.this, "working4", Toast.LENGTH_SHORT).show();
                                            userlogin u = list1.get(i);
                                            String username = Demo.uUsername = u.getuUsername();
                                            String phone = Demo.uPhone = u.getuPhone();
                                            String uname = Demo.uName = u.getuName();
                                            String adhar = Demo.uAdharCard = u.getuAdharCard();
                                            String addr = Demo.uAddress = u.getuAddress();
                                            String mail = Demo.uEmail = u.getuEmail();
                                            String repass = Demo.uRepassword = u.getuRepassword();
                                            String pass = Demo.uPassword = u.getuPassword();
                                            String s = Demo.uAddress = u.getuAddress();
                                            String id1 = u.getId();
                                            boolean flag1 = u.getFlg();
                                            boolean flag = true, dflg = u.getDflg(), dflg1 = u.getDflg1();
                                            update3(id1, username, pass, repass, uname, addr, phone, mail, adhar, flag1, flag, dflg, dflg1);
                                        }
                                    });
                                }else {
                                    Toast.makeText(DBNotificationActivity.this, "no", Toast.LENGTH_SHORT).show();
                                }

                            }}
                        EntryList e1 = new EntryList(DBNotificationActivity.this, list1);
                        l1.setAdapter(e1);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
    public int check()
    {
        db3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ass : dataSnapshot.getChildren()){

                    childinfo a1=ass.getValue(childinfo.class);
                    if(a1.getDoctorname().equals(userBirth.dlmail))
                    {
                        x=1;
                    }
                    else {
                        x=0;
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return  x;
    }
    public  void update3(String id1,String username,String pass,String repass,String uname,String addr,String phone,String mail,String adhar,boolean flag1,boolean flag,boolean dflg,boolean dflg1)
    {
        DatabaseReference d=FirebaseDatabase.getInstance().getReference("user").child(id1);
        userlogin ul=new userlogin(id1,username,pass,repass,uname,addr,phone,mail,adhar,flag1,flag,dflg,dflg1);
        d.setValue(ul);
        Toast.makeText(DBNotificationActivity.this,"updated",Toast.LENGTH_SHORT).show();
    }
}
