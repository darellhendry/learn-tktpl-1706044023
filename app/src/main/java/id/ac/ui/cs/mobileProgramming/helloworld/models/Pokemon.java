package id.ac.ui.cs.mobileProgramming.helloworld.models;

public class Pokemon {
    public String id;
    public String name;
    public String[] types;
    public float weight;
    public float height;

    public Pokemon(String id, String name, String[] types, float weight, float height) {
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