package practice.second.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.second.game.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}
