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

public class RDeathActivity extends AppCompatActivity {

    private Button b1;

    private EditText dfname,dmname,dwhname,dwhrelation,doname,dorelation,dophone,doemail,doacard,dpname,dpgen,dpdate,dptime,dpplace,ddhome,ddstreet,ddtaluka,dddist,ddstate;

    DatabaseReference db= FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_death);

        dfname=(EditText)findViewById(R.id.ddfname);
        dmname=(EditText)findViewById(R.id.ddmname);
        dwhname=(EditText)findViewById(R.id.ddwhname);
        dwhrelation=(EditText)findViewById(R.id.ddwhrelation);
        doname=(EditText)findViewById(R.id.ddoname);
        dorelation=(EditText)findViewById(R.id.ddorelation);
        dophone=(EditText)findViewById(R.id.ddophone);
        doemail=(EditText)findViewById(R.id.ddoemail);
        doacard=(EditText)findViewById(R.id.ddoacard);
        dpname=(EditText)findViewById(R.id.ddpname);
        dpgen=(EditText)findViewById(R.id.ddpgen);
        dpdate=(EditText)findViewById(R.id.ddpdate);
        dptime=(EditText)findViewById(R.id.ddptime);
        dpplace=(EditText)findViewById(R.id.ddpplace);
        ddhome=(EditText)findViewById(R.id.ddhome);
        ddstreet=(EditText)findViewById(R.id.ddstreet);
        ddtaluka=(EditText)findViewById(R.id.ddtaluka);
        dddist=(EditText)findViewById(R.id.dddist);
        ddstate=(EditText)findViewById(R.id.ddstate);

        b1=(Button)findViewById(R.id.bs2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sdfn=dfname.getText().toString().trim();
                String sdmn=dmname.getText().toString().trim();
                String sdwhn=dwhname.getText().toString().trim();
                String sdwhr=dwhrelation.getText().toString().trim();
                String sdon=doname.getText().toString().trim();
                String sdor=dorelation.getText().toString().trim();
                String sdop=dophone.getText().toString().trim();
                String sdoe=doemail.getText().toString().trim();
                String sdosa=doacard.getText().toString().trim();
                String sdpn=dpname.getText().toString().trim();
                String sdpg=dpgen.getText().toString().trim();
                String sdpd=dpdate.getText().toString().trim();
                String sdpt=dptime.getText().toString().trim();
                String sdpp=dpplace.getText().toString().trim();
                String sdah=ddhome.getText().toString().trim();
                String sdas=ddstreet.getText().toString().trim();
                String sdat=ddtaluka.getText().toString().trim();
                String sdad=dddist.getText().toString().trim();
                String sdast=ddstate.getText().toString().trim();

                String sid=db.push().getKey();

                doctordeathregister ddr=new doctordeathregister(sid,sdfn,sdmn,sdwhn,sdwhr,sdon,sdor,sdop,sdoe,sdosa,sdpn,sdpg,sdpd,sdpt,sdpp,sdah,sdas,sdat,sdad,sdast);
                db.child("doctordeathregister").setValue(ddr);

                Toast.makeText(getApplicationContext(),"Record Saved Successfully !!!",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(RDeathActivity.this,RegisterationDActivity.class);
                startActivity(intent);
            }
        });
    }
}
