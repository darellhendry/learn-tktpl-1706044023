package id.ac.ui.cs.mobileProgramming.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG= "mainActivity";
    private final String[] helloWorlds = {"Hello World!","Kumusta, Mundo!", "Halo Dunia!", "Hallo Wereld!", "Bonjour le monde!"};
    private int stateIndex = 0;
    private boolean running = true;
    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            stateIndex = savedInstanceState.getInt("stateIndex");
            running = savedInstanceState.getBoolean("running");
        }
        runHelloWorld();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("running", running);
        outState.putInt("stateIndex", stateIndex);
    }

    public void onClickExit(View view) {
        finish();
        System.exit(0);
    }

    public void onClickNext(View view) {
        Intent setIntent = new Intent(this, NextActivity.class);
        startActivity(setIntent);
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed");
        Toast toast = Toast.makeText(this, "to exit press exit button!", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickResume(View view) {
        running = true;
    }

    public void onClickPause(View view) {
        running = false;
    }

    private void runHelloWorld() {
        final TextView timeView = (TextView) findViewById(R.id.textView);

        handler.post(new Runnable() {
            @Override
            public void run() {
                // Moves the current Thread into the background
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                if (stateIndex == helloWorlds.length) stateIndex = 0;
                Log.d(TAG, helloWorlds[stateIndex]);
                timeView.setText(helloWorlds[stateIndex]);
                if (running) {
                    stateIndex++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}