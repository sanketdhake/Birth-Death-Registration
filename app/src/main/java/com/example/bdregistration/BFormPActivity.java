package com.example.bdregistration;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BFormPActivity extends AppCompatActivity {

    private Button b1,b2;
    private AwesomeValidation awesomeValidation;
    DatabaseReference db= FirebaseDatabase.getInstance().getReference();
    EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12,et13,et14,et15,et16,et17,et18,et19,et20,et21,et22,et23,et24,et25,et26;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_form_p);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        et1=(EditText)findViewById(R.id.cfname);
        et2=(EditText)findViewById(R.id.cfphn);
        et3=(EditText)findViewById(R.id.cfemail);
        et4=(EditText)findViewById(R.id.cfacn);
        et5=(EditText)findViewById(R.id.cmname);
        et6=(EditText)findViewById(R.id.cmphn);
        et7=(EditText)findViewById(R.id.cmemail);
        et8=(EditText)findViewById(R.id.cmacn);
        et9=(EditText)findViewById(R.id.cphn);
        et10=(EditText)findViewById(R.id.cpsn);
        et11=(EditText)findViewById(R.id.cpt);
        et12=(EditText)findViewById(R.id.cpd);
        et13=(EditText)findViewById(R.id.cps);
        et14=(EditText)findViewById(R.id.cn);
        et15=(EditText)findViewById(R.id.cg);
        et16=(EditText)findViewById(R.id.cbd);
        et17=(EditText)findViewById(R.id.cbt);
        et18=(EditText)findViewById(R.id.cbp);
        et19=(EditText)findViewById(R.id.cbg);
        et20=(EditText)findViewById(R.id.chn);
        et21=(EditText)findViewById(R.id.cdn);
        et22=(EditText)findViewById(R.id.emailid);
        et23=(EditText)findViewById(R.id.trustp1);
        et24=(EditText)findViewById(R.id.trustpr1);
        et25=(EditText)findViewById(R.id.trustp2);
        et26=(EditText)findViewById(R.id.trustpr2);
        awesomeValidation.addValidation(this, R.id.cfname, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.cfemail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.cfphn, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.cfacn, "^[0-9]{12}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.cmname, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.cmemail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.cmphn, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.cmacn, "^[0-9]{12}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.cpsn, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.cpt, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.cpd, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.cps, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.emailid, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.cn, "^[0-9]{1}$", R.string.numbererror);
        awesomeValidation.addValidation(this, R.id.cg, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.cbd, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.cbp, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.trustp1, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.trustpr1, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.trustp2, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.trustpr2, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);




        b1=(Button)findViewById(R.id.btbackb);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BFormPActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        b2=(Button)findViewById(R.id.btnextb);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = et1.getText().toString();
                String st2 = et2.getText().toString();
                String st3 = et3.getText().toString();
                String st4 = et4.getText().toString();
                String st5 = et5.getText().toString();
                String st6 = et6.getText().toString();
                String st7 = et7.getText().toString();
                String st8 = et8.getText().toString();
                String st9 = et9.getText().toString();
                String st10 = et10.getText().toString();
                String st11 = et11.getText().toString();
                String st12 = et12.getText().toString();
                String st13 = et13.getText().toString();
                String st14 = et14.getText().toString();
                String st15 = et15.getText().toString();
                String st16 = et16.getText().toString();
                String st17 = et17.getText().toString();
                String st18 = et18.getText().toString();
                String st19 = et19.getText().toString();
                String st20 = et20.getText().toString();
                String st21 = et21.getText().toString();
                String st22 = et22.getText().toString();
                String st23 = et23.getText().toString();
                String st24 = et24.getText().toString();
                String st25 = et25.getText().toString();
                String st26 = et26.getText().toString();
                if (awesomeValidation.validate()) {

                    String id = db.push().getKey();
                    childinfo e = new childinfo(id, st1, st2, st2, st4, st5, st6, st7, st8, st9, st10, st11, st12, st13, st14, st15, st16, st17, st18, st19, st20, st21, st22, false, st23, st24, st25, st26);
                    db.child("BirthInfo").child(id).setValue(e);
                    userBirth.dfmail = st21;
                    Toast.makeText(BFormPActivity.this, "Successfully inserted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(BFormPActivity.this, BirthCActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"Please enter correct values",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}