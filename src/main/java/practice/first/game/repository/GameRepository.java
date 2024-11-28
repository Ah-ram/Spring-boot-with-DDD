package practice.first.game.repository;

import practice.first.game.entity.Game;

public interface GameRepository {
    Game create();
    Game findById(int gameId);
}
