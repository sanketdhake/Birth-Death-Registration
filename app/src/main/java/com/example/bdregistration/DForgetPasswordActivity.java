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

public class DForgetPasswordActivity extends AppCompatActivity {

    FirebaseAuth auth;
    private Button b1;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_forget_password);
        e1=(EditText)findViewById(R.id.doctormail);
        auth=FirebaseAuth.getInstance();
        b1=(Button)findViewById(R.id.btncp);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e=e1.getText().toString();

                auth.sendPasswordResetEmail(e).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(DForgetPasswordActivity.this, "we have sent you link to reset password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
