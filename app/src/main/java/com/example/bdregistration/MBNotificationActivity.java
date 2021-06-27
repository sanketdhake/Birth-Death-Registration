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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MBNotificationActivity extends AppCompatActivity {

    String s;
    private Button b1;
    DatabaseReference db1 = FirebaseDatabase.getInstance().getReference();
    DatabaseReference db2 = db1.child("user").getRef();
    DatabaseReference db3 = db1.child("BirthInfo").getRef();
    ListView l1;
    List<userlogin> list1;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 111;
    private File pdfFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_b_notification);

        l1 = findViewById(R.id.list);
        list1 = new ArrayList<>();

        b1=(Button)findViewById(R.id.check);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        list1.clear();
                        for (DataSnapshot as1 : dataSnapshot.getChildren()) {
                            userlogin e = as1.getValue(userlogin.class);
                            if (e.getFlg1()) {
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
                                        boolean flag1=u.getFlg();
                                        boolean flag=false;
                                        boolean dflg=u.getDflg(),dflg1=u.getDflg1();
                                        update(id1,username,pass,repass,uname,addr,phone,mail,adhar,flag1,flag,dflg,dflg1);

                                        exec12();


                                    }
                                });
                            }
                        }
                        EntryList e1 = new EntryList(MBNotificationActivity.this, list1);
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
    }
    public void exec12()
    {
        db3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ass : dataSnapshot.getChildren()){
                    childinfo a1=ass.getValue(childinfo.class);
                    if(a1.getEmailid().equals(Demo.uEmail))
                    {
                        s="BIRTH CERTIFICATE"+
                                "\nChilds Father Name "+a1.getChildfather()+
                                "\nChilds Father phone number "+a1.getFatherphn()+
                                "\nChilds Father aharcard "+a1.getFatheradhar()+
                                "\nChilds Mother Name "+a1.getChildmother()+
                                "\nChilds Mother Phone number "+a1.getMotherphn()+
                                "\nChilds Mother adharcard "+a1.getMotheradhar()+
                                "\nChilds address "+a1.getHousename()+"\t"+a1.getStreet()+"\t"+a1.getTaluka()+"\t"+a1.getDistrict()+"\t"+a1.getState()+
                                "\nChilds Name"+a1.getChildname()+
                                "\nChilds Gender"+a1.getGender()+
                                "\nChilds Birth Date "+a1.getBirthdate()+
                                "\nChilds Birth Time "+a1.getBirthtime()+
                                "\nChilds Birth Place"+a1.getBirthplace()+
                                "\nChilds Blood Group "+a1.getBloodgroup()+
                                "\nChilds Hospital name"+a1.getHospitalname()+
                                "\nChilds Doctor Name"+a1.getDoctorname();
                        if(s.equals("")){
                            Toast.makeText(MBNotificationActivity.this,"Empty",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Intent i=new Intent(MBNotificationActivity.this,sendb.class);
                        i.putExtra("data",s);
                        i.putExtra("mail",a1.getEmailid());
                        i.putExtra("name",Demo.uUsername);
                        startActivity(i);

                        Toast.makeText(MBNotificationActivity.this,s,Toast.LENGTH_SHORT).show();
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


}
