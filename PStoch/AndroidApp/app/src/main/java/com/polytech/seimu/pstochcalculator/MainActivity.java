package com.polytech.seimu.pstochcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Prepare listeners.
        final EditText input_lambda = findViewById(R.id.input_lambda);
        final EditText input_mu = findViewById(R.id.input_mu);
        final EditText input_nb_server = findViewById(R.id.input_nb_server);
        final EditText input_max_clients = findViewById(R.id.input_max_clients);
        final RadioGroup radio_group_clients = findViewById(R.id.radio_group_clients);
        final RadioButton input_radio_infinite = findViewById(R.id.input_radio_infinite);

        input_max_clients.setEnabled(false);
        input_nb_server.setEnabled(true);

        // Lambda.
        input_lambda.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkLambdaAndMu();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Mu.
        input_mu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkLambdaAndMu();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Number of servers.
        input_nb_server.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!String.valueOf(input_nb_server.getText()).equals("") && Integer.valueOf(String.valueOf(input_nb_server.getText())) == 0) {
                    input_nb_server.setText("");
                    input_nb_server.setSelection(input_nb_server.getText().length());
                }

                calculateAndPrintResults();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Clients max.
        input_max_clients.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!String.valueOf(input_max_clients.getText()).equals("") && Integer.valueOf(String.valueOf(input_max_clients.getText())) == 0) {
                    input_max_clients.setText("");
                    input_max_clients.setSelection(input_max_clients.getText().length());
                }

                calculateAndPrintResults();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Radio group for the number max of clients.
        radio_group_clients.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO : call the checker.
                if(input_radio_infinite.isChecked()) {
                    // MM1 or MMS.
                    input_nb_server.setEnabled(true);

                    input_max_clients.setEnabled(false);
                    input_max_clients.setText("");
                }
                else {
                    // MM1K.
                    input_nb_server.setText("1");
                    input_nb_server.setEnabled(false);

                    input_max_clients.setEnabled(true);
                }
            }
        });
    }

    protected void calculateAndPrintResults() {
        // Prepare results.
        final TextView label_result_L = findViewById(R.id.label_result_L);
        final TextView label_result_Lq = findViewById(R.id.label_result_Lq);
        final TextView label_result_W = findViewById(R.id.label_result_W);
        final TextView label_result_Wq = findViewById(R.id.label_result_Wq);

        // Prepare listeners.
        final EditText input_lambda = findViewById(R.id.input_lambda);
        final EditText input_mu = findViewById(R.id.input_mu);
        final EditText input_nb_server = findViewById(R.id.input_nb_server);
        final EditText input_max_clients = findViewById(R.id.input_max_clients);
        final RadioGroup radio_group_clients = findViewById(R.id.radio_group_clients);
        final RadioButton input_radio_finite = findViewById(R.id.input_radio_finite);
        final RadioButton input_radio_infinite = findViewById(R.id.input_radio_infinite);

        // TODO : calculate result and print it.
//        if(String.valueOf(input_lambda.getText()).equals(""))
//            label_result_L.setText(input_lambda.getHint());
    }

    protected void checkLambdaAndMu() {
        final TextView label_error = findViewById(R.id.label_error);
        final EditText input_lambda = findViewById(R.id.input_lambda);
        final EditText input_mu = findViewById(R.id.input_mu);
        String lambdaStr, muStr;
        double lambda, mu;

        lambdaStr = input_lambda.getText().toString();
        muStr = input_mu.getText().toString();

        if(lambdaStr.equals("")) {
            lambda = 0;
        }
        else {
            if(lambdaStr.charAt(0) == '.')
                lambdaStr = '0' + lambdaStr;

            if(lambdaStr.charAt(lambdaStr.length() - 1) == '.')
                lambdaStr += '0';

            lambda = Double.parseDouble(lambdaStr);
        }

        if(muStr.equals("")) {
            mu = 0;
        }
        else {
            if(muStr.charAt(0) == '.')
                muStr = '0' + muStr;

            if(muStr.charAt(muStr.length() - 1) == '.')
                muStr += '0';

            mu = Double.parseDouble(muStr);
        }

        if(lambda/mu >= 1)
            label_error.setText(R.string.blocking_error);
        else {
            label_error.setText("");
            calculateAndPrintResults();
        }
    }
}
