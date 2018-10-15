package com.polytech.seimu.tp6;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


class CallWebAPI extends AsyncTask<String, String, String> {
    private TextView mTextView;

    public CallWebAPI(TextView mTextView){
        this.mTextView = mTextView;
    }

    @Override
    protected String doInBackground(String... params) {
        String inputLine = "";
        StringBuilder result=null;
        URL url;

        try {
//            url = new URL("http://www.google.com");
            url = new URL(params[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            result = new StringBuilder();
            String line;

            while((line = reader.readLine()) != null) {
                result.append(line);
            }

            in.close();

            return result.toString();
        }
        catch (Exception e) {
            return String.valueOf(e);
        }
    }

    protected void onPostExecute(String result) {
        mTextView.setText(result);
    }
}
