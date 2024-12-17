package com.example2.demo.game.controller.response_form;

import com.example2.demo.game.service.response.RecordGameWinnerResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RecordGameWinnerResponseForm {
    private final String message;

    // RecordGameWinnerResponse를 받아서 RecordGameWinnerResponseForm을 생성하는 메서드
    public static RecordGameWinnerResponseForm from(RecordGameWinnerResponse response) {
        return new RecordGameWinnerResponseForm(response.getMessage());
    }
}