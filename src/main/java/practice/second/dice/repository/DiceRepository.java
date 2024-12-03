package practice.second.dice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.second.dice.entity.Dice;

public interface DiceRepository extends JpaRepository<Dice, Long> {
}
