package models;

public abstract class Ingredient implements Cloneable {
    private final String name;

    public Ingredient(String name) {
        this.name = name;
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
