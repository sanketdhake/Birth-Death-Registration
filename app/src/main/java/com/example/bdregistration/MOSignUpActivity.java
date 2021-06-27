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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MOSignUpActivity extends AppCompatActivity {

    DatabaseReference modb = FirebaseDatabase.getInstance().getReference();
    Button bs1, blh;
    private AwesomeValidation awesomeValidation;
    public String id, sname, semail, spass, sreg, saddre, sregno, sphnno;
    private EditText name, email, pass, reg, addre, regno, phnno, con;
    FirebaseAuth fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_o_sign_up);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        bs1 = (Button) findViewById(R.id.mobtnsignup1);
        blh = (Button) findViewById(R.id.moback1);
        name = (EditText) findViewById(R.id.moname1);
        email = (EditText) findViewById(R.id.momail1);
        pass = (EditText) findViewById(R.id.mopass1);
        con = (EditText) findViewById(R.id.moconfirm1);
        reg = (EditText) findViewById(R.id.moreg1);
        addre = (EditText) findViewById(R.id.moaddr1);
        regno = (EditText) findViewById(R.id.moregno1);
        phnno = (EditText) findViewById(R.id.mophnno1);
        awesomeValidation.addValidation(this, R.id.moname1, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.moreg1, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.moaddr1, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.mophnno1, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.momail1, Patterns.EMAIL_ADDRESS, R.string.emailerror);

        fb = FirebaseAuth.getInstance();
        if (fb.getCurrentUser() != null) {
        }

        bs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pswd=pass.getText().toString();
                String conpswd=con.getText().toString();
                if (awesomeValidation.validate() && pswd.length()>=6 &&conpswd.length()>=6) {

                    add();
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
                Intent moints = new Intent(MOSignUpActivity.this, MOLoginActivity.class);
                startActivity(moints);
            }
        });
    }

    public void add() {
        sname = name.getText().toString().trim();
        semail = email.getText().toString().trim();
        spass = pass.getText().toString().trim();
        String orig=spass;
        sreg = reg.getText().toString().trim();
        sregno = regno.getText().toString().trim();
        saddre = addre.getText().toString().trim();
        sphnno = phnno.getText().toString().trim();

        String con1 = con.getText().toString().trim();
        String passwordToHash = spass;
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
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        spass = generatedPassword;


        if (!TextUtils.isEmpty(sname) && !TextUtils.isEmpty(semail) && !TextUtils.isEmpty(spass) && !TextUtils.isEmpty(sreg) && !TextUtils.isEmpty(sregno) && !TextUtils.isEmpty(saddre) && !TextUtils.isEmpty(sphnno)) {
            {
                id = modb.push().getKey();

                mosignup m = new mosignup(id, sname, semail, spass, sreg, saddre, sregno, sphnno);
                modb.child("Municipal_Office_Logins").child(id).setValue(m);
                Toast.makeText(MOSignUpActivity.this, "data saved", Toast.LENGTH_SHORT).show();

                fb.createUserWithEmailAndPassword(semail, orig).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //  Toast.makeText(MOSignUpActivity.this," saved",Toast.LENGTH_SHORT).show();
                        }


                        Intent mointent = new Intent(MOSignUpActivity.this, MOLoginActivity.class);
                        startActivity(mointent);
                    }
                });

            }

        } else {
            Toast.makeText(MOSignUpActivity.this,"Enter all fields ",Toast.LENGTH_SHORT).show();
        }
    }

}