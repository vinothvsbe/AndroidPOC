package com.example.vinothvsbe.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.Timer
//        final Handler handler=new Handler();
//
//        Runnable run=new Runnable() {
//            @Override
//            public void run() {
//                Log.i("Runnable has run","Second has passed");
//                handler.postDelayed(this, 1000);
//            }
//        };
//        handler.post(run);

        //2.CountDown Timer

        CountDownTimer cdt=new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long l) {
                Log.i("Info:", Long.toString(l/1000));
            }

            @Override
            public void onFinish() {

            }
        };
        cdt.start();
    }
}
