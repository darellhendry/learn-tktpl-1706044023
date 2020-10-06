package id.ac.ui.cs.mobileProgramming.helloworld.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import id.ac.ui.cs.mobileProgramming.helloworld.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new ItemFragment())
                .commit();
    }

}