package com.example.anand.mobileorganbank;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class profile extends AppCompatActivity {


    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        final String name= i.getStringExtra("name");

        TextView n = (TextView)findViewById(R.id.name2);

        Animation fdin = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
        n.setText(name);

        n.startAnimation(fdin);

        TextView tv = (TextView)findViewById(R.id.clickhere);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent m = new Intent(getApplicationContext(),updation.class);
                m.putExtra("name",name);
                startActivity(m);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
