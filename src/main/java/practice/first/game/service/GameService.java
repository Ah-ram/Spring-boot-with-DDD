package practice.first.game.service;

import practice.first.game.entity.Game;

public interface GameService {
    Game createGame();
    String play(int gameId);
    String getWinner(int gameId);
}
