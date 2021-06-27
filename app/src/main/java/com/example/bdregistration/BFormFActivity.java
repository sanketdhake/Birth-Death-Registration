package com.example.bdregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BFormFActivity extends AppCompatActivity {

    private Button btnsr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_form_f);

        btnsr=(Button)findViewById(R.id.btnsr);
        btnsr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Request sent Successfully !!!",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(BFormFActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
