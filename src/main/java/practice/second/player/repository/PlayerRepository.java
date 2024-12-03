package practice.second.player.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.second.player.entity.Player;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByIdIn(List<Long> playerIdList);
}
