package models;

public class CookingTask extends Thread{
    private final Furnace furnace;
    private final Player player;

    public CookingTask(Furnace furnace, Player player) {
        this.furnace = furnace;
        this.player = player;
    }

    @Override
    public void run() {
       furnace.run();
       player.put(furnace.drop());
    }
}