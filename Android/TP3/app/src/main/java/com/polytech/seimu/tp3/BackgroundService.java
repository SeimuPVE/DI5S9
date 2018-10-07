package com.polytech.seimu.tp3;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class BackgroundService extends Service implements IBackgroundService {
    private Timer timer;
    private ArrayList<IBackgroundServiceListener> listeners = null;
    private BackgroundServiceBinder binder;

    @Override
    public void onCreate() {
        Log.d(getClass().getName(), "onCreate");
        super.onCreate();
        timer = new Timer();
        listeners = new ArrayList< IBackgroundServiceListener >();
        binder = new BackgroundServiceBinder(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(getClass().getName(), "onStartCommand");

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date();
                Log.d(getClass().getName(), dateFormat.format(date));
                fireDataChanged(dateFormat.format(date));
            }
        }, 0, 1000);

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d(getClass().getName(), "onDestroy");
        timer.cancel();
        listeners.clear();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void addListener(IBackgroundServiceListener listener) {
        if(listeners != null)
            listeners.add(listener);
    }

    @Override
    public void removeListener(IBackgroundServiceListener listener) {
        if(listeners != null)
            listeners.remove(listener);
    }

    private void fireDataChanged(Object data){
        if(listeners != null)
            for(IBackgroundServiceListener listener: listeners)
                listener.dataChanged(data);
    }
}
