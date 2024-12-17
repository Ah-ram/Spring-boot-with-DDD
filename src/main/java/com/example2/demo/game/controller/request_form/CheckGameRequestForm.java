package com.example2.demo.game.controller.request_form;

import com.example2.demo.game.service.request.CheckGameRequest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CheckGameRequestForm {
    private final int gameId;

    public CheckGameRequest toCheckGameRequest() {
        return new CheckGameRequest(this.gameId);
    }
}