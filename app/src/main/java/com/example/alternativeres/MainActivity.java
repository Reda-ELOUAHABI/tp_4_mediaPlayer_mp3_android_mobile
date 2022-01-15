package com.example.alternativeres;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("LIFECYCLE ",getLocalClassName() + ": ici onCreate");

        Button startButton = (Button) findViewById(R.id.start);
        Button stopButton = (Button) findViewById(R.id.stop);
        Button Button = (Button) findViewById(R.id.list);
        Button exitButton = (Button) findViewById(R.id.exit);
//        System.out.println("SALAAAAAAAAAAM Start DIALOG \n\n\n\n\n\n\n");
//        System.out.println(startDialog.getText());
//        System.out.println("SALAAAAAAAAAAM Start DIALOG \n\n\n\n\n\n\n");
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("SALAAAAAAAAAAM Start DIALOG \n\n\n\n\n\n\n");
                Toast.makeText(MainActivity.this,"finished ..",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, ServiceMusique.class);
                intent.putExtra("name","song1");
                startService(intent);
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, ServiceMusique.class);
                intent.putExtra("name","song1");
                stopService(intent);
            }
        });
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, MyPlayList.class);
                startActivity(intent);
            }
        });


/*
Lorsque on Sort de l'application(1), et puis on return(2):
(1)
I/LIFECYCLE: MainActivity: ici onStart
I/LIFECYCLE: MainActivity: ici onStopw
(2)
I/LIFECYCLE: MainActivity: ici onRestart
I/LIFECYCLE: MainActivity: ici onStart
I/LIFECYCLE: MainActivity: ici onResume*/
        /*si on fait finish():
        * I/LIFECYCLE: MainActivity: ici onStart
        I/LIFECYCLE: MainActivity: ici onyStop
        I/LIFECYCLE: MainActivity: ici onDestroy
        * et si on l'ouvre :
        * /LIFECYCLE: MainActivity: ici onStart
        I/LIFECYCLE: MainActivity: ici onResume
        * */

    }



    @Override
    protected void onStart() {
        super.onStart();
//        NOM ACTIVITY + Methode EXECUTEE
        Log.i("LIFECYCLE ",getLocalClassName() + ": ici onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LIFECYCLE ",getLocalClassName() + ": ici onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LIFECYCLE ",getLocalClassName() + ": ici onStart");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LIFECYCLE ",getLocalClassName() + ": ici onyStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LIFECYCLE ",getLocalClassName() + ": ici onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LIFECYCLE ",getLocalClassName() + ": ici onRestart");
    }
}