package com.polytech.seimu.tp3;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Intent intent;
    IBackgroundServiceListener listener;
    ServiceConnection connection;
    IBackgroundService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcom_text = findViewById(R.id.welcom_text);
        Button button_start = findViewById(R.id.button_start);
        Button button_connexion = findViewById(R.id.button_connexion);
        Button button_deconnexion = findViewById(R.id.button_deconnexion);
        Button button_stop = findViewById(R.id.button_stop);
        EditText editText_main = findViewById(R.id.editText_main);

        button_start.setOnClickListener(listener_start);
        button_connexion.setOnClickListener(listener_connexion);
        button_deconnexion.setOnClickListener(listener_deconnexion);
        button_stop.setOnClickListener(listener_stop);
    }

    View.OnClickListener listener_start = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, BackgroundService.class);
            startService(intent);
        }
    };

    View.OnClickListener listener_connexion = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            intent = new Intent(MainActivity.this, BackgroundService.class);

            listener = new IBackgroundServiceListener() {
                public void dataChanged(final Object data) {
                    MainActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            TextView welcome_text = findViewById(R.id.welcom_text);
                            welcome_text.setText(data.toString());
                        }
                    });
                }
            };

            connection = new ServiceConnection() {
                public void onServiceConnected(ComponentName name, IBinder service) {
                    Log.i("BackgroundService", "Connected!");
                    myService = ((BackgroundServiceBinder) service).getService();
                    myService.addListener(listener);
                }

                public void onServiceDisconnected(ComponentName name) {
                    Log.i("BackgroundService", "Disconnected!");
                }
            };

            bindService(intent, connection, Context.BIND_AUTO_CREATE);
        }
    };

    View.OnClickListener listener_deconnexion = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            unbindService(connection);
            myService.removeListener(listener);
        }
    };

    View.OnClickListener listener_stop = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, BackgroundService.class);
            stopService(intent);
        }
    };
}
