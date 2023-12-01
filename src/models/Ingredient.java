package models;

public abstract class Ingredient implements Cloneable {
    private final String name;
    private int energy;
    private int extraEnergy;

    public Ingredient(String name, int energy, int extraEnergy) {
        this.name = name;
        this.energy = energy;
        this.extraEnergy = extraEnergy;
    }

    public String getName() {
        return this.name;
    }

    public int getEnergy() {
        return this.energy;
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
