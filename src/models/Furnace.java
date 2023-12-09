package models;

public class Furnace implements Runnable, Storable {
    private boolean isLit = false;
    private int progress = 0;
    public static final int maxProgress = 10;

    public Furnace(Ingredient inventory) {
        this.put(inventory);
    }

    public void put(Ingredient ingredient) {
        if (this.getStatus() != FurnaceStatus.EMPTY) {
            throw new IllegalStateException("Furnace is not empty");
        }
        if (ingredient == null) {
            throw new IllegalArgumentException("Ingredient cannot be null");
        }
        this.inventory.add(ingredient);
    }

    public Ingredient drop() {
        if (this.getStatus() != FurnaceStatus.BURNT) {
            throw new IllegalStateException("Furnace is not burnt");
        }
        return this.inventory.remove(0);
    }

    public Ingredient getInventory() {
        return inventory.get(0);
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
        if (this.inventory.isEmpty()) {
            return FurnaceStatus.EMPTY;
        }
        if (this.isLit) {
            if (progress >= maxProgress) return FurnaceStatus.BURNT;
            return FurnaceStatus.BURNING;
        }
        return FurnaceStatus.FULL;
    }

    public void run() {
        Ingredient ingredient = getInventory();
        if (getStatus() != FurnaceStatus.FULL) {
            throw new IllegalStateException("Furnace is not full");
        }
        if (!(ingredient instanceof Burnable burnable)) {
            throw new IllegalStateException("Ingredient is not roastable");
        }
        isLit = true;
        System.out.printf("Burning %s with %s...\n", ingredient.getName(), getClass().getSimpleName());
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
        inventory.set(0, burnable.onBurn(this));
    }

}
