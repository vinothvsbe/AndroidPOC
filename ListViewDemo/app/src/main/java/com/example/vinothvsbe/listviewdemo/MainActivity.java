package com.example.vinothvsbe.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = (ListView) findViewById(R.id.lstView);
        ArrayList<String> al=new ArrayList<String>();
        al.add("Suresh");
        al.add("Sugantthi");
        al.add("Lavanya");
        al.add("Vinoth");

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al);

        myListView.setAdapter(aa);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//                TextView c = (TextView)adapterView.getAdapter().getItem(i);
                String nameChanged = ((TextView) view).getText().toString();


                Toast.makeText(getBaseContext(),"Hello "+nameChanged+"!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
