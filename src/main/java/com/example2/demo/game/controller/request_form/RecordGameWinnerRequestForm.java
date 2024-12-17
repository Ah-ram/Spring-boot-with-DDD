package com.example2.demo.game.controller.request_form;

import com.example2.demo.game.service.request.RecordGameWinnerRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RecordGameWinnerRequestForm {
    private final int gameId;

    public RecordGameWinnerRequest toRecordGameWinnerRequest() {
        return new RecordGameWinnerRequest(this.gameId);
    }
}