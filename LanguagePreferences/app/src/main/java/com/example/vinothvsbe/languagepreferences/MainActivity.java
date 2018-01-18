package com.example.vinothvsbe.languagepreferences;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    SharedPreferences sharedPreferences;
    TextView tv;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);


        switch (item.getItemId()) {
            case R.id.english:
                sharedPreferences.edit().putString("language", "English").apply();
                break;
            case R.id.spanish:
                sharedPreferences.edit().putString("language", "Spanish").apply();
                break;
            case R.id.tamil:
                sharedPreferences.edit().putString("language", "Tamil").apply();
                break;
            case R.id.german:
                sharedPreferences.edit().putString("language", "German").apply();
                break;
            case R.id.french:
                sharedPreferences.edit().putString("language", "French").apply();
                break;
            default:
                break;
        }

        tv.setText(sharedPreferences.getString("language", ""));
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences=this.getSharedPreferences("com.example.vinothvsbe.languagepreferences", Context.MODE_PRIVATE);
        tv=(TextView)findViewById(R.id.txtLanguage);
        tv.setText(sharedPreferences.getString("language", ""));

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_btn_speak_now)
                .setTitle("Language Preference")
                .setMessage("Please select one of the language below")
                .setNeutralButton("Ënglish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sharedPreferences.edit().putString("language","English").apply();
                        tv.setText(sharedPreferences.getString("language", ""));
                    }
                })
                .setNeutralButton("Spanish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sharedPreferences.edit().putString("language","Spanish").apply();
                        tv.setText(sharedPreferences.getString("language", ""));
                    }
                })
                .setNeutralButton("Tamil", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sharedPreferences.edit().putString("language","Tamil").apply();
                        tv.setText(sharedPreferences.getString("language", ""));
                    }
                })
                .setNeutralButton("German", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sharedPreferences.edit().putString("language","German").apply();
                        tv.setText(sharedPreferences.getString("language", ""));
                    }
                })
                .setNeutralButton("French", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sharedPreferences.edit().putString("language","French").apply();
                        tv.setText(sharedPreferences.getString("language", ""));
                    }
                }).show();


    }
}
