package main;

import models.Furnace;
import models.Player;
import models.foods.Fish;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player("Steve");
        for (int i = 0; i < 10; i++) {
            Fish fish = player.fish();
            if (fish != null) {
                player.put(fish);
            }
        }
        System.out.printf("%s's inventory:\n", player.name);
        for (int i = 0; i < player.getInventory().size(); i++) {
            System.out.printf("%d. %s\n", i + 1, player.getInventory().get(i).getName());
        }
        Furnace furnace = new Furnace();
        furnace.put(player.getInventory().get(0));
        furnace.run();
        System.out.println(furnace.getIngredient());
        System.out.println(player.getInventory().get(0));
    }
}