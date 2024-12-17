package practice.third.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.third.card.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
}
