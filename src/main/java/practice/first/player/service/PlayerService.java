package practice.first.player.service;

import practice.first.player.entity.Player;

import java.util.List;

public interface PlayerService {
    Player createPlayer();
    List<Player> listPlayer();
}
