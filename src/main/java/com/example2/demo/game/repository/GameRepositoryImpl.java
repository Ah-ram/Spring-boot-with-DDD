package com.example2.demo.game.repository;

import com.example2.demo.game.entity.Game;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GameRepositoryImpl implements GameRepository {
    static List<Game> gameList = new ArrayList<>();

    @Override
    public int create(List<Integer> playerIdList) {
        Game game = new Game(playerIdList);
        gameList.add(game);

        return game.getId();
    }

    @Override
    public Optional<Game> findById(int gameId) {

        return gameList.stream()
                .filter(game -> game.getId() == gameId)
                .findFirst();
    }

    @Override
    public void recordGame(int gameId, int winnerId) {
        Game game = gameList.get(gameId - 1);
        game.setWinner(winnerId);
    }
}