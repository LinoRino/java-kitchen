package models.foods;

import models.Eatable;
import models.Ingredient;
import models.Player;

public class RoastedFish extends Ingredient implements Eatable {
    public boolean isEaten() {
        return isEaten;
    }

    private boolean isEaten = false;

    public RoastedFish() {
        super("Roasted fish", 4, 3);
    }

    @Override
    public void eat(Player player) {
        if (this.isEaten) {
            throw new RuntimeException("This food is already eaten!");
        }
        this.isEaten = true;
    }
}
