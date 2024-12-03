package practice.second.game.controller.request_form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.second.game.service.request.RecordGameWinnerRequest;

@Getter
@RequiredArgsConstructor
public class RecordGameWinnerRequestForm {
    private final Long gameId;

    public RecordGameWinnerRequest toRecordGameWinnerRequest() {
        return new RecordGameWinnerRequest(this.gameId);
    }
}