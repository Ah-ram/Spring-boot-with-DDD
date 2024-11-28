package practice.first.game.repository;

import org.springframework.stereotype.Repository;
import practice.first.game.entity.Game;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GameRepositoryImpl implements GameRepository {
    List<Game> gameList = new ArrayList<>();
    int gameCount = 0;
    private Object game;

    @Override
    public Game create() {
        int gameId = ++gameCount;
        Game game = new Game(gameId);

        gameList.add(game);

        return game;
    }

    @Override
    public Game findById(int gameId) {
        return gameList.stream()
                .filter(game -> game.getGameId() == gameId)
                .findFirst()
                .orElse(null);
    }
}
