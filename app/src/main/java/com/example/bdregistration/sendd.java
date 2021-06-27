package com.example.bdregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class sendd extends AppCompatActivity {

    Button b1;
    DatabaseReference db1 = FirebaseDatabase.getInstance().getReference();
    DatabaseReference db2 = db1.child("Alive_People").getRef();
    DatabaseReference db3 = db1.child("user").getRef();

    final private int REQUEST_CODE_ASK_PERMISSIONS = 111;
    private File pdfFile;
    String s,m,n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendb);
        b1=(Button)findViewById(R.id.btnb);
        Intent i=getIntent();
        s=i.getStringExtra("data");
        m=i.getStringExtra("mail");
        n=i.getStringExtra("name");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db2.addValueEventListener(new ValueEventListener() {
                    @Override

                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot as1 : dataSnapshot.getChildren()) {

                            AlivePeople e = as1.getValue(AlivePeople.class);



                            if (e.getAmail().equals(m) && e.getAname().equals(n)) {

                                String username =e.getAname();

                                String mail1=e.getAmail();
                                String id1=e.getAid();

                                delete(id1,mail1,username);

                                update14();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



                pdf();
            }
        });
    }
    public void update14()
    {
        Toast.makeText(sendd.this,m,Toast.LENGTH_SHORT).show();
        db2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot as1 : dataSnapshot.getChildren()) {
                    userlogin u = as1.getValue(userlogin.class);
                    if (u.getuEmail().equals(m)) {

                        String username =  u.getuUsername();
                        String phone =  u.getuPhone();
                        String uname =  u.getuName();
                        String adhar = u.getuAdharCard();
                        String addr = u.getuAddress();
                        String mail =  u.getuEmail();
                        String repass =  u.getuRepassword();
                        String pass =  u.getuPassword();
                        String s =  u.getuAddress();

                        String id1 = u.getId();
                        boolean dflg1 = false;
                        boolean dflg = false;
                        boolean flag1 = u.getFlg1();
                        boolean flag = u.getFlg();

                        DatabaseReference d = FirebaseDatabase.getInstance().getReference("user").child(id1);
                        userlogin ul = new userlogin(id1, username, pass, repass, uname, addr, phone, mail, adhar, flag1, flag, dflg, dflg1);
                        d.setValue(ul);
                        Toast.makeText(sendd.this, "updated", Toast.LENGTH_SHORT).show();
                    }


                }
            }





            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void delete(String id1, String mail, String uname)
    {
        DatabaseReference d = FirebaseDatabase.getInstance().getReference("Alive_People").child(id1);
        //AlivePeople ul = new AlivePeople(id1, mail,uname);
        d.removeValue();
        Toast.makeText(sendd.this,"delete",Toast.LENGTH_SHORT).show();

    }
    public void pdf()
    {
        try {
            createPDF();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    private void createPDF() throws FileNotFoundException,DocumentException {
        int hasWriteStoragePermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!shouldShowRequestPermissionRationale(Manifest.permission.WRITE_CONTACTS)) {
                    showMessage("You need to allow access to Storage", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_ASK_PERMISSIONS);
                            }
                        }
                    });
                    return;
                }

                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE_ASK_PERMISSIONS);
            }
            return;
        }
        else {
            File docsFolder = new File(Environment.getExternalStorageDirectory() + "/Documents");
            if (!docsFolder.exists()) {
                docsFolder.mkdir();
            }

            pdfFile = new File(docsFolder.getAbsolutePath(),"myPDF.pdf");
            OutputStream output = new FileOutputStream(pdfFile);
            Document document = new Document();
            PdfWriter.getInstance(document, output);
            document.open();
            document.add(new Paragraph(s));

            document.close();
            showPDF();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    try {
                        createPDF();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }
                } else {
                    // Permission Denied
                    Toast.makeText(this, "WRITE_EXTERNAL Permission Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    private void showPDF() {
        PackageManager packageManager = getPackageManager();
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        testIntent.setType("application/pdf");
        List list = packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY);
        if (list.size() > 0) {
            	           /* Intent intent = new Intent();
            	            intent.setAction(Intent.ACTION_VIEW);
            	            Uri uri = Uri.fromFile(pdfFile);
            	            intent.setDataAndType(uri, "application/pdf");

            	            startActivity(intent);*/
            Intent i=new Intent(Intent.ACTION_SEND);

            String s=m+","+"sanketdhake1209@gmail.com"+","+"shubhampatil7912@gmail.com";
            String[] recept=s.split(",");

            String sub="Death Certificate";
            String msg="You have recieved mail about Birth certificate";
            i.putExtra(Intent.EXTRA_EMAIL,recept);
            i.putExtra(Intent.EXTRA_SUBJECT,sub);
            i.putExtra(Intent.EXTRA_TEXT,msg);
            i.putExtra(Intent.EXTRA_CC,userBirth.momail);
            i.setType("msg/rfc822");
            startActivity(Intent.createChooser(i,"Choose any client"));

        }else{
            Toast.makeText(this,"Download a PDF Viewer to see the generated PDF",Toast.LENGTH_SHORT).show();
        }
    }

    private void showMessage(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


}
