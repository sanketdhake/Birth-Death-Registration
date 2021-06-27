package com.example.bdregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class SignUpActivity extends AppCompatActivity {

    private Button bs1,blh;
    boolean flg=false,flg1=false,dflg=false,dflg1=false;

    private EditText un,pass,repass,name,add,phone,email,acard;
    private AwesomeValidation awesomeValidation;
    DatabaseReference db= FirebaseDatabase.getInstance().getReference();
    FirebaseAuth fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        bs1=(Button)findViewById(R.id.mobtnsignup);
        blh=(Button)findViewById(R.id.lh);

        un=(EditText)findViewById(R.id.uusername);
        pass=(EditText)findViewById(R.id.upassword);
        repass=(EditText)findViewById(R.id.urepassword);
        name=(EditText)findViewById(R.id.uname);
        add=(EditText)findViewById(R.id.uaddress);
        phone=(EditText)findViewById(R.id.uphone);
        email=(EditText)findViewById(R.id.remail2);
        acard=(EditText)findViewById(R.id.uacard);
        awesomeValidation.addValidation(this, R.id.uusername, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.uname, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.uaddress, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.remail2, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.uphone, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.uacard, "^[0-9]{12}$", R.string.mobileerror);
        //  awesomeValidation.addValidation(this, R.id.editTextDob, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.dateerror);
        fb=FirebaseAuth.getInstance();
        if (fb.getCurrentUser()!=null)
        {

        }

        bs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sun = un.getText().toString().trim();
                String spass = pass.getText().toString().trim();
                String srepass = repass.getText().toString().trim();
                String sname = name.getText().toString().trim();
                String sadd = add.getText().toString().trim();
                String sphone = phone.getText().toString().trim();
                String semail = email.getText().toString().trim();
                String sacard = acard.getText().toString().trim();
                String passwordToHash = spass;
                String generatedPassword = null;
                if (awesomeValidation.validate() && spass.length()>=6 && srepass.length()>=6 ) {


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
                    spass = generatedPassword;



                    String sid = db.push().getKey();
                    String s = "user";


                    userlogin e = new userlogin(sid, sun, spass, srepass, sname, sadd, sphone, semail, sacard, flg, flg1, dflg, dflg1);
                    db.child(s).child(sid).setValue(e);
                    Toast.makeText(SignUpActivity.this, "Record saved", Toast.LENGTH_SHORT).show();
                    fb.createUserWithEmailAndPassword(semail, srepass).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "user registered succefully", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
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
                Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
