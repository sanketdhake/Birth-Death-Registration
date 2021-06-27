package com.example.bdregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPasswordActivity extends AppCompatActivity {

    FirebaseAuth auth;
    private Button b1;
    EditText t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.phone);
        t3=(EditText)findViewById(R.id.adhar);
        auth=FirebaseAuth.getInstance();
        b1=(Button)findViewById(R.id.btncp);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=t1.getText().toString();
                auth.sendPasswordResetEmail(s).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful())
                        {
                            Toast.makeText(ForgetPasswordActivity.this,"we have sent you link to reset password",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}