package models.foods;

import models.Furnace;
import models.Ingredient;
import models.Burnable;

public class Fish extends Ingredient implements Burnable {
    public Fish() {
        super("Fish");
    }

    @Override
    public Ingredient onBurn(Furnace furnace) {
        return new RoastedFish();
    }
}
