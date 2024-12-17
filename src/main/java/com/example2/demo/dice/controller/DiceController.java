package com.example2.demo.dice.controller;

import com.example2.demo.dice.entity.Dice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example2.demo.dice.service.DiceService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/dice")
public class DiceController {
    final private DiceService diceService;

    @GetMapping("/test")
    public String diceTest() {
        log.info("diceTest() called");

        return "diceTest() called";
    }

    @GetMapping("/roll-dice")
    public Dice rollDice() {
        log.info("rollDice() called");

        Dice acquiredDice = diceService.rollDice();

        return acquiredDice;
    }
}