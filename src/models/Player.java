package models;

import models.foods.Fish;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    public final String name;
    private final ArrayList<Ingredient> inventory = new ArrayList<>();
    public Player(String name) {
        this.name = name;
    }

    public ArrayList<Ingredient> getInventory() {
        return inventory;
    }

    public void eat(Eatable eatable) {
        eatable.eat(this);
        System.out.printf("%s ate %s\n", this.name, eatable.getClass().getSimpleName());
    }

    public void put(Ingredient ingredient) {
        if (ingredient == null) {
            throw new IllegalArgumentException("Ingredient cannot be null");
        }
        if (this.inventory.size() >= 10) {
            throw new IllegalStateException("Inventory is full");
        }
        this.inventory.add(ingredient);
        System.out.printf("%s put %s into inventory.\n", this.name, ingredient.getName());
    }
    public Fish fish() {
        System.out.printf("%s is fishing.\n", this.name);
        Random random = new Random();
        int randomInt = random.nextInt(100);
        if (randomInt < 50) {
            System.out.printf("%s failed to fish.\n", this.name);
            return null;
        }
        System.out.printf("%s successfully fished.\n", this.name);
        return new Fish();
    }
}
