package practice.first.dice.repository;

import org.springframework.stereotype.Repository;
import practice.first.dice.entity.Dice;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DiceRepositoryImpl implements DiceRepository {
    List<Dice> diceList = new ArrayList<>();
    int diceCount = 0;

    final int MIN = 1;
    final int MAX = 6;

    private int createdRandomNumber() {
        int randomNumber = (int) (Math.random() * MAX) + MIN;
        return randomNumber;
    }

    @Override
    public Dice rollDice() {
        int randomNumber = createdRandomNumber();
        int diceId = ++diceCount;
        Dice dice = new Dice(randomNumber, diceId);

        diceList.add(dice);

        return dice;
    }

    @Override
    public List<Dice> diceList() {
        return diceList;
    }
}
