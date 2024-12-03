package practice.second.game.controller.response_form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.second.game.service.response.RecordGameWinnerResponse;

@Getter
@RequiredArgsConstructor
public class RecordGameWinnerResponseForm {
    private final String message;

    // RecordGameWinnerResponse를 받아서 RecordGameWinnerResponseForm을 생성하는 메서드
    public static RecordGameWinnerResponseForm from(RecordGameWinnerResponse response) {
        return new RecordGameWinnerResponseForm(response.getMessage());
    }
}