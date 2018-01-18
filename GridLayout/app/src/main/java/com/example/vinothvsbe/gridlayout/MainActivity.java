package com.example.vinothvsbe.gridlayout;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ButtonCall(View view)
    {
        final int id = view.getId();

        String ourId ="";
        ourId = view.getResources().getResourceEntryName(id);

        int resourceId = getResources().getIdentifier(ourId,"raw","com.example.vinothvsbe.gridlayout");

        MediaPlayer mp= MediaPlayer.create(this, resourceId);
        mp.start();


    }
}
