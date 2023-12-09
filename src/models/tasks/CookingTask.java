package models.tasks;

import models.Furnace;
import models.Storage;

public class CookingTask extends Thread{
    private final Furnace furnace;
    private final Storage storage;

    public CookingTask(Furnace furnace, Storage storage) {
        this.furnace = furnace;
        this.storage = storage;
    }

    @Override
    public void run() {
       furnace.run();
       storage.put(furnace.drop());
    }
}