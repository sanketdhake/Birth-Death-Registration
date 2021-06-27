package com.example.bdregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DSignUpActivity extends AppCompatActivity {


    private Button bs1,blh;
    private EditText t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    DatabaseReference d= FirebaseDatabase.getInstance().getReference();
    DatabaseReference d1=d.child(" Doctor_Adhar").getRef();
    FirebaseAuth fb;
    private AwesomeValidation awesomeValidation;
    // FirebaseUser fu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_sign_up);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        t3=(EditText)findViewById(R.id.t3);
        t4=(EditText)findViewById(R.id.t4);
        t5=(EditText)findViewById(R.id.t5);
        t6=(EditText)findViewById(R.id.t6);
        t7=(EditText)findViewById(R.id.t7);
        t8=(EditText)findViewById(R.id.t8);
        t9=(EditText)findViewById(R.id.t9);
        t10=(EditText)findViewById(R.id.t10);
        t11=(EditText)findViewById(R.id.t11);
        bs1=(Button)findViewById(R.id.btnSignUp);
        blh=(Button)findViewById(R.id.lh);
        awesomeValidation.addValidation(this, R.id.t1, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.t2, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.t3, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.t4, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.t5, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.t7, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.t6, "^[0-9]{10}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.t8, "^[0-9]{12}$",R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.t9, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.t10, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        //  awesomeValidation.addValidation(this, R.id.editTextDob, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.dateerror);

        fb=FirebaseAuth.getInstance();
        if (fb.getCurrentUser()!=null)
        {

        }



        bs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (awesomeValidation.validate()) {

                    adddata();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please enter correct values",Toast.LENGTH_SHORT).show();
                }


            }
        });

        blh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DSignUpActivity.this, DLoginActivity.class);
                startActivity(intent);

            }
        });
    }
    public void adddata()
    {
        String orig;
        final String dname=t1.getText().toString().trim();
        final String dpass=t2.getText().toString().trim();
        final String drepass=t3.getText().toString().trim();
        final String dfullname=t4.getText().toString().trim();
        final String daddr=t5.getText().toString().trim();
        final String dphone=t6.getText().toString().trim();
        final String dmail=t7.getText().toString().trim();
        final String dadhar=t8.getText().toString().trim();
        final String dedu=t9.getText().toString().trim();
        final String dhosp=t10.getText().toString().trim();
        final String dregno=t11.getText().toString().trim();
        String passwordToHash = dpass;
        String generatedPassword = null;



        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        userBirth.encrl= generatedPassword;

        d1.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //  Toast.makeText(DSignUpActivity.this,"Data saved2 "+dadhar,Toast.LENGTH_SHORT).show();
                for(DataSnapshot as1: dataSnapshot.getChildren())
                {
                    //    Toast.makeText(DSignUpActivity.this,"Data saved3 ",Toast.LENGTH_SHORT).show();
                    addadhar e = as1.getValue(addadhar.class);
                    if(e.getAdhar().equals(dadhar)&& e.getMail().equals(dmail))
                    {
                        if(!TextUtils.isEmpty(dname)&&!TextUtils.isEmpty(dpass)&&!TextUtils.isEmpty(drepass) &&!TextUtils.isEmpty(dfullname)&&!TextUtils.isEmpty(daddr)&&!TextUtils.isEmpty(dphone)&&!TextUtils.isEmpty(dmail)&&!TextUtils.isEmpty(dadhar)&&!TextUtils.isEmpty(dedu)&&!TextUtils.isEmpty(dhosp)&&!TextUtils.isEmpty(dregno))
                        {
                            if (!dpass.equals(drepass)){
                                t3.setError("password not matched");
                                t3.requestFocus();
                                return;
                            }
                            String id=d.push().getKey();
                            DoctorData d1=new DoctorData(id,dname,dpass,dfullname,daddr,dphone,dmail,dadhar,dedu,dhosp,dregno);
                            d.child(" Doctor_signup").child(id).setValue(d1);
                            Toast.makeText(DSignUpActivity.this,"Data saved ",Toast.LENGTH_SHORT).show();


                            fb.createUserWithEmailAndPassword(dmail,userBirth.encrl).addOnCompleteListener(DSignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful())
                                    {
                                        //  Toast.makeText(DSignUpActivity.this,"user registered succefully",Toast.LENGTH_SHORT).show();
                                    }
                                    Intent intent=new Intent(DSignUpActivity.this,DLoginActivity.class);
                                    startActivity(intent);
                                }
                            });
                        }
                        else {
                            Toast.makeText(DSignUpActivity.this,"Enter all fields ",Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        Toast.makeText(DSignUpActivity.this,"you are not valid user",Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }
}
