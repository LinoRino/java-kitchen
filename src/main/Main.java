package main;

import models.Player;
import models.foods.Fish;

public class Main {
    public static void main(String[] args) {
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
    }
}