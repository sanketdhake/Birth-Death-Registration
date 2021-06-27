package com.example.bdregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MOChangeActivity extends AppCompatActivity {

    DatabaseReference db1 = FirebaseDatabase.getInstance().getReference();
    DatabaseReference db2 = db1.child("Municipal_Office_Logins").getRef();
    FirebaseAuth fb;
    private Button b1;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_o_change);
        e1=(EditText)findViewById(R.id.mupass);
        fb = FirebaseAuth.getInstance();
        b1=(Button)findViewById(R.id.btnLn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot as1 : dataSnapshot.getChildren()) {
                            mosignup e = as1.getValue(mosignup.class);
                            String mail=userBirth.mmail;
                            String phn=userBirth.mphone;


                            if (e.getSremail().equals(mail) && e.getSrphnno().equals(phn)) {

                                String username =e.getSrname();
                                String phone= e.getSrphnno();
                                // String uname= e.getuName();
                                // String adhar= e.getuAdharCard();
                                String addr= e.getSraddre();
                                String mail1=e.getSremail();
                                String reg=e.getSrreg();
                                String regno=e.getSrregno();
                                String pass=e1.getText().toString();
                                String id1=e.getSrid();
                                update1(mail,pass);
                                update(id1, username, mail, pass, reg, addr, regno, phone);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


                Intent intent=new Intent(MOChangeActivity.this,MOLoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public void update1(String mail,String pass)

    {
        fb.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MOChangeActivity.this," saved",Toast.LENGTH_SHORT).show();
                }

                //  Toast.makeText(MOChangeActivity.this, "updated", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public  void update(String id1, String username,String mail,String pass,String reg,String addr,String regno,String phone) {
        DatabaseReference d = FirebaseDatabase.getInstance().getReference("Municipal_Office_Logins").child(id1);
        mosignup ul = new mosignup(id1, username, mail, pass, reg, addr, regno, phone);
        d.setValue(ul);

    }
}