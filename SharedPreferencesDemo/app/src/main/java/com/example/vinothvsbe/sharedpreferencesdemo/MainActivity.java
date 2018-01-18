package com.example.vinothvsbe.sharedpreferencesdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences=this.getSharedPreferences("com.example.vinothvsbe.sharedpreferencesdemo", Context.MODE_PRIVATE);
//        sharedPreferences.edit().putString("username","vinoth").apply();
//        Log.i("Info", sharedPreferences.getString("username",""));
        ArrayList<String> ar=new ArrayList<String>();
        ar.add("Vinoth");
        ar.add("Lavanya");
        ar.add("Suganthi");
        ar.add("Suresh");

        try {
            sharedPreferences.edit().putString("family", ObjectSerializer.serialize(ar)).apply();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ArrayList<String> arResult = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("family", ObjectSerializer.serialize(new ArrayList<String>())));

            Log.i("Result", arResult.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
