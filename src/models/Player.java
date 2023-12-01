package models;

public record Player(String name) {

    public void eat(Eatable eatable) {
        eatable.eat(this);
        System.out.printf("%s ate %s\n", this.name, eatable.getClass().getSimpleName());
    }
}
