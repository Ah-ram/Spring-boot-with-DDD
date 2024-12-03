package practice.second.dice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.second.dice.entity.Dice;
import practice.second.dice.repository.DiceRepository;

@Service
@RequiredArgsConstructor
public class DiceServiceImpl implements DiceService{
    final private DiceRepository diceRepository;

    @Override
    public Dice rollDice() {
        long randomNumber = (long)(Math.random() * 6) + 1;
        Dice dice = new Dice(randomNumber);
        Dice createdDice = diceRepository.save(dice);

        return createdDice;
    }
}
