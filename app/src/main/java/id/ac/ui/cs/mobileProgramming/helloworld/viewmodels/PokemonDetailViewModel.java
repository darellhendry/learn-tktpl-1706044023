package id.ac.ui.cs.mobileProgramming.helloworld.viewmodels;

import androidx.lifecycle.ViewModel;

import id.ac.ui.cs.mobileProgramming.helloworld.models.Pokemon;

public class PokemonDetailViewModel extends ViewModel {
    public Pokemon pokemon;

    public void setPokemonItem(String id, PokemonListViewModel listViewModel) {
        this.pokemon = listViewModel.findPokemonById(id);
    }

    public PokemonDetailViewModel() {
    }
}