package practice.first.dice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.first.dice.entity.Dice;
import practice.first.dice.repository.DiceRepository;

@Service
@RequiredArgsConstructor
public class DiceServiceImpl implements DiceService {
    final private DiceRepository diceRepository;

    @Override
    public Dice rollDice() {
        return diceRepository.rollDice();
    }
}
