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

public class Act2 extends AppCompatActivity {

    DatabaseReference modb= FirebaseDatabase.getInstance().getReference();
    private Button bs1,blh;
    private    String id,sname,semail,spass,sreg,saddre,sregno,sphnno;
    private EditText name,email,pass,reg,addre,regno,phnno;
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        name=(EditText)findViewById(R.id.moname1);
        email=(EditText)findViewById(R.id.momail1);
        pass=(EditText)findViewById(R.id.mopass1);
        reg=(EditText)findViewById(R.id.moreg1);
        addre=(EditText)findViewById(R.id.moaddr1);
        regno=(EditText)findViewById(R.id.moregno1);
        phnno=(EditText)findViewById(R.id.mophnno1);
        bs1=(Button)findViewById(R.id.moSignUp1);
        blh=(Button)findViewById(R.id.moback1);
        awesomeValidation.addValidation(this, R.id.moname1, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.momail1, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.mophnno1, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        //awesomeValidation.addValidation(this, R.id.editTextDob, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.nameerror);
        //awesomeValidation.addValidation(this, R.id.editTextAge, Range.closed(13, 60), R.string.ageerror);

        bs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
                sname=name.getText().toString().trim();
                semail=email.getText().toString().trim();
                spass=pass.getText().toString().trim();
                sreg=reg.getText().toString().trim();
                sregno=regno.getText().toString().trim();
                saddre=addre.getText().toString().trim();
                sphnno=phnno.getText().toString().trim();
                id=modb.push().getKey();
                mosignup m=new mosignup(id,sname,semail,spass,sreg,saddre,sregno,sphnno);
                modb.child("Municipal_Office_Logins").setValue(m);
                Toast.makeText(Act2.this,"data saved",Toast.LENGTH_SHORT).show();
                Intent mointent=new Intent(Act2.this,MOLoginActivity.class);
                startActivity(mointent);

            }
        });
        blh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moints=new Intent(Act2.this,MOLoginActivity.class);
                startActivity(moints);
            }
        });
    }
    private void submitForm() {
        //first validate the form then move ahead
        //if this becomes true that means validation is successfull
        if (awesomeValidation.validate()) {
            Toast.makeText(this, "Validation Successfull", Toast.LENGTH_LONG).show();

            //process the data further
        }
    }
}
