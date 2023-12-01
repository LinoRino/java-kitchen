package models;

public class Player {
    public final String name;
    public final int id;
    public Player(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void eat(Eatable eatable) {
        eatable.eat(this);
        System.out.printf("%s ate %s\n", this.name, eatable.getName());
    }

}
