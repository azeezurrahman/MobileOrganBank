package com.example.anand.mobileorganbank;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;

public class listing2 extends AppCompatActivity {

    SQLiteDatabase db;

    String nam = null;
    String mob = null;
    String mo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ListView lv = (ListView) findViewById(R.id.listView);
        try {
            ArrayList<String> a = new ArrayList();
            db = openOrCreateDatabase("MOB", MODE_PRIVATE, null);
            Cursor r = db.rawQuery("select * from DONREGISTERS where ORGAN = 'Kidney'", null);
            if (r.moveToFirst()) {
                a.clear();
                int idx = r.getColumnIndex("ORGAN");
                int idy = r.getColumnIndex("NAME");
                int idz = r.getColumnIndex("MOBILE");
                do {
                    String s = r.getString(idy);//+"\n"+r.getString(idz)+"\n"+r.getString(idx);
                    a.add(s);
                }
                while (r.moveToNext());
            }

            Intent rec = getIntent();
             nam = rec.getStringExtra("nam");
             mob = rec.getStringExtra("mob");

            ArrayAdapter<String> arrayAdapter = null;
            arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, a);
            lv.setAdapter(arrayAdapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    final String na = parent.getItemAtPosition(position).toString();
                    Toast.makeText(getBaseContext(), na, Toast.LENGTH_LONG).show();
                    AlertDialog.Builder b = new AlertDialog.Builder(listing2.this);
                    b.setTitle("Confirmation");
                    b.setMessage("Are you sure you want to select?");
                    b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Cursor r2 = db.rawQuery("select * from DONREGISTERS where NAME = '"+na+"'", null);
                            if (r2.moveToFirst()) {
                                int idxm = r2.getColumnIndex("MOBILE");
                                mo = r2.getString(idxm);
                            }

                            db.delete("DONREGISTERS", "NAME = '" + na + "'", null);
                            try {
                                SmsManager smsManager = SmsManager.getDefault();
                                smsManager.sendTextMessage(mo, null, "Mr "+nam+" is interested in your Donation(Kidney) \nPlease Contact his no. "+mob+" for further details\nThank You!", null, null);
                                smsManager.sendTextMessage(mob, null, "Dear "+nam+"\nWe have contacted Mr "+na+"\nPlease wait for their response\nThank You!", null, null);
                                
                                Toast.makeText(getApplicationContext(), mob,Toast.LENGTH_LONG).show();
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                                Toast.makeText(getApplicationContext(),"Some Error",Toast.LENGTH_LONG).show();
                            }
                            Intent m = new Intent(getApplicationContext(), listing2.class);
                            startActivity(m);

                        }
                    });

                    AlertDialog alertDialog = b.create();
                    alertDialog.show();

                }
            });
            // db.delete("DONREGISTERS", null, null);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
        }



        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);

        ImageView itemIcon = new ImageView(this);
        itemIcon.setImageResource(R.mipmap.logo);
        ImageView itemIcon2 = new ImageView(this);
        itemIcon2.setImageResource(R.mipmap.ic_r);
        ImageView itemIcon3 = new ImageView(this);
        itemIcon3.setImageResource(R.mipmap.ic_d);

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        SubActionButton.Builder itemBuilder2 = new SubActionButton.Builder(this);
        SubActionButton.Builder itemBuilder3 = new SubActionButton.Builder(this);

        SubActionButton home = itemBuilder.setContentView(itemIcon).build();
        SubActionButton rec = itemBuilder2.setContentView(itemIcon2).build();
        SubActionButton don = itemBuilder3.setContentView(itemIcon3).build();

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(home)
                .addSubActionView(rec)
                .addSubActionView(don)
                .attachTo(fab)
                .build();
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(h);
            }
        });

        rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h = new Intent(getApplicationContext(),recipient.class);
                startActivity(h);
            }
        });

        don.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h = new Intent(getApplicationContext(),donor.class);
                startActivity(h);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.organs, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.heart:
                Intent m1 = new Intent(getApplicationContext(), listing.class);
                m1.putExtra("nam", nam);
                m1.putExtra("mob", mob);
                startActivity(m1);
                break;

            case R.id.kidney:

                Intent m2 = new Intent(getApplicationContext(), listing2.class);
                m2.putExtra("nam",nam);
                m2.putExtra("mob",mob);
                startActivity(m2);
                break;

            case R.id.eyes:
                Intent m3 = new Intent(getApplicationContext(), listing3.class);
                m3.putExtra("nam",nam);
                m3.putExtra("mob",mob);
                startActivity(m3);

                break;

        }


        return super.onOptionsItemSelected(item);
    }
}
