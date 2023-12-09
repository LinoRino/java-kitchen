package main;

import models.CookingTask;
import models.Furnace;
import models.Notification;
import models.Player;
import models.foods.Fish;
import models.foods.RoastedFish;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player("Steve");
        Notification.progress("Fishing...");
        for (int i = 0; i < 10; i++) {
            Fish fish = player.fish();
            if (fish != null) {
                player.put(fish);
            }
        }
        Notification.success(String.format("%s got %d fish.", player.name, player.count(new Fish())));
        Notification.progress("Cooking...");
        CookingTask[] cookingTasks = new CookingTask[player.getInventory().size()];
        for (int i = 0; i < cookingTasks.length; i++) {
            cookingTasks[i] = new CookingTask(new Furnace(player.drop()), player);
            cookingTasks[i].start();
        }

        Notification.progress("Waiting for cooking tasks to finish");
        TimeUnit.SECONDS.sleep(1);
        for (CookingTask cookingTask : cookingTasks) {
            cookingTask.join();
        }

        Notification.success("Done!");
        Notification.notify(String.format("%s's inventory:", player.name));
        for (int i = 0; i < player.getInventory().size(); i++) {
            System.out.printf("%d. %s\n", i + 1, player.getInventory().get(i).getName());
        }
    }
}