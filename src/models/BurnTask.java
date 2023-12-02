package models;

public class BurnTask extends Thread {
    private final Furnace furnace;

    public BurnTask(Furnace furnace) {
        this.furnace = furnace;
    }

    @Override
    public void run() {
        while (this.furnace.getStatus() == FurnaceStatus.BURNING) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.furnace.increaseProgress(1);
        }
    }
}
