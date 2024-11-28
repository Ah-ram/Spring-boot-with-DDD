package practice.first.player.repository;

import practice.first.player.entity.Player;

import java.util.List;

public interface PlayerRepository {
    Player create();
    List<Player> selectPlayer();
    List<Player> getPlayerList();
}
