package id.ac.ui.cs.mobileProgramming.helloworld.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PokemonContent {
    public static final List<PokemonItem> ITEMS = new ArrayList<>();
    public static final Map<String, PokemonItem> ITEM_MAP = new HashMap<String, PokemonItem>();

    static {
        addItem(new PokemonItem("1","Mudkip", new String[]{"water"}, 7.6f, 0.4f));
        addItem(new PokemonItem("2","Charmander", new String[]{"fire"}, 8.5f, 0.6f));
    }

    private static void addItem(PokemonItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }

    public static class PokemonItem {
        public String id;
        public String name;
        public String[] types;
        public float weight;
        public float height;

        public PokemonItem(String id, String name, String[] types, float weight, float height) {
            this.id = id;
            this.name = name;
            this.types = types;
            this.weight = weight;
            this.height = height;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}