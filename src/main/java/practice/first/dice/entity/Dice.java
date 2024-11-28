package practice.first.dice.entity;

import lombok.Getter;

@Getter
public class Dice {
    private int number;
    private int id;

    public Dice(int number, int id) {
        this.number = number;
        this.id = id;
    }

    public int getDiceNumber() {
        return this.number;
    }

}
