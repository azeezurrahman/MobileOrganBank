package com.example.anand.mobileorganbank;

import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button abtus = (Button)findViewById(R.id.abtus);

        abtus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "About us", Toast.LENGTH_LONG).show();
                Intent s = new Intent(getApplicationContext(),Video.class);
                startActivity(s);
            }
        });

        TextView ha = (TextView)findViewById(R.id.head);


        ImageView logo = (ImageView)findViewById(R.id.doc);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);

        logo.startAnimation(animation);

        Button donor = (Button)findViewById(R.id.donor);
        Button recipient = (Button)findViewById(R.id.recipient);

        donor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pg1 = new Intent(getApplicationContext(),donor.class);
                startActivity(pg1);
            }
        });

        recipient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pg2 = new Intent(getApplicationContext(),recipient.class);
                startActivity(pg2);
            }
        });

    }


}
