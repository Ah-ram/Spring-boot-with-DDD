package com.example2.demo.game.service.response;

import com.example2.demo.game.entity.Game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateSimpleGameResponse {
    private final int gameId;
    private final boolean success;

    public static CreateSimpleGameResponse from(int gameId) {
        if (gameId <= 0) {
            return new CreateSimpleGameResponse(-1, false);
        }

        return new CreateSimpleGameResponse(gameId, true);
    }
}