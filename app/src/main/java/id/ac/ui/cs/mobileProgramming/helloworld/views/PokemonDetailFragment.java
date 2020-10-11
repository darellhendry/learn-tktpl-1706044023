package id.ac.ui.cs.mobileProgramming.helloworld.views;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.ac.ui.cs.mobileProgramming.helloworld.R;
import id.ac.ui.cs.mobileProgramming.helloworld.viewmodels.PokemonDetailViewModel;
import id.ac.ui.cs.mobileProgramming.helloworld.viewmodels.PokemonListViewModel;

public class PokemonDetailFragment extends Fragment {
    private final String TAG = "PokemonDetailFragment";
    private PokemonDetailViewModel mViewModel;
    private static String id;
    private static PokemonListViewModel listViewModel;
    View view;

    public PokemonDetailFragment(String id, PokemonListViewModel listViewModel) {
        if (id != null) {
            PokemonDetailFragment.id = id;
            PokemonDetailFragment.listViewModel = listViewModel;
        } else {
            PokemonDetailFragment.id = "1";
        }
    }
    public PokemonDetailFragment() {
    }

    public static PokemonDetailFragment newInstance() {
        return new PokemonDetailFragment(PokemonDetailFragment.id, PokemonDetailFragment.listViewModel);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PokemonDetailViewModel.class);
        mViewModel.setPokemonItem(id, listViewModel);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pokemon_detail_fragment, container, false);
        ((TextView)view.findViewById(R.id.pokemon_name)).setText(mViewModel.pokemon.name);

        String sTypes = TextUtils.join(",", mViewModel.pokemon.types);
        ((TextView)view.findViewById(R.id.types)).setText(sTypes);
        return view;
    }



}