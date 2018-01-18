package com.example.vinothvsbe.audiodemo;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    float volumeLvl=5;
    AudioManager am;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp=MediaPlayer.create(this,R.raw.vedalamtheme);
        //Declaring SeekBar for Volume control.
        //But we need Audio Manager to control Android system Volume Control
        SeekBar volumeControl=(SeekBar) findViewById(R.id.seekBar);
        //Getting Audio Service assigned to Audio Manager
        am=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxVolume=am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume=am.getStreamVolume(AudioManager.STREAM_MUSIC);

        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(curVolume);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //SeekBar for Audio play control. This is to drag current audio played time. so that we can drag across any part of Audio.

        final SeekBar timeControl = (SeekBar)findViewById(R.id.dragBar);
        final int maxValue= mp.getDuration();
        Log.i("Info", "Result : "+ maxValue);
        timeControl.setMax(maxValue);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeControl.setProgress(mp.getCurrentPosition());
            }
        },0,100);



        timeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mp.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void Start(View view)
    {
        mp.start();
    }

    public void Pause(View view)
    {
        mp.pause();

    }

    public void Up(View view)
    {
        volumeLvl+=5;
        mp.setVolume(volumeLvl,volumeLvl);

    }
    public void Down(View view)
    {
        volumeLvl-=5;
        mp.setVolume(volumeLvl,volumeLvl);

    }
    public void Stop(View view)
    {
        mp.stop();

    }
}
