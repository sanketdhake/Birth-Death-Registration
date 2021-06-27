package com.example.bdregistration;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;


import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


public class sendb extends AppCompatActivity {

    Button b1;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 111;
    private File pdfFile;
    String s, m, n;
    DatabaseReference db = FirebaseDatabase.getInstance().getReference();

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
                Toast.makeText(sendb.this,m,Toast.LENGTH_SHORT).show();
                Toast.makeText(sendb.this,n,Toast.LENGTH_SHORT).show();
                String aid=db.push().getKey();
                AlivePeople a=new AlivePeople(aid,m,n);
                db.child("Alive_People").child(aid).setValue(a);

                pdf();

            }
        });
    }
    public void pdf()
    {
        try {
            createPDF();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void createPDF() throws FileNotFoundException,Exception {
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
           // File docsFolder = new File(Environment.getStorageDirectory() + "/Documents");
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
                    } catch (Exception e) {
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

            Intent i=new Intent(Intent.ACTION_SEND);
            String[] recept={m,""};

            String sub="Birth Certificate";
            String msg="You have recieved mail about Birth certificate";
            i.putExtra(Intent.EXTRA_EMAIL,recept);
            i.putExtra(Intent.EXTRA_SUBJECT,sub);
            i.putExtra(Intent.EXTRA_TEXT,msg);
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

