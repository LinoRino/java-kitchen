package main;

import models.*;
import models.tasks.CookingTask;
import models.tasks.FishingTask;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Player steve = new Player("Steve");
        Player alex = new Player("Alex");
        Chest chest = new Chest();
        Notification.progress("Fishing...");
        FishingTask[] fishingTasks = new FishingTask[2];
        for (int i = 0; i < fishingTasks.length; i++) {
            fishingTasks[i] = new FishingTask(chest, i % 2 == 0 ? steve : alex);
            fishingTasks[i].start();
        }
        Notification.progress("Waiting for cooking tasks to finish");
        TimeUnit.SECONDS.sleep(1);
        for (FishingTask fishingTask : fishingTasks) {
            fishingTask.join();
        }

        Notification.success("The chest is full!");
        Notification.progress("Cooking...");
        // Chestの中身をすべてかまどに入れる
        // 並列処理できるように、かまどをたくさん用意する
        // かまどはたくさん用意できないので、Chestの中身の半分の数のかまどを用意する
        Furnace[] furnaces = new Furnace[chest.size() / 2];
        for (int i = 0; i < furnaces.length; i++) {
            furnaces[i] = new Furnace();
        }
        CookingTask[] cookingTasks = new CookingTask[chest.size()];
        for (int i = 0; i < cookingTasks.length; i++) {
            cookingTasks[i] = new CookingTask(furnaces[i % furnaces.length], chest);
            cookingTasks[i].start();
        }

        Notification.progress("Waiting for cooking tasks to finish");
        TimeUnit.SECONDS.sleep(1);
        for (CookingTask cookingTask : cookingTasks) {
            cookingTask.join();
        }

        Notification.success("Done!");
    }
}