package com.polytech.seimu.tp6;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        final TextView textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                callGoogle(); // To use the ugly technique.
                CallWebAPI c = new CallWebAPI(textView);
                c.execute("http://www.google.com");
            }
        });
    }

    private void callGoogle() {
        URL url;
        HttpURLConnection urlConnection =null;

        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            TextView textView = findViewById(R.id.textView);
            url = new URL("http://www.google.com/");
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            readStream(in);
            urlConnection.disconnect();
        }
        catch (Exception e) {
            e.printStackTrace();
            urlConnection.disconnect();
        }
    }

    private void readStream(InputStream inputStream) {
        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        TextView textView = findViewById(R.id.textView);
        textView.setText(result);
    }
}
