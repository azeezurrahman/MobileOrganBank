package com.example.anand.mobileorganbank;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView logo = (ImageView)findViewById(R.id.logo);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);

        logo.startAnimation(animation);

       final EditText name = (EditText)findViewById(R.id.user);
       final EditText mobi = (EditText)findViewById(R.id.mob);




        TextView si = (TextView)findViewById(R.id.signup);
        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.this.startActivity(new Intent(getApplicationContext(), register.class));
            }
        });
        TextView log = (TextView)findViewById(R.id.log);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam = name.getText().toString();
                String mobile = mobi.getText().toString();
                //String mobi1="";
                db = openOrCreateDatabase("MOB",MODE_PRIVATE,null);
                Cursor r = db.rawQuery("select MOBILE from DONREGISTERS where NAME='" + nam + "'",null);
                if(r.moveToFirst()) {
                    int ind = r.getColumnIndex("MOBILE");
                    String mobi1 = r.getString(ind);

                    if (mobi1.equals(mobile))
                    {
                        Intent i = new Intent(getApplicationContext(),profile.class);
                        i.putExtra("name",nam);
                        startActivity(i);
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Invalid Authentication",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"Invalid Authentication",Toast.LENGTH_LONG).show();
            }
        });
    }

}
