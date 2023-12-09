package interfaces;

import models.Furnace;
import models.Ingredient;

public interface Burnable {
    Ingredient onBurn(Furnace furnace);
}
