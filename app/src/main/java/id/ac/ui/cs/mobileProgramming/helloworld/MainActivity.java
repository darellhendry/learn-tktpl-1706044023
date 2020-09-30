package id.ac.ui.cs.mobileProgramming.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG= "mainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * ref: https://stackoverflow.com/questions/3141996/android-how-to-override-the-back-button-so-it-doesnt-finish-my-activity
     * */
    public void onClickExit(View view) {
        Intent setIntent = new Intent(Intent.ACTION_MAIN);
        setIntent.addCategory(Intent.CATEGORY_HOME);
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(setIntent);
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
}