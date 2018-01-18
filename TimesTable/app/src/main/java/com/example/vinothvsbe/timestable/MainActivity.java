package com.example.vinothvsbe.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> al;
    ArrayList<Integer> tempAl;
    ArrayAdapter<Integer> aa;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar sb=(SeekBar) findViewById(R.id.seekBar);
        al=new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);
        al.add(7);
        al.add(8);
        al.add(9);
        al.add(10);
        tempAl=new ArrayList<Integer>(al);
        aa=new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,al);
        lv=(ListView) findViewById(R.id.listView2);
        lv.setAdapter(aa);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                for(int j=0;j<al.size();j++)
                {
                    int val=al.get(j);
                    tempAl.set(j,val*i);
                    Log.i("Info:","["+i+"] ->Index ["+j+"]:"+tempAl.get(j).toString());
                }
                aa=new ArrayAdapter<Integer>(getBaseContext(),android.R.layout.simple_list_item_1,tempAl);
                lv.setAdapter(aa);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
