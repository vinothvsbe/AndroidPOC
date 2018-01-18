package com.example.vinothvsbe.downloadingwebcontent;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public class DownloadTask extends AsyncTask<String,Void,String>{
        protected String doInBackground(String... urls){
            String result="";
            Log.i("URL : ",urls[0]);
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(urls[0]);
                urlConnection=(HttpURLConnection)url.openConnection();
                InputStream is = urlConnection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                int data = isr.read();
                while(data!=-1)
                {
                    char current = (char)data;
                    result +=current;
                    data = isr.read();
                }
                isr.close();


            } catch (Exception e) {
                e.printStackTrace();
            }

            return result;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask dd=new DownloadTask();

        String result = null;

        try {
            result = dd.execute("https://www.ecowebhosting.co.uk/").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Log.i("Info", result);



    }
}
