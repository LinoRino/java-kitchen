package models;

public class BurnTask extends Thread {
    private Furnace furnace;

    public BurnTask(Furnace furnace) {
        this.furnace = furnace;
    }

    @Override
    public void run() {
        while (this.furnace.getStatus() == FurnanceStatus.BURNING) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.furnace.increaseProgress(1);
        }
    }
}
