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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DLoginActivity extends AppCompatActivity {

    private Button bt1,b2,b3;
    EditText t1,t2,t3;


    FirebaseAuth fb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_login);

        bt1=(Button)findViewById(R.id.btns);
        b2=(Button)findViewById(R.id.btnFp);
        b3=(Button)findViewById(R.id.btnLogin);

        t2=(EditText)findViewById(R.id.etName);
        t3=(EditText)findViewById(R.id.etPassword);
        fb=FirebaseAuth.getInstance();
        if(fb.getCurrentUser()!=null){

        }



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DLoginActivity.this,DSignUpActivity.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DLoginActivity.this,DForgetPasswordActivity.class);
                startActivity(intent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();

            }
        });
    }
    public void validate()
    {
        final String email=t2.getText().toString().trim();
        String password=t3.getText().toString().trim();
        userBirth.dlmail=email;
        if (email.isEmpty()) {
            t2.setError("Email Required");
            t2.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            t3.setError("Password Required");
            t3.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            t3.setError("Enter the vaild email");
            t3.requestFocus();
            return;
        }
        if (password.length() < 6) {
            t3.setError("Password should contain atleast 6 characters");
            t3.requestFocus();
            return;
        }

        fb.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(DLoginActivity.this,"welcome",Toast.LENGTH_SHORT).show();
                    userBirth.doctmail=email;
                    Intent intent=new Intent(DLoginActivity.this,DcHomeActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(DLoginActivity.this ,"You are not valid user",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}