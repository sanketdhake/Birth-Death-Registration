package com.example.bdregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BFormCActivity extends AppCompatActivity {
    private Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_form_c);

        b1=(Button)findViewById(R.id.btback);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BFormCActivity.this,BFormPActivity.class);
                startActivity(intent);
            }
        });

        b2=(Button)findViewById(R.id.btnext);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BFormCActivity.this,BFormFActivity.class);
                startActivity(intent);
            }
        });


    }
}