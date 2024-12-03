package practice.second.game.controller.request_form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.second.game.service.request.CheckGameRequest;

@Getter
@RequiredArgsConstructor
public class CheckGameRequestForm {
    private final Long gameId;

    public CheckGameRequest toCheckGameRequest() {
        return new CheckGameRequest(this.gameId);
    }
}