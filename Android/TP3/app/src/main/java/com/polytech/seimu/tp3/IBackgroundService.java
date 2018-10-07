package com.polytech.seimu.tp3;


public interface IBackgroundService {
    public void addListener(IBackgroundServiceListener listener);
    public void removeListener(IBackgroundServiceListener listener);
}
