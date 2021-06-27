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

public class LoginActivity extends AppCompatActivity {

    private Button bt1,b2,b3;
    EditText t1,t2;
    FirebaseAuth fb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        t1=(EditText)findViewById(R.id.etName);
        t2=(EditText)findViewById(R.id.etPassword);
        bt1=(Button)findViewById(R.id.btns);
        b2=(Button)findViewById(R.id.btnFp);
        b3=(Button)findViewById(R.id.btnLogin);
        fb=FirebaseAuth.getInstance();
        if(fb.getCurrentUser()!=null){

        }
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validate();
                //Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                //startActivity(intent);
                String sd=t1.getText().toString().trim();
                userBirth.birthmail=sd;
            }
        });
    }
    public void validate()
    {
        final String email=t1.getText().toString().trim();
        String pass=t2.getText().toString().trim();


        if (email.isEmpty()) {
            t1.setError("Email Required");
            t1.requestFocus();
            return;
        }
        if (pass.isEmpty()) {
            t2.setError("Password Required");
            t2.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            t2.setError("Enter the vaild email");
            t2.requestFocus();
            return;
        }
        if (pass.length() < 6) {
            t2.setError("Password should contain atleast 6 characters");
            t2.requestFocus();
            return;
        }

        fb.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this,"welcome",Toast.LENGTH_SHORT).show();
                    userBirth.usermail=email;
                    Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this ,"You are not valid user",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
