package com.example.bdregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MOLoginActivity extends AppCompatActivity {

    private Button b111,b2,b3;
    EditText t2,t3;
    FirebaseAuth fb;
    ProgressDialog pg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_o_login);
        t2=(EditText)findViewById(R.id.etName);
        t3=(EditText)findViewById(R.id.etPassword);
        b111=(Button)findViewById(R.id.mosignupbtn);
        b2=(Button)findViewById(R.id.btnFp);
        b3=(Button)findViewById(R.id.btnLogin);
        pg=new ProgressDialog(this);
        fb=FirebaseAuth.getInstance();
        if(fb.getCurrentUser()!=null){}
        b111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MOLoginActivity.this,MOSignUpActivity.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MOLoginActivity.this,MOForgetPsswordActivity.class);
                startActivity(intent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // pg.setMessage("Loading.....");
                validate();
                //pg.cancel();
                //Intent intent=new Intent(MOLoginActivity.this,MoHomeActivity.class);
                //startActivity(intent);
            }
        });
    }
    public void validate()
    {
        final String mail=t2.getText().toString().trim();
        String pass=t3.getText().toString().trim();
        if (mail.isEmpty()) {
            t2.setError("Email Required");
            t2.requestFocus();
            return;
        }
        if (pass.isEmpty()) {
            t3.setError("Password Required");
            t3.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            t2.setError("Enter the vaild email");
            t2.requestFocus();
            return;
        }
        if (pass.length() < 6) {
            t3.setError("Password should contain atleast 6 characters");
            t3.requestFocus();
            return;
        }

        fb.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MOLoginActivity.this,"welcome",Toast.LENGTH_SHORT).show();
                    userBirth.momail=mail;
                    Intent intent=new Intent(MOLoginActivity.this,MoHomeActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MOLoginActivity.this ,"You are not valid user",Toast.LENGTH_SHORT).show();

                }
            }
        });
//        pg.show();
    }
}
