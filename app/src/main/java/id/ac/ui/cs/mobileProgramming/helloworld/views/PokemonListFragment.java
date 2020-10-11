package id.ac.ui.cs.mobileProgramming.helloworld.views;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.ui.cs.mobileProgramming.helloworld.R;
import id.ac.ui.cs.mobileProgramming.helloworld.viewmodels.PokemonListViewModel;
import id.ac.ui.cs.mobileProgramming.helloworld.views.adapters.PokemonListAdapter;

public class PokemonListFragment extends Fragment {
    private PokemonListViewModel vModel;
    public PokemonListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vModel = new ViewModelProvider(this).get(PokemonListViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new PokemonListAdapter(this, vModel.pokemons, vModel));

        }
        return view;
    }
}