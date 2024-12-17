package com.example2.demo.game.repository;

import com.example2.demo.game.entity.Game;

import java.util.List;
import java.util.Optional;

public interface GameRepository {
    int create(List<Integer> playerIdList);
    Optional<Game> findById(int gameId);
    void recordGame(int gameId, int winnerId);
}