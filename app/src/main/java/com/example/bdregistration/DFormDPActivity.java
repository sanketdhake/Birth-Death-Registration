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

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DFormDPActivity extends AppCompatActivity {
    EditText username,usergen,deathdate,deathtime,deathplace,docname,father,mother,wihu,wihurel,othname,othrel,othphn,otheml,homeno,street,taluka,distric,state;
    String  susername,susergen,sdeathdate,sdeathtime,sdeathplace,sdocname,sfather,smother,swihu,swihurel,sothname,sothrel,sothphn,sotheml,shomeno,sstreet,staluka,sdistric,sstate;

    private Button b1,b2;
    DatabaseReference ddb= FirebaseDatabase.getInstance().getReference();
    DatabaseReference d1=ddb.child("BirthInfo").getRef();
    private AwesomeValidation awesomeValidation;
    // FirebaseAuth fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_form_d_p);
        //     fb=FirebaseAuth.getInstance();
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        username=(EditText)findViewById(R.id.duname);
        usergen=(EditText)findViewById(R.id.dugen);
        deathdate=(EditText)findViewById(R.id.dudd);
        deathtime=(EditText)findViewById(R.id.dudt);
        deathplace=(EditText)findViewById(R.id.dudp);
        docname=(EditText)findViewById(R.id.dudname);
        father=(EditText)findViewById(R.id.dufather);
        mother=(EditText)findViewById(R.id.dumother);
        wihu=(EditText)findViewById(R.id.duwh);
        wihurel=(EditText)findViewById(R.id.durelation);
        othname=(EditText)findViewById(R.id.duoname);
        othrel=(EditText)findViewById(R.id.duorelation);
        othphn=(EditText)findViewById(R.id.duophn);
        otheml=(EditText)findViewById(R.id.duoeml);
        homeno=(EditText)findViewById(R.id.duhno);
        street=(EditText)findViewById(R.id.dustrname);
        taluka=(EditText)findViewById(R.id.dutaluka);
        distric=(EditText)findViewById(R.id.dudist);
        state=(EditText)findViewById(R.id.dustate);
        awesomeValidation.addValidation(this, R.id.duname, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.dugen, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.dudname, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.dufather, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.dumother, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.duwh, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.durelation, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.dudp, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.dustrname, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.dutaluka, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.dudist, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.dustate, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);

        awesomeValidation.addValidation(this, R.id.duoeml, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.duophn, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.dudd, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.dateerror);


        b1=(Button)findViewById(R.id.duback);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(DFormDPActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        b2=(Button)findViewById(R.id.dunext);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if(awesomeValidation.validate()) {

                    Toast.makeText(DFormDPActivity.this, "1", Toast.LENGTH_SHORT).show();
                    check();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please enter correct values",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
    public void check()
    {
        Toast.makeText(DFormDPActivity.this,"2",Toast.LENGTH_SHORT).show();
        d1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Toast.makeText(DFormDPActivity.this,"3",Toast.LENGTH_SHORT).show();
                susername=username.getText().toString();
                susergen=usergen.getText().toString().trim();
                sdeathdate=deathdate.getText().toString().trim();
                sdeathtime=deathtime.getText().toString().trim();
                sdeathplace=deathplace.getText().toString().trim();
                sdocname=docname.getText().toString().trim();
                sfather=father.getText().toString().trim();
                smother=mother.getText().toString().trim();
                swihu=wihu.getText().toString().trim();
                swihurel=wihurel.getText().toString().trim();
                sothname=othname.getText().toString().trim();
                sothrel=othrel.getText().toString().trim();
                sothphn=othphn.getText().toString().trim();
                sotheml=otheml.getText().toString().trim();
                shomeno=homeno.getText().toString().trim();
                sstreet=street.getText().toString().trim();
                staluka=taluka.getText().toString().trim();
                sdistric=distric.getText().toString().trim();
                sstate=state.getText().toString().trim();

                for(DataSnapshot as1: dataSnapshot.getChildren())
                {
                    Toast.makeText(DFormDPActivity.this,"4",Toast.LENGTH_SHORT).show();
                    childinfo c=as1.getValue(childinfo.class);
                    Toast.makeText(DFormDPActivity.this,c.getTrusted1(),Toast.LENGTH_SHORT).show();
                    Toast.makeText(DFormDPActivity.this,c.getTrusted2(),Toast.LENGTH_SHORT).show();
                    Toast.makeText(DFormDPActivity.this,c.getTrustedr1(),Toast.LENGTH_SHORT).show();
                    Toast.makeText(DFormDPActivity.this,c.getTrustedr2(),Toast.LENGTH_SHORT).show();
                    Toast.makeText(DFormDPActivity.this,sotheml,Toast.LENGTH_SHORT).show();
                    Toast.makeText(DFormDPActivity.this,sothrel,Toast.LENGTH_SHORT).show();
                    if ((c.getTrusted1().equals(sotheml)&& c.getTrustedr1().equals(sothrel))|| (c.getTrusted2().equals(sotheml)&& c.getTrustedr2().equals(sothrel)))
                    {
                        String sid1=ddb.push().getKey();
                        String s1="dead_peoples";
                        death e1=new death(susername,susergen,sdeathdate,sdeathtime,sdeathplace,sdocname,sfather,smother,swihu,swihurel,sothname,sothrel,sothphn,sotheml,shomeno,sstreet,staluka,sdistric,sstate,false);
                        ddb.child(s1).child(sid1).setValue(e1);
                        Toast.makeText(DFormDPActivity.this,"Record saved"+susername,Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(DFormDPActivity.this,DeathCActivity.class);
                        startActivity(intent);

                    }
                    else {
                        Toast.makeText(DFormDPActivity.this,"Relative information incorrect",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
