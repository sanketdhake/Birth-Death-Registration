package com.example.bdregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DFormPActivity extends AppCompatActivity {

    private Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_form_p);

        b1=(Button)findViewById(R.id.btbackd);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DFormPActivity.this,DeathCActivity.class);
                startActivity(intent);
            }
        });

        b2=(Button)findViewById(R.id.btnextd);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DFormPActivity.this,DFormDPActivity.class);
                startActivity(intent);
            }
        });


    }
}