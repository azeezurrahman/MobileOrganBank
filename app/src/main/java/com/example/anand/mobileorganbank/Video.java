package com.example.anand.mobileorganbank;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button buttonPlayVideo2 = (Button)findViewById(R.id.start);

        getWindow().setFormat(PixelFormat.UNKNOWN);
//displays a video file
        VideoView mVideoView2 = (VideoView)findViewById(R.id.v1);
        String uriPath2 = "android.resource://com.example.anand.mobileorganbank/"+R.raw.video1;
        Uri uri2 = Uri.parse(uriPath2);
        mVideoView2.setVideoURI(uri2);
        mVideoView2.requestFocus();
        mVideoView2.start();
        buttonPlayVideo2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoView mVideoView2 = (VideoView) findViewById(R.id.v1);
// VideoView mVideoView = new VideoView(this);
                String uriPath = "android.resource://com.example.anand.mobileorganbank/" + R.raw.video1;
                Uri uri2 = Uri.parse(uriPath);
                mVideoView2.setVideoURI(uri2);
                mVideoView2.requestFocus();
                mVideoView2.start();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

      switch(item.getItemId())
      {
          case R.id.video2:
              Intent i = new Intent(this,donor.class);
              startActivity(i);
              break;

          case R.id.video1:
              Intent m = new Intent(getApplicationContext(),MainActivity.class);
              startActivity(m);
              break;
      }

        return super.onOptionsItemSelected(item);
    }

}
