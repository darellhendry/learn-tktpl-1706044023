package id.ac.ui.cs.mobileProgramming.helloworld.views.adapters;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.ac.ui.cs.mobileProgramming.helloworld.R;
import id.ac.ui.cs.mobileProgramming.helloworld.models.Pokemon;
import id.ac.ui.cs.mobileProgramming.helloworld.viewmodels.PokemonListViewModel;
import id.ac.ui.cs.mobileProgramming.helloworld.views.PokemonListFragment;
import id.ac.ui.cs.mobileProgramming.helloworld.views.PokemonDetailFragment;

import java.util.List;

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.ViewHolder> {

    private PokemonListViewModel vModel;
    private final PokemonListFragment fragment;

    public PokemonListAdapter(PokemonListFragment fragment, List<Pokemon> items, PokemonListViewModel viewModel) {
        this.fragment = fragment;
        this.vModel = viewModel;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        final ViewHolder vHolder = new ViewHolder(view);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = vModel.pokemons.get(position);
        holder.mIdView.setText(vModel.pokemons.get(position).id);
        holder.mContentView.setText(vModel.pokemons.get(position).name);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = fragment.getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new PokemonDetailFragment(holder.mItem.id, vModel))
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return vModel.pokemons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Pokemon mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}