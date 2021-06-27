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

public class ChangePasswordActivity extends AppCompatActivity {
    DatabaseReference db1 = FirebaseDatabase.getInstance().getReference();
    DatabaseReference db2 = db1.child("user").getRef();

    private Button b1;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        e1=(EditText)findViewById(R.id.newpass);
        b1=(Button)findViewById(R.id.btnLn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot as1 : dataSnapshot.getChildren()) {
                            userlogin e = as1.getValue(userlogin.class);
                            String mail=userBirth.forgetmail;
                            String phn=userBirth.forgetphone;

                            if (e.getuEmail().equals(mail)&& e.getuPhone().equals(phn)) {

                                String username =e.getuUsername();
                                String phone= e.getuPhone();
                                String uname= e.getuName();
                                String adhar= e.getuAdharCard();
                                String addr= e.getuAddress();
                                String mail1=e.getuEmail();
                                Toast.makeText(ChangePasswordActivity.this,mail,Toast.LENGTH_SHORT).show();
                                String repass=e1.getText().toString();
                                String pass=e1.getText().toString();
                                String id1=e.getId();
                                boolean flag1=e.getFlg1();
                                boolean flag=e.getDflg(),dflg=e.getDflg(),dflg1=e.getDflg1();

                                update(id1,username,pass,repass,uname,addr,phone,mail1,adhar,flag1,flag,dflg,dflg1);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                Intent intent=new Intent(ChangePasswordActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public  void update(String id1,String username,String pass,String repass,String uname,String addr,String phone,String mail,String adhar,boolean flag1,boolean flag,boolean dflg,boolean dflg1)
    {
        DatabaseReference d=FirebaseDatabase.getInstance().getReference("user").child(id1);
        userlogin ul=new userlogin(id1,username,pass,repass,uname,addr,phone,mail,adhar,flag1,flag,dflg,dflg1);
        d.setValue(ul);
        Toast.makeText(ChangePasswordActivity.this,"updated",Toast.LENGTH_SHORT).show();
    }
}
