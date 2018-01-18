package com.example.vinothvsbe.downloadimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  https://static.comicvine.com/uploads/scale_small/7/73532/1337930-heath_ledger_joker_dark_knight.jpg
        imgView = (ImageView) findViewById(R.id.imageView);
    }


    public void DownloadImage(View view) {
        Log.i("Info:", "Button Tapped!");
        Download dl = new Download();
        try {
            Bitmap bitmap = dl.execute("https://static.comicvine.com/uploads/scale_small/7/73532/1337930-heath_ledger_joker_dark_knight.jpg").get();
            imgView.setImageBitmap(bitmap);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public class Download extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urls) {
            URL url;
            HttpURLConnection httpURLConnection;

            try {
                url = new URL(urls[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();

                InputStream in = httpURLConnection.getInputStream();
                Bitmap bmp = BitmapFactory.decodeStream(in);

                httpURLConnection.disconnect();
                return bmp;

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return null;
        }
    }
}
