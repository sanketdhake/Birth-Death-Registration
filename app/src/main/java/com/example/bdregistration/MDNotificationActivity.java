package com.example.bdregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class MDNotificationActivity extends AppCompatActivity {

    DatabaseReference db1 = FirebaseDatabase.getInstance().getReference();
    DatabaseReference db2 = db1.child("user").getRef();
    DatabaseReference db3 = db1.child("dead_peoples").getRef();
    ListView l1;
    List<userlogin> list1;
    private Button b1;
    String s;
    //DatabaseReference db4=db1.child("Alive_people").getRef();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_d_notification);

        b1 = (Button) findViewById(R.id.disp2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l1 = findViewById(R.id.mdlist);
                list1 = new ArrayList<>();
                db2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        list1.clear();
                        for (DataSnapshot as1 : dataSnapshot.getChildren()) {
                            userlogin e = as1.getValue(userlogin.class);
                            if (e.getDflg1()) {
                                list1.add(e);
                                l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
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
                                        boolean dflg1 = u.getDflg1();
                                        boolean dflg = false;
                                        boolean flag1 = u.getFlg1();
                                        boolean flag = u.getFlg();

                                        update4(id1, username, pass, repass, uname, addr, phone, mail, adhar, flag1, flag, dflg, dflg1);


                                        exec11();

                                    }
                                });
                            }
                        }
                        EntryList e1 = new EntryList(MDNotificationActivity.this, list1);
                        l1.setAdapter(e1);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
    public void exec14(final String m)
    {
        db2.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot as1 : dataSnapshot.getChildren()) {

                    AlivePeople e = as1.getValue(AlivePeople.class);


                    if (e.getAmail().equals(m) && e.getAname().equals(Demo.uUsername)) {
                        Toast.makeText(MDNotificationActivity.this,"hello",Toast.LENGTH_SHORT).show();
                        String username =e.getAname();

                        String mail1=e.getAmail();
                        String id1=e.getAid();

                        DatabaseReference d = FirebaseDatabase.getInstance().getReference("Alive_people").child(id1);
                        //AlivePeople ul = new AlivePeople(id1, mail,uname);
                        d.removeValue();


                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    public void update4(String id1, String username, String pass, String repass, String uname, String addr, String phone, String mail, String adhar, boolean flag1, boolean flag, boolean dflg, boolean dflg1) {
        DatabaseReference d = FirebaseDatabase.getInstance().getReference("user").child(id1);
        userlogin ul = new userlogin(id1, username, pass, repass, uname, addr, phone, mail, adhar, flag1, flag, dflg, dflg1);
        d.setValue(ul);

    }

    public void exec11() {

        db3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ass : dataSnapshot.getChildren()) {
                    death a1 = ass.getValue(death.class);
                    if (a1.getOtheml().equals(Demo.uEmail)) {
                        s = "                                                     DEATH CERTIFICATE" +
                                "\n"+
                                "\n"+
                                "\n(Issued under section 12/17 of the registration of Births and Deaths Act. 1969 and Rules 8/13 of the Maharashtra Registration of Births and Deaths Rules,2000)"+
                                "\n"+
                                "\n"+
                                "\nThis is to certify that the following information has been taken fromthe original record of death which is the register for (local area/local body ) pune muncipal corporation of tahshil/block pune of district pune of maharashtra State "+
                                "\n"+
                                "\n"+
                                "\n     Full name of Deceased :"+a1.getUsername()+
                                "\n"+
                                "\n     Gender Male :"+
                                "\n"+
                                "\n     Date of Death :"+a1.getDeathdate()+
                                "\n"+
                                "\n     Place of Death :"+a1.getDeathplace()+
                                "\n"+
                                "\n     Name of Mother :"+a1.getMother()+
                                "\n"+
                                "\n     Fullname of Father :"+a1.getFather()+
                                "\n"+
                                "\n     Husband/Wife Name :"+a1.getWihu()+
                                "\n"+
                                "\n     Time of Death :"+a1.getDeathtime()+
                                "\n"+
                                "\n     Address :"+a1.getHomeno()+a1.getStreet()+a1.getTaluka()+a1.getDistric();


                        if (s.equals("")) {
                            Toast.makeText(MDNotificationActivity.this, "Empty", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        //exec14(a1.getOtheml());
                        Intent i = new Intent(MDNotificationActivity.this, sendd.class);
                        i.putExtra("data", s);
                        i.putExtra("mail", a1.getOtheml());
                        i.putExtra("name",Demo.uUsername);
                        startActivity(i);

                        // Toast.makeText(MDNotificationActivity.this, s, Toast.LENGTH_SHORT).show();
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });
    }
}