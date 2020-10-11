package id.ac.ui.cs.mobileProgramming.helloworld.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import id.ac.ui.cs.mobileProgramming.helloworld.R;

public class MainActivity extends AppCompatActivity {
    PokemonDetailFragment pokemonDetailFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            this.getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new PokemonListFragment())
                    .commit();
        }
    }
}