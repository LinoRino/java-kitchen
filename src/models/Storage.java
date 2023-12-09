package models;

import java.util.ArrayList;

public abstract class Storage {
    private final ArrayList<Ingredient> inventory = new ArrayList<>();
    private final int MAX_CAPACITY;

    public Storage(int maxCapacity) {
        this.MAX_CAPACITY = maxCapacity;
    }

    public Ingredient drop() {
        if (isEmpty()) {
            throw new IllegalStateException("Inventory is empty");
        }
        return inventory.remove(0);
    }

    public Ingredient getFirst() {
        return inventory.get(0);
    }

    public void put(Ingredient ingredient) {
        if (isFull()) {
            throw new IllegalStateException("Inventory is full");
        }
        inventory.add(ingredient);
    }

    public int size() {
        return inventory.size();
    }
    public boolean isEmpty() {
        return inventory.isEmpty();
    }

    public boolean isFull() {
        return size() == MAX_CAPACITY;
    }
}
