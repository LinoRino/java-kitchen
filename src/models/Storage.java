package models;

import java.util.ArrayList;

public abstract class Storage {
    protected ArrayList<Ingredient> inventory = new ArrayList<>();
    private final int MAX_CAPACITY;

    public Storage(int maxCapacity) {
        this.MAX_CAPACITY = maxCapacity;
    }

    public Ingredient drop() {
        if (inventory.isEmpty()) {
            throw new IllegalStateException("Inventory is empty");
        }
        return inventory.remove(0);
    }

    public void put(Ingredient ingredient) {
        if (ingredient == null) {
            throw new IllegalArgumentException("Ingredient cannot be null");
        }
        if (inventory.size() >= MAX_CAPACITY) {
            throw new IllegalStateException("Inventory is full");
        }
        inventory.add(ingredient);
    }
}
