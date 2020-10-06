package id.ac.ui.cs.mobileProgramming.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG= "mainActivity";
    private final String[] helloWorlds = {"Hello World!","Kumusta, Mundo!", "Halo Dunia!", "Hallo Wereld!", "Bonjour le monde!"};
    private int stateIndex = 0;
    private int iteration = 0;
    private boolean running = true;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            stateIndex = savedInstanceState.getInt("stateIndex");
            iteration = savedInstanceState.getInt("iteration");
            running = savedInstanceState.getBoolean("running");
        }
        handler.post(runnable); // run thread
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("running", running);
        outState.putInt("stateIndex", stateIndex);
        outState.putInt("iteration", iteration);
    }
    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed");
        Toast toast = Toast.makeText(this, "to exit press exit button!", Toast.LENGTH_SHORT);
        toast.show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable); // remove thread
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (stateIndex == helloWorlds.length) stateIndex = 0;
            Log.d(TAG, helloWorlds[stateIndex]);
            updateUiView(helloWorlds[stateIndex]);
            if (running) {
                stateIndex++;
                iteration++;
            }
            handler.postDelayed(this, 1000);
        }
    };
    public void updateUiView(String text) {
        final TextView timeView = (TextView) findViewById(R.id.textView);
        final TextView iterationView = (TextView) findViewById(R.id.textView3);
        timeView.setText(helloWorlds[stateIndex]);
        iterationView.setText(String.format("Iteration: %s", String.valueOf(iteration)));
    }
    public void onClickExit(View view) {
        finish();
        System.exit(0);
    }
    public void onClickNext(View view) {
        Intent setIntent = new Intent(this, NextActivity.class);
        startActivity(setIntent);
    }
    public void onClickResume(View view) {
        running = true;
    }
    public void onClickPause(View view) {
        running = false;
    }
}