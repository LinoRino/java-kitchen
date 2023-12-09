package models;

import models.foods.Fish;

import java.util.ArrayList;
import java.util.Random;

public class Player implements Storable {
    public final String name;
    private final ArrayList<Ingredient> inventory = new ArrayList<>();
    public Player(String name) {
        this.name = name;
    }

    public ArrayList<Ingredient> getInventory() {
        return inventory;
    }
    public Ingredient drop() {
        if (this.inventory.isEmpty()) {
            throw new IllegalStateException("Inventory is empty");
        }
        return this.inventory.remove(this.inventory.size() - 1);
    }
   public int count(Ingredient ingredient) {
        if (ingredient == null) {
            throw new IllegalArgumentException("Ingredient cannot be null");
        }
        int count = 0;
        for (Ingredient i : this.inventory) {
            if (i.getName().equals(ingredient.getName())) {
                count++;
            }
        }
        return count;
    }
    public void put(Ingredient ingredient) {
        if (ingredient == null) {
            throw new IllegalArgumentException("Ingredient cannot be null");
        }
        if (this.inventory.size() >= 10) {
            throw new IllegalStateException("Inventory is full");
        }
        this.inventory.add(ingredient);
        Notification.notify(String.format("%s put %s into inventory.", this.name, ingredient.getName()));
    }
    public Fish fish() throws InterruptedException {
        Notification.progress(String.format("%s is fishing", this.name));
        Random random = new Random();
        int randomInt = random.nextInt(100);
        Thread.sleep(800);
        if (randomInt < 50) {
            Notification.fail(String.format("%s failed to fish.", this.name));
            return null;
        }
        Notification.success(String.format("%s successfully fished.", this.name));
        return new Fish();
    }
}
