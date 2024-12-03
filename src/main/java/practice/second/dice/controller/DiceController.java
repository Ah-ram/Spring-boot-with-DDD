package practice.second.dice.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.second.dice.entity.Dice;
import practice.second.dice.service.DiceService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/second-practice")
public class DiceController {
    private final DiceService diceService;

    @GetMapping("/roll-dice")
    public Dice rollDice() {
        log.info("rollDice() called!");

        Dice acquiredDice = diceService.rollDice();

        return acquiredDice;
    }
}
