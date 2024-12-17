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
        long randomNumber = (long)(Math.random() * 6) + 1; // Math.random()을 이용해 주사위 값(1~6) 랜덤 생성
        Dice dice = new Dice(randomNumber);  // dice 객체 생성, Dice 클래스의 생성자 호출하며 주사위의 number 값 초기화
        Dice createdDice = diceRepository.save(dice);  // 생성된 dice 객체 저장

        return createdDice;
    }
}
