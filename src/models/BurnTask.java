package models;

public class BurnTask extends Thread {
    private final Furnace furnace;

    public BurnTask(Furnace furnace) {
        this.furnace = furnace;
    }

    @Override
    public void run() {
        System.out.printf("Burning %s with %s...\n", furnace.getIngredient().getName(), furnace.getClass().getSimpleName());
        for (int i = 0; i < Furnace.maxProgress; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.furnace.increaseProgress(1);
            System.out.printf("Progress: %d/%d\n", this.furnace.getProgress(), Furnace.maxProgress);
        }
        System.out.println("Done!");
    }
}
