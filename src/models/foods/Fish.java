package models.foods;

import models.Burnable;
import models.Furnace;
import models.Ingredient;

public class Fish extends Ingredient implements Burnable {
    public Fish() {
        super("Fish");
    }

    @Override
    public Ingredient onBurn(Furnace furnace) {
        return new RoastedFish();
    }
}
