package com.example.anand.mobileorganbank;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class updation extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        final EditText name1 = (EditText)findViewById(R.id.name);
        final EditText mobile1 = (EditText)findViewById(R.id.mobile);
        final EditText email1 = (EditText)findViewById(R.id.email);
        final Spinner organ1 = (Spinner)findViewById(R.id.organ);


        db = openOrCreateDatabase("MOB", MODE_PRIVATE, null);
        //db.execSQL("CREATE TABLE IF NOT EXISTS DONREGISTERS(NAME VARCHAR,MOBILE VARCHAR,EMAIL VARCHAR,ORGAN VARCHAR)");
        Button submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Successfully Updated in the Database", Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), name1.getText().toString(), Toast.LENGTH_LONG).show();
                try {

                    Intent a =getIntent();
                    String nam = a.getStringExtra("name");
                    final String name = name1.getText().toString();
                    final String m = mobile1.getText().toString();
                    //final int mobile = Integer.parseInt(m);
                    final String email = email1.getText().toString();
                    final String organ = organ1.getSelectedItem().toString();
                    db.execSQL("update DONREGISTERS set name='" + name + "',mobile='" + m + "' ,email = '"+ email +"',organ = '"+ organ +"' where name='" + nam + "'");

                    updation.this.startActivity(new Intent(getApplicationContext(),MainActivity.class));
                } catch (Exception e) {

                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Some Error!!", Toast.LENGTH_LONG).show();
                }
            }
        });

                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }

        }
