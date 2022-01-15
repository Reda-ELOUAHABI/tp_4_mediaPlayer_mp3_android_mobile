package com.example.alternativeres;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class ServiceMusique extends Service {
    private MediaPlayer newMediaPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "ServiceCréé",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        newMediaPlayer.stop();
        Toast.makeText(this, "Servicedétruit",Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String music_name=intent.getStringExtra("name");
        newMediaPlayer = MediaPlayer.create(this,getResources().getIdentifier(music_name,"raw",getPackageName()));

        Toast.makeText(this, "Service démmaré", Toast.LENGTH_LONG).show();
        newMediaPlayer.start();
        return startId;
//        return START_STICKY;
    }

}


