package com.example.vinothvsbe.videodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView vw=(VideoView) findViewById(R.id.videoView);
        vw.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video1);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(vw);
        vw.setMediaController(mc);
        vw.start();
    }
}
