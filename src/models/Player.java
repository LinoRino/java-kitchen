package models;

import models.foods.Fish;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class Player extends Storage {
    public final String name;

    public Player(String name) {
        super(36);
        this.name = name;
    }

    public Optional<Fish> fish() throws InterruptedException {
        Notification.progress(String.format("%s is fishing", this.name));
        Random random = new Random();
        int randomInt = random.nextInt(100);
        Thread.sleep(800);
        if (randomInt < 50) {
            Notification.fail(String.format("%s failed to fish.", this.name));
            return Optional.empty();
        }
        Notification.success(String.format("%s successfully fished.", this.name));
        return Optional.of(new Fish());
    }
}
