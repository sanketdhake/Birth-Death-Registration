package com.example.bdregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class adhar extends AppCompatActivity {
    DatabaseReference db1 = FirebaseDatabase.getInstance().getReference();
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adhar);
        b=(Button)findViewById(R.id.bc);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id=db1.push().getKey();
                String ad="345267546854";
                String m="aniket@gmail.com";
                addadhar a=new addadhar(ad,m);
                db1.child(" Doctor_Adhar").child(id).setValue(a);
                Toast.makeText(adhar.this,"dchh",Toast.LENGTH_SHORT).show();
            }
        });
    }


}