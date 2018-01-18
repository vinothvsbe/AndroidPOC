package com.example.vinothvsbe.eggtimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CountDownTimer cdt;
    TextView tv;
    int durationSeconds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar sb=(SeekBar) findViewById(R.id.seekBar);
        tv=(TextView) findViewById(R.id.textView);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                durationSeconds = i*5;
                tv.setText(String.format("%02d:%02d:%02d", durationSeconds / 3600,
                        (durationSeconds % 3600) / 60, (durationSeconds % 60)));
                cdt = new CountDownTimer(5*i*1000,1000) {
                    @Override
                    public void onTick(long l) {
                        Log.i("Info",Long.toString(l/1000));
//                        durationSeconds=l/1000;
                        Log.i("Info",String.format("%02d:%02d:%02d", (l/1000) / 3600,
                                ((l/1000) % 3600) / 60, ((l/1000) % 60)));
                        tv.setText(String.format("%02d:%02d:%02d", (l/1000) / 3600,
                                ((l/1000) % 3600) / 60, ((l/1000) % 60)));

                    }

                    @Override
                    public void onFinish() {

                    }
                };


                Log.i("Info","["+i+"] -> ["+durationSeconds+"] -> "+String.format("%02d:%02d:%02d", durationSeconds / 3600,
                        (durationSeconds % 3600) / 60, (durationSeconds % 60)));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void OnActivate(View view)
    {
        cdt.start();
        Button btn=(Button) findViewById(R.id.btnActivate);
        if(btn.getText().toString().toLowerCase()=="start"){
            btn.setText("Pause");
        }
        else{
            btn.setText("Start");
        }




    }
}
