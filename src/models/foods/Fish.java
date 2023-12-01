package models.foods;

import models.Furnace;
import models.Ingredient;
import models.Roastable;

public class Fish extends Ingredient implements Roastable {
    public Fish() {
        super("Fish", 2, 1);
    }

    @Override
    public Ingredient roast(Furnace furnace) {
        return new RoastedFish();
    }
}
