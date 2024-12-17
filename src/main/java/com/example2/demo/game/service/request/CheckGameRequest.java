package com.example2.demo.game.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CheckGameRequest {
    private final int gameId;
}