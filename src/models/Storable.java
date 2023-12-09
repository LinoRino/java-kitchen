package models;

import java.util.ArrayList;

public interface Storable {
    ArrayList<Ingredient> inventory = new ArrayList<>();
    Ingredient drop();
    void put(Ingredient ingredient);
}
