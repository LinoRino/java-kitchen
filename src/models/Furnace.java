package models;

public class Furnace implements Runnable {
    private boolean isLit = false;
    private int progress = 0;
    public static final int maxProgress = 10;
    private Ingredient ingredient;

    public Furnace() {
        this.ingredient = null;
    }

    public void put(Ingredient ingredient) {
        if (this.getStatus() != FurnaceStatus.EMPTY) {
            throw new IllegalStateException("Furnace is not empty");
        }
        if (ingredient == null) {
            throw new IllegalArgumentException("Ingredient cannot be null");
        }
        this.ingredient = ingredient;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public int getProgress() {
        return progress;
    }

    public void increaseProgress(int progress) {
        if (this.getStatus() != FurnaceStatus.BURNING) {
            throw new IllegalStateException("Furnace is not burning");
        }
        if (progress < 0) {
            throw new IllegalArgumentException("Progress cannot be negative");
        }
        if (this.progress + progress > maxProgress) {
            throw new IllegalArgumentException("Progress cannot exceed max progress");
        }
        this.progress += progress;
    }

    public FurnaceStatus getStatus() {
        if (this.ingredient == null) {
            return FurnaceStatus.EMPTY;
        }
        if (this.isLit && this.progress < maxProgress) {
            return FurnaceStatus.BURNING;
        }
        if (progress > maxProgress) return FurnaceStatus.BURNT;
        return FurnaceStatus.FULL;
    }

    public void run() {
        if (getStatus() != FurnaceStatus.FULL) {
            throw new IllegalStateException("Furnace is not full");
        }
        if (!(ingredient instanceof Burnable burnable)) {
            throw new IllegalStateException("Ingredient is not roastable");
        }
        isLit = true;
        System.out.printf("Burning %s with %s...\n", getIngredient().getName(), getClass().getSimpleName());
        for (int i = 0; i < Furnace.maxProgress; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            increaseProgress(1);
            System.out.printf("Progress: %d/%d\n", getProgress(), Furnace.maxProgress);
        }
        System.out.println("Done!");
        ingredient = burnable.onBurn(this);
    }

}
