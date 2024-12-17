package com.example2.demo.dice.repository;

import com.example2.demo.dice.entity.Dice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiceRepository extends JpaRepository<Dice, Long> {
}
