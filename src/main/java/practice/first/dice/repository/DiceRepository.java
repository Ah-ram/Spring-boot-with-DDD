package practice.first.dice.repository;

import practice.first.dice.entity.Dice;

import java.util.List;

public interface DiceRepository {
    Dice rollDice();
    List<Dice> diceList();
}
