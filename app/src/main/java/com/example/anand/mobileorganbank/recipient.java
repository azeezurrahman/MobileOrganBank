package com.example.anand.mobileorganbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class recipient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView imageView = (ImageView)findViewById(R.id.hand);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomout);
        imageView.startAnimation(animation);
      final EditText n = (EditText)findViewById(R.id.name3);
        final EditText m = (EditText)findViewById(R.id.mobile3);

        Button register = (Button)findViewById(R.id.av);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Registering", Toast.LENGTH_LONG).show();

                String name = n.getText().toString();
                String mobile = m.getText().toString();

                Intent i = new Intent(getApplicationContext(), listing.class);
                i.putExtra("nam",name);
                i.putExtra("mob",mobile);

                startActivity(i);
            }
        });
       /* Button login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Under Construction", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(),login.class);
                startActivity(i);
            }
        }); */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
