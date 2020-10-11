package id.ac.ui.cs.mobileProgramming.helloworld.viewmodels;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.ac.ui.cs.mobileProgramming.helloworld.models.Pokemon;

public class PokemonListViewModel extends ViewModel {
    public List<Pokemon> pokemons;

    public PokemonListViewModel() {
        pokemons = new ArrayList<>(
                Arrays.asList(new Pokemon("1", "Mudkip", new String[]{"water"}, 7.6f, 0.4f),
                        new Pokemon("2", "Charmander", new String[]{"fire"}, 8.5f, 0.6f),
                        new Pokemon("3", "Pikachu", new String[]{"electric"}, 6.0f, 0.4f),
                        new Pokemon("4", "Zubat", new String[]{"poison", "fly"}, 7.5f, 0.8f),
                        new Pokemon("5", "Poliwag", new String[]{"water"}, 12.4f, 0.6f)));
    }

    public Pokemon findPokemonById(String id) {
        Pokemon pokemonItem = null;
        for (Pokemon pokemon:
             pokemons) {
            if (pokemon.id.equals(id)) pokemonItem = pokemon;
        }
        return pokemonItem;
    }
}
