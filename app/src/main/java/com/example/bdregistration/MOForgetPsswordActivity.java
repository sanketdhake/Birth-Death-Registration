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

public class MOForgetPsswordActivity extends AppCompatActivity {

    FirebaseAuth auth;
    private Button b1;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_o_forget_pssword);
        auth=FirebaseAuth.getInstance();
        e2=(EditText)findViewById(R.id.email);
        b1=(Button)findViewById(R.id.btncp);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s=e2.getText().toString();
                auth.sendPasswordResetEmail(s).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(MOForgetPsswordActivity.this, "we have sent you link to reset password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}
