package com.example.bdregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DChangeActivity extends AppCompatActivity {
    DatabaseReference db1 = FirebaseDatabase.getInstance().getReference();
    DatabaseReference db2 = db1.child("Doctor_signup").getRef();
    Button b1;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_change);
        e1=(EditText)findViewById(R.id.doctorpassword);
        b1=(Button)findViewById(R.id.btnLn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db2.addValueEventListener(new ValueEventListener() {
                    @Override

                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        Toast.makeText(DChangeActivity.this,userBirth.docmail,Toast.LENGTH_SHORT).show();

                        for (DataSnapshot as2 : dataSnapshot.getChildren()) {
                            DoctorData e = as2.getValue(DoctorData.class);
                            String mail=userBirth.docmail;
                            String phn=userBirth.docphone;

                            if (e.getEmail().equals(mail) && e.getPhone().equals(phn)) {

                                String username =e.getUsername();
                                String phone= e.getPhone();
                                String fullname= e.getFullName();
                                String adhar= e.getAdhar();
                                String addr= e.getAddress();
                                String mail1=e.getEmail();
                                Toast.makeText(DChangeActivity.this,mail,Toast.LENGTH_SHORT).show();
                                String pass=e1.getText().toString();
                                String id1=e.getId1();
                                String edu=e.getEducation();
                                String hosp=e.getHospitalName();
                                String regno=e.getRegno();
                                update(id1,username,pass,fullname,addr,phone,mail1,adhar,edu,hosp,regno);
                            }
                            else {
                                Toast.makeText(DChangeActivity.this,"not found",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(DChangeActivity.this,"in ",Toast.LENGTH_SHORT).show();
                    }
                });

                Intent intent=new Intent(DChangeActivity.this,DLoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public  void update(String id1,String username,String pass,String uname,String addr,String phone,String mail1,String adhar,String edu,String hos,String reg)
    {
        DatabaseReference d=FirebaseDatabase.getInstance().getReference("Doctor_signup").child(id1);
        DoctorData ul=new DoctorData(id1,username,pass,uname,addr,phone,mail1,adhar,edu,hos,reg);
        d.setValue(ul);
        Toast.makeText(DChangeActivity.this,"updated",Toast.LENGTH_SHORT).show();
    }
}