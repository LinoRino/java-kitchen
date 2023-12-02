package models;

public abstract class Ingredient implements Cloneable {
    private final String name;
    private final int energy;

    public Ingredient(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

    public String getName() {
        return this.name;
    }


    @Override
    public Ingredient clone() {
        try {
            return (Ingredient) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
