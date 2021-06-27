package com.example.bdregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RBirthActivity extends AppCompatActivity {

    private Button b1;

    private EditText dfname,dfphone,dfemail,dfacard,dmname,dmphone,dmemail,dmacard,dcgen,dcdate,dctime,dcplace,dcbloodgrp,dbhome,dbstreet,dbtaluka,dbdist,dbstate;

    DatabaseReference db= FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_birth);

        dfname=(EditText)findViewById(R.id.dfname);
        dfphone=(EditText)findViewById(R.id.dfphone);
        dfemail=(EditText)findViewById(R.id.dfemail);
        dfacard=(EditText)findViewById(R.id.dfacard);
        dmname=(EditText)findViewById(R.id.dmname);
        dmphone=(EditText)findViewById(R.id.dmphone);
        dmemail=(EditText)findViewById(R.id.dmemail);
        dmacard=(EditText)findViewById(R.id.dmacard);
        dcgen=(EditText)findViewById(R.id.dcgender);
        dcdate=(EditText)findViewById(R.id.dcdate);
        dctime=(EditText)findViewById(R.id.dctime);
        dcplace=(EditText)findViewById(R.id.dcplace);
        dcbloodgrp=(EditText)findViewById(R.id.dcbloodgrp);
        dbhome=(EditText)findViewById(R.id.dbhome);
        dbstreet=(EditText)findViewById(R.id.dbstreet);
        dbtaluka=(EditText)findViewById(R.id.dbtaluka);
        dbdist=(EditText)findViewById(R.id.dbdist);
        dbstate=(EditText)findViewById(R.id.dbstate);

        b1=(Button)findViewById(R.id.bs1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sbfn=dfname.getText().toString().trim();
                String sbfp=dfphone.getText().toString().trim();
                String sbfe=dfemail.getText().toString().trim();
                String sbfa=dfacard.getText().toString().trim();
                String sbmn=dmname.getText().toString().trim();
                String sbmp=dmphone.getText().toString().trim();
                String sbme=dmemail.getText().toString().trim();
                String sbma=dmacard.getText().toString().trim();
                String sbcg=dcgen.getText().toString().trim();
                String sbcd=dcdate.getText().toString().trim();
                String sbct=dctime.getText().toString().trim();
                String sbcp=dcplace.getText().toString().trim();
                String sbcbg=dcbloodgrp.getText().toString().trim();
                String sbah=dbhome.getText().toString().trim();
                String sbas=dbstreet.getText().toString().trim();
                String sbat=dbtaluka.getText().toString().trim();
                String sbad=dbdist.getText().toString().trim();
                String sbast=dbstate.getText().toString().trim();

                String sid=db.push().getKey();

                doctorbirthregister dbr=new doctorbirthregister(sid,sbfn,sbfp,sbfe,sbfa,sbmn,sbmp,sbme,sbma,sbcg,sbcd,sbct,sbcp,sbcbg,sbah,sbas,sbat,sbad,sbast);
                db.child("doctorbirthregister").setValue(dbr);

                Toast.makeText(getApplicationContext(),"Record Saved Successfully !!!",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(RBirthActivity.this,RegisterationDActivity.class);
                startActivity(intent);
            }
        });
    }
}
